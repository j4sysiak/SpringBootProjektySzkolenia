package pl.jaceksysiak.hibernate.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
import javax.persistence.Subgraph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.jaceksysiak.hibernate.demo.entity.Course;
import pl.jaceksysiak.hibernate.demo.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class PerformanceTuningTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	@Autowired
	EntityManager em;

	@Test
	@Transactional
	public void creatingNPlusOneProblem() {
		System.out.println("Performance Testing is running ...");
		List<Course> courses = em.createNamedQuery("query_get_all_courses", Course.class).getResultList();
		for(Course course:courses) {
			logger.info("Course -> {} Students -> {}", course, course.getStudents());
		}
		System.out.println("Performance Testing finish ...");
	}
	
	
	@Test
	@Transactional
	public void solvingNPlusOneProblem_EntityGraph() {
		
		System.out.println("Performance Testing (solvingNPlusOneProblem_EntityGraph) is running ...");

		EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
		Subgraph<Object> subGraph = entityGraph.addSubgraph("students");
		
		List<Course> courses = em
				.createNamedQuery("query_get_all_courses", Course.class)
				.setHint("javax.persistence.loadgraph", entityGraph)
				.getResultList();
		
		for(Course course:courses){
			logger.info("Course -> {} Students -> {}",course, course.getStudents());
		}
		
		System.out.println("Performance Testing (solvingNPlusOneProblem_EntityGraph) finish ...");
	}
	
	
	
	@Test
	@Transactional
	public void solvingNPlusOneProblem_JoinFetch() {
		
		System.out.println("Performance Testing (solvingNPlusOneProblem_JoinFetch) is running ...");
		
		List<Course> courses = em
				.createNamedQuery("query_get_all_courses_join_fetch", Course.class)
				.getResultList();
		for(Course course:courses){
			logger.info("Course -> {} Students -> {}",course, course.getStudents());
		}
		System.out.println("Performance Testing (solvingNPlusOneProblem_JoinFetch) finish ...");
	}
		
}
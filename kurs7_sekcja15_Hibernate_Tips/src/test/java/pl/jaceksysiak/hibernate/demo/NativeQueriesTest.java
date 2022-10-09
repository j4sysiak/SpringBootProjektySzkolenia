package pl.jaceksysiak.hibernate.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pl.jaceksysiak.hibernate.demo.entity.Course;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class NativeQueriesTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;
 
	
	@Test
	public void native_queries_basic() {
		Query query = em.createNativeQuery("select * from course", Course.class);
		List resultList = query.getResultList();
		logger.info("select * from course -> {}", resultList);
	}
	
	@Test
	public void native_queries_parameter() {
		Query query = em.createNativeQuery("select * from course where id = ?", Course.class);
		query.setParameter(1, 10000L);
		List resultList = query.getResultList();
		logger.info("select * from course where id = ? -> {}", resultList);
	}
	
	@Test
	public void native_queries_named_parameter() {
		Query query = em.createNativeQuery("select * from course where id = :id", Course.class);
		query.setParameter("id", 10000L);
		List resultList = query.getResultList();
		logger.info("select * from course where id = :id -> {}", resultList);
	}
	
	@Test
	@Transactional
	public void native_queries_update() {
		Query query = em.createNativeQuery("update course set last_updated_date=sysdate()", Course.class);
		int numberOfRows = query.executeUpdate();
		logger.info("numberOfRows -> ", numberOfRows);
	}

}

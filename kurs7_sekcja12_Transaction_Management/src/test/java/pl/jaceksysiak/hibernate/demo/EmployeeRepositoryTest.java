package pl.jaceksysiak.hibernate.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import pl.jaceksysiak.hibernate.demo.entity.Course;
import pl.jaceksysiak.hibernate.demo.entity.Review;
import pl.jaceksysiak.hibernate.demo.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class EmployeeRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;

}

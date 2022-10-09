package pl.jaceksysiak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.jaceksysiak.entity.Course;
import pl.jaceksysiak.entity.Student;

public class MainClass_CreateTablesAndData {
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			//----------- Create a Course
			Course tmpCourse1 = new Course("Hibernate technics for idiots");
			Course tmpCourse2 = new Course("Management for me");
			
			// save the course
			session.save(tmpCourse1);
			session.save(tmpCourse2);
			
		//-----------Create Student	
			Student tmpStudent1=new Student("Jack", "Sysiak", "jacek@wp.pl");
			Student tmpStudent2=new Student("Mark", "Knophler", "ajaja@wp.pl");
			
		// Add Student to the Course
			tmpCourse1.addStudent(tmpStudent1);
			tmpCourse2.addStudent(tmpStudent1);
			tmpCourse1.addStudent(tmpStudent2);
			
			// save students
			session.save(tmpStudent1);
			session.save(tmpStudent2);
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			
			// add clean up code
			session.close();			
			factory.close();
		}
	}
}

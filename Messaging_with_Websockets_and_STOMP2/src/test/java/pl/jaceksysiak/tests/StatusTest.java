package pl.jaceksysiak.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
import javax.transaction.Transactional;

import pl.jaceksysiak.model.entity.StatusUpdate;
import pl.jaceksysiak.model.repository.StatusUpdateDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:test.properties")
//@WebAppConfiguration
@Transactional  //jeżeli zakomentowane, to dane z testu będą w bazie
public class StatusTest {
	
	@Autowired
	private StatusUpdateDao statusUpdateDao;

	@Test
	public void testSave() {

		StatusUpdate status = new StatusUpdate("This is a test status update.");
		
		statusUpdateDao.save(status);
		
		assertNotNull("Non-null ID", status.getId());
 		assertNotNull("Non-null Date", status.getAdded());
 		
 		Optional <StatusUpdate> retrievedOptional = statusUpdateDao.findById(status.getId());
 		StatusUpdate retrieved = retrievedOptional.get();
 		
 	    assertEquals("Matching StatusUpdate", status, retrieved);
	}
	
	@Test
	public void testFindLatest() {
		
		Calendar calendar = Calendar.getInstance();
		
		StatusUpdate lastStatusUpdate = null;
		
		for(int i=0; i<10; i++) {
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			
			StatusUpdate status = new StatusUpdate("Status update " + i, calendar.getTime());
			
			statusUpdateDao.save(status);
			
			lastStatusUpdate = status;
		}
		
		StatusUpdate retrieved = statusUpdateDao.findFirstByOrderByAddedDesc();
		
		assertEquals("Latest status update", lastStatusUpdate, retrieved);
	}
}


















package pl.jaceksysiak.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.jaceksysiak.model.entity.Interest;
import pl.jaceksysiak.model.entity.Profile;
import pl.jaceksysiak.model.entity.SiteUser;
import pl.jaceksysiak.service.InterestService;
import pl.jaceksysiak.service.ProfileService;
import pl.jaceksysiak.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:test.properties")
//@WebAppConfiguration
@Transactional  //jeżeli zakomentowane, to dane z testu będą w bazie
public class ProfileControllerRestTest {

	@Autowired
	private UserService userService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private InterestService interestService;

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
//	@Test
//	@WithMockUser(username = "test@wp.pl") 
//	public void testSaveAndDeleteInterest() throws Exception {
//		
//		String interestText = "some interest_here";
//		
//		mockMvc.perform(post("/save-interest").param("name", interestText)).andExpect(status().isOk());
//		
//	}

	@Test
	@WithMockUser(username = "aa@wp.pl") 
	public void testSaveAndDeleteInterest() throws Exception {
		
		
		// 1. trzeba wyczyscic baze myFirstDB_test (delete all tabeles)
		// 2. zrobic przebieg zakładajacy tabele - we wszestkich klsach testowych @Transactional musi być odkomentowany
		// przebieg odpalamy poprzez: run  java application
		/* i potem odpalic ten skrytp zakładajacy dane do mocka
INSERT INTO public.site_user
(id, email, enabled, firstname, "password", "role", surname)
VALUES(170, 'aa@wp.pl', true, 'aa', 'aa', 'ADMIN_ROLE', 'aa');


INSERT INTO public.interests
(id, interest_name)
VALUES(168, 'some interest here');


INSERT INTO public.profile
(id, about, photo_directory, photo_extension, photo_name, user_id)
VALUES(244, '', '', '', '', 170);

INSERT INTO public.profile_interests
(profile_id, interest_id)
VALUES(244, 168);
commit;
		 */
		
		
		//SiteUser user = new SiteUser("aa@wp.pl", "aa");
		//SiteUser user = new SiteUser("aa@wp.pl", "aa", "aa", "aa");
		//userService.register(user);
		//Profile profile = new Profile(user);
		
 		String interestText = "some interest here";
 		//Interest interest = interestService.createIfNotExists(interestText);
		//HashSet<Interest> interestSet = new HashSet<>();
		//interestSet.add(interest);
		
 
//		profile.setInterests(interestSet);
//		profileService.save(profile);
		
		mockMvc.perform(post("/save-interest").param("name", interestText)).andExpect(status().isOk());
		
 		Interest retInterest = interestService.get(interestText);
		
		assertNotNull("Interest should exist", retInterest);
 		assertEquals("Retrieved interest text should match", interestText, retInterest.getName());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		SiteUser user2 = userService.get(email);
		Profile profile2 = profileService.getUserProfile(user2);

 		assertTrue("Profile should contain interest", profile2.getInterests().contains(new Interest(interestText)));
 
 		mockMvc.perform(post("/delete-interest").param("name", interestText)).andExpect(status().isOk());
 
 		profile2 = profileService.getUserProfile(user2);
 
 		assertFalse("Profile should not contain interest", profile2.getInterests().contains(new Interest(interestText)));
		
	}
}












































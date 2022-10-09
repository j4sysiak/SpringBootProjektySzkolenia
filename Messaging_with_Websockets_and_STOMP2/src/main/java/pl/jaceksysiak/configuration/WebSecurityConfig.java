package pl.jaceksysiak.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import pl.jaceksysiak.service.SiteUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter   {
	
	@Autowired
	private SiteUserService siteUserService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// @formatter:off
		
		http
			.authorizeRequests()
				.antMatchers(
						"/",
						"/search",
						"/about",
						"/register",
						"/registrationconfirmed",
						"/invaliduser",
						"/expiredtoken",
						"/verifyemail",
						"/confirmregister",
						"/profilephoto/*"
						)
				.permitAll()
				.antMatchers(
					"/js/*",
					"/css/*",
					"/img/*")
				.permitAll()
				.antMatchers("/addstatus",
						"/editstatus",
						"/deletestatus",
						"/viewstatus")
				.hasRole("ADMIN")
				.antMatchers(
						"/webjars/**",
						"/chat/**",
						"/profile",
						"/profile/*",
						"/edit-profile-about",
						"/upload-profile-photo",
						"/save-interest",
						"/delete-interest",
						"/conversation/*",
						"/chatview/*",
						"/messages",
						"/markread"
						)
				.authenticated()
				.anyRequest()
				.denyAll()
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/", true)
				.permitAll()
				.and()
			.logout()
				.permitAll();
		
		// @formatter:on
	}
	
	
//	//@Override
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{    
//		
//		// @formatter:off
//	    auth
//	    .inMemoryAuthentication()
//	    .passwordEncoder(NoOpPasswordEncoder.getInstance())
//	            .withUser("aa")
//	            .password("aa")
//	            .roles("USER")
//	            .and()
//	            .withUser("jj")
//	            .password("jj")
//	            .roles("ADMIN");
//	    // @formatter:on
//	}
	
 
//	@Autowired
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		// @formatter:off
// 
//	    auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
//        .withUser("aa").password("aa").roles("USER").and()
//        .withUser("bb").password("bb").roles("ADMIN");
//	    
//	    // @formatter:on
//    }

 
	@Override
	//@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  
		auth.userDetailsService(siteUserService).passwordEncoder(passwordEncoder);
	}
	
}

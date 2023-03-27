package net.javaguides.springboot;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.Assert.*;


import java.util.Arrays;

import net.javaguides.springboot.model.Role;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
class SpringBootAppTests {
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
		
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void simpleRegistration() {
		String encoded_password = passwordEncoder.encode("pass123");
		
		User mUser = new User("Janhavi","Mishra","janhavi@gmail.com", encoded_password, Arrays.asList(new Role("ROLE_USER")));

		UserRegistrationDto user = new UserRegistrationDto("Janhavi","Mishra","janhavi@gmail.com", encoded_password);
		
		assertEquals(mUser.getFirstName(), user.getFirstName());
		assertEquals(mUser.getLastName(), user.getLastName());
		assertEquals(mUser.getEmail(), user.getEmail());
		assertEquals(mUser.getPassword(), user.getPassword());
	}
	
	@Test
	public void avoidInvalidEmail() {
		String encoded_password = passwordEncoder.encode("pass123");
	    Assertions.assertThrows(IllegalArgumentException.class, () -> userService.save(new UserRegistrationDto("Janhavi","Mishra","jangmail.com", encoded_password)));
	}

	@Test
	void contextLoads() {
	}

}

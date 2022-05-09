package com.busManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.busManagement.Dao.UserDao;
import com.busManagement.entity.User;
import com.busManagement.service.UserService;

@SpringBootTest
public class UserTest {
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserDao dao;
	
	//Test for adding a new user
	@Test
	public void testAddUser() {
		User user = new User();
		user.setUserName("user one");
		user.setPhone(123456789l);
		user.setEmail("userone@gmail.com");
		user.setPassword("user12345");
		when(dao.save(user)).thenReturn(user);
		assertEquals(user, userService.addUser(user));
	}
		
}

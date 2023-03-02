package com.example.User;

import com.example.User.exception.UserNOtFoundException;
import com.example.User.repository.UserRepository;
import com.example.User.service.UserService;
import com.example.User.user.User;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserApplicationTests {
	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;
	@Mock
	private User user;


	@Test
	void contextLoads() {
	}
	@Test
	void shouldReturnAllUser(){
		List<User>users=new ArrayList<>();
		user= User.build(0,"rajdhar","raj@gmail.com","55555555","male",22,"indian");
		users.add(user);
		when(userRepository.findAll()).thenReturn(List.of(user));

		List<User>userList=userService.getAllUser();
		assertThat(userList).isNotNull();
		assertThat(userList.size()).isEqualTo(3);


	}
	@Test
	void shouldReturnById()  {
		List<User>users=new ArrayList<>();
		user= User.build(0,"rajdhar","raj@gmail.com","55555555","male",22,"indian");
		users.add(user);
		when(userRepository.findByUserId(0)).thenReturn(user);
//		User user1=userService.getUser(user.getUserId()).get;
		assertThat(userService.getUser(0)).isEqualTo(user);
	}
	@Test
	void shouldDeleteById(){



	}




}

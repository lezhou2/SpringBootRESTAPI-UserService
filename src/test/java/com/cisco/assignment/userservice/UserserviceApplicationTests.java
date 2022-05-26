package com.cisco.assignment.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;

import io.swagger.annotations.ApiOperation;

//import org.junit.runner.RunWith;


import com.cisco.assignment.userservice.persistence.UserRepository;


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ApiOperation.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RestTeplateConfiguration restTemplate;

	@Autowired
	private UserRepository userRepository;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
	return "http://localhost:" + port;
	}

}

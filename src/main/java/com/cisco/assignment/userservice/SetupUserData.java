package com.cisco.assignment.userservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.UUID;
import javax.transaction.Transactional;

import com.cisco.assignment.userservice.mapper.UserMapper;
import com.cisco.assignment.userservice.model.User;
import com.cisco.assignment.userservice.persistence.UserRepository;
import com.cisco.assignment.userservice.persistence.UserEntity;

public class SetupUserData implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SetupUserData.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        logger.info("initializing users");

        User u1 = new User();
        u1.setUserId(UUID.fromString("93f3ed0a-92bd-4c82-ba0e-c098111cef59"));
        u1.setUserName("john_user");
        u1.setEmailAddress("john@example.com");
        u1.setPreferredPhoneNumber("+353881234567");
        UserEntity u1Entity = UserMapper.INSTANCE.mapTo(u1);
        userRepository.save(u1Entity);

        User u2 = new User();
        u2.setUserId(UUID.fromString("93f3ed0a-92bd-4c82-ba0e-c098111cef60"));
        u2.setUserName("smith_user");
        u2.setEmailAddress("smith@example.com");
        u2.setPreferredPhoneNumber("+353881234568");
        UserEntity u2Entity = UserMapper.INSTANCE.mapTo(u2);
        userRepository.save(u2Entity);

        User u3 = new User();
        u3.setUserId(UUID.fromString("93f3ed0a-92bd-4c82-ba0e-c098111cef61"));
        u3.setUserName("david_user");
        u3.setEmailAddress("davidh@example.com");
        u3.setPreferredPhoneNumber("+353881234569");
        UserEntity u3Entity = UserMapper.INSTANCE.mapTo(u1);
        userRepository.save(u3Entity);
    }

    
}




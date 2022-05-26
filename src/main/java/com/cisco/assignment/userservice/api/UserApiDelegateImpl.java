package com.cisco.assignment.userservice.api;

import java.util.UUID;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import com.cisco.assignment.userservice.mapper.UserMapper;
import com.cisco.assignment.userservice.model.User;
import com.cisco.assignment.userservice.persistence.UserEntity;
import com.cisco.assignment.userservice.persistence.UserRepository;
import com.cisco.assignment.userservice.util.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j // lombok
@Service
public class UserApiDelegateImpl implements UserApiDelegate {
    
    private static final Logger log = null;
    @Autowired
    private UserRepository userRepository;
  
    public ResponseEntity<User> addUser(User user) {
       // log.info("in addUser: ");
        UUID userId = UUID.randomUUID();
        user.setUserId(userId);
        UserEntity userEntity = UserMapper.INSTANCE.mapTo(user);
       // log.debug("test debug log : "+userEntity.toString());
    
        try{
            UserEntity savedUser = userRepository.save(userEntity);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }           
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }       
    }
    
    public ResponseEntity<Void> deleteUser(String userId) {
        StringToUserIdConverter converter = new StringToUserIdConverter();
        UUID userIdUUID = (converter.convert(userId)).getId();
        try{
            UserEntity userEntity = userRepository.findById(userIdUUID)
                                                .get();
            HttpStatus status = (userEntity != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
            UUID userEntityId = userEntity.getUserId();
            userRepository.deleteById(userEntityId);
           
            return new ResponseEntity<>(status);
        } 
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

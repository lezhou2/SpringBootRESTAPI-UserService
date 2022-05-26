package com.cisco.assignment.userservice.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cisco.assignment.userservice.mapper.UserMapper;
import com.cisco.assignment.userservice.model.User;
import com.cisco.assignment.userservice.persistence.UserEntity;
import com.cisco.assignment.userservice.persistence.UserRepository;


@Service
public class UsersApiDelegateImpl implements UsersApiDelegate {
    @Autowired
    private UserRepository userRepository;
   
    public ResponseEntity<List<User>> listUsers() {
        try {
            ArrayList<UserEntity> userEntityArrayList = new ArrayList<UserEntity>();
            ArrayList<User> userArrayList = new ArrayList<User>(); 
            userRepository.findAll().forEach(userEntityArrayList::add);
            
            if (userEntityArrayList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else{
                    for (UserEntity ue: userEntityArrayList){  
                        User user = UserMapper.INSTANCE.mapTo(ue);
                        userArrayList.add(user);		  
                    }
                    return new ResponseEntity<>(userArrayList, HttpStatus.OK);
            }
          } 
          catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }   
    }
}
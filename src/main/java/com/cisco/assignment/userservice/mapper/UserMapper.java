package com.cisco.assignment.userservice.mapper;

import org.mapstruct.factory.Mappers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.cisco.assignment.userservice.persistence.UserEntity;
import com.cisco.assignment.userservice.model.User;

@Mapper
public interface UserMapper {
	
	public static UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mappings({
		@Mapping(target = "userId", source = "userId"),
	})
	UserEntity mapTo(User user);
	
	@InheritInverseConfiguration
	User mapTo(UserEntity userEntity);	
}

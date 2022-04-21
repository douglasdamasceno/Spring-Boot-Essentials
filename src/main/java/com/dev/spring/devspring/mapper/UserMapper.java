package com.dev.spring.devspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dev.spring.devspring.domain.User;
import com.dev.spring.devspring.dtos.UserPostRequestBody;
import com.dev.spring.devspring.dtos.UserPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
	public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	public abstract User toUser(UserPostRequestBody userPostRequestBody);
	
	public abstract User toUser(UserPutRequestBody userPutRequestBody);
	
}

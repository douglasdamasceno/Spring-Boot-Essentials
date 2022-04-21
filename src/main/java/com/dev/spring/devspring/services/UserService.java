package com.dev.spring.devspring.services;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.spring.devspring.domain.User;
import com.dev.spring.devspring.dtos.UserPostRequestBody;
import com.dev.spring.devspring.dtos.UserPutRequestBody;
import com.dev.spring.devspring.exceptions.BadRequestException;
import com.dev.spring.devspring.mapper.UserMapper;
import com.dev.spring.devspring.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

    public List<User> listAll() {
		return userRepository.findAll();
	}
    
    public User findByIdOrThrowBadRequestException(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User ID not Found"));
    }
    @Transactional
    public User save(UserPostRequestBody userPostRequestBody) {
        return userRepository.save(UserMapper.INSTANCE.toUser(userPostRequestBody));
    }

    public void delete(long id) {
    	userRepository.delete(findByIdOrThrowBadRequestException(id));
    }
    
    public void update(UserPutRequestBody userPutRequestBody) {
        User savedAnime = findByIdOrThrowBadRequestException(userPutRequestBody.getId());
        User anime = UserMapper.INSTANCE.toUser(userPutRequestBody);
        anime.setId(savedAnime.getId());
        userRepository.save(anime);
    }
}

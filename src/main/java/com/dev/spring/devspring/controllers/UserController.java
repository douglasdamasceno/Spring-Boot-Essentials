package com.dev.spring.devspring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.dev.spring.devspring.domain.User;

import com.dev.spring.devspring.dtos.UserPostRequestBody;
import com.dev.spring.devspring.dtos.UserPutRequestBody;
import com.dev.spring.devspring.services.UserService;


import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

    
    @GetMapping
    public ResponseEntity<List<User>> listAll() {
    	return ResponseEntity.ok(userService.listAll());
    }
    //opcional mudar url
    @GetMapping(value = "/v2/", headers = "X-API-Version=v2")
    public ResponseEntity<List<User>> listAllV2() {
    	return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable long id) {
        return new ResponseEntity<>(userService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid UserPostRequestBody userPostRequestBody) {
        return new ResponseEntity<>(userService.save(userPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
    	userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody  @Valid UserPutRequestBody userPutRequestBody) {
    	userService.update(userPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

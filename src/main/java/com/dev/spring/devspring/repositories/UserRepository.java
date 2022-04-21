package com.dev.spring.devspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.spring.devspring.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

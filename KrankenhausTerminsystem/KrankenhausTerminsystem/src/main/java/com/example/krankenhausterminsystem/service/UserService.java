package com.example.krankenhausterminsystem.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.krankenhausterminsystem.model.User;
import com.example.krankenhausterminsystem.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}

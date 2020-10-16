package com.OnlineStore.OnlineStore.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.OnlineStore.OnlineStore.auth.UserRegistrationDto;
import com.OnlineStore.OnlineStore.models.entity.User;


public interface IUserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}

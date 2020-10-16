package com.OnlineStore.OnlineStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnlineStore.OnlineStore.models.entity.User;





@Repository
public interface UserRepository extends JpaRepository < User, Long > {
    User findByEmail(String email);
}
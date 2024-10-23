package com.ust.securityh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.securityh2.entity.User;

@Repository
public interface UserRepository extends   JpaRepository<User,Integer> {
    User findByUserName(String username);
}

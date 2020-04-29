package com.example.simple_twitter.repositories;

import com.example.simple_twitter.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);
  User findByActivationCode(String code);
}

package com.example.simple_twitter.controller;

import com.example.simple_twitter.domain.Role;
import com.example.simple_twitter.domain.User;
import com.example.simple_twitter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/registration")
  public String registration() {
    return "registration";
  }

  @PostMapping("/registration")
  public String addUser(User user, Map<String, Object> model) {
    User userFromDb = userRepository.findByUsername(user.getUsername());

    if (userFromDb != null) {
      model.put("message", "User exists!");
      return "registration";
    }

    user.setActive(true);
    user.setRoles(Collections.singleton(Role.USER));
    userRepository.save(user);

    return "redirect:/login";
  }
}

package com.example.simple_twitter.service;

import com.example.simple_twitter.domain.Role;
import com.example.simple_twitter.domain.User;
import com.example.simple_twitter.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Collections;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

  @Autowired
  private UserService userService;

  @MockBean
  private UserRepository userRepository;

  @MockBean
  private MailSender mailSender;

  @MockBean
  private PasswordEncoder passwordEncoder;

  @Test
  public void addUser() {
    User user = new User();
    user.setEmail("some@mail.ru");
    boolean isUserCreated = userService.addUser(user);

    assertTrue(isUserCreated);
    assertNotNull(user.getActivationCode());
    assertTrue(is(user.getRoles()).matches(Collections.singleton(Role.USER)));

    verify(userRepository, times(1)).save(user);
    verify(mailSender, times(1)).send(
        eq(user.getEmail()),
        eq("Activation code"),
        contains("Welcome to Simple Twitter.")
    );
  }

  @Test
  public void addUserFailTest() {
    User user = new User();
    user.setUsername("John");

    doReturn(new User())
        .when(userRepository)
        .findByUsername("John");

    boolean isUserCreated = userService.addUser(user);
    assertFalse(isUserCreated);

    verify(userRepository, times(0)).save(any(User.class));
    verify(mailSender, times(0)).send(
        anyString(),
        anyString(),
        anyString()
    );
  }

  @Test
  public void activateUser() {
    User user = new User();
    user.setActivationCode("bingo!");

    doReturn(user)
        .when(userRepository)
        .findByActivationCode("activate");

    boolean isUserActivated = userService.activateUser("activate");

    assertTrue(isUserActivated);
    assertNull(user.getActivationCode());
    verify(userRepository, times(1)).save(user);
  }

  @Test
  public void activateUserFailTest() {
    boolean isUserActivated = userService.activateUser("activate_me");
    assertFalse(isUserActivated);
    verify(userRepository, times(0)).save(any(User.class));
  }
}

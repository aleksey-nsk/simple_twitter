package com.example.simple_twitter.repositories;

import com.example.simple_twitter.domain.Message;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

// Create the Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

  List<Message> findByTag(String tag); // поиск в БД по тэгу
}

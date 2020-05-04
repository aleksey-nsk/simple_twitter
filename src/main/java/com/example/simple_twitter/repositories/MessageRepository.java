package com.example.simple_twitter.repositories;

import com.example.simple_twitter.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

// Create the Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

  Page<Message> findAll(Pageable pageable);

  Page<Message> findByTag(String tag, Pageable pageable); // поиск в БД по тэгу
}

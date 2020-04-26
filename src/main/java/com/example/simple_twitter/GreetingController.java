package com.example.simple_twitter;

import com.example.simple_twitter.domain.Message;
import com.example.simple_twitter.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
public class GreetingController {

  @Autowired
  private MessageRepository messageRepository;

  @GetMapping("/")
  public String greeting(Map<String, Object> model) { // в model складываем данные, которые хотим вернуть пользователю
    return "greeting"; // возвращаем имя файла, который хотим отобразить
  }

  @GetMapping("/main")
  public String main(Map<String, Object> model) {
    Iterable<Message> messages = messageRepository.findAll();
    model.put("messages", messages);
    return "main";
  }

  @PostMapping("/main")
  public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
    Message message = new Message(text, tag);
    messageRepository.save(message);

    Iterable<Message> messages = messageRepository.findAll();
    model.put("messages", messages);

    return "main";
  }

  @PostMapping("filter")
  public String filter(@RequestParam String filter, Map<String, Object> model) {
    Iterable<Message> messages;

    if (filter != null && !filter.isEmpty()) {
      messages = messageRepository.findByTag(filter);
    } else {
      messages = messageRepository.findAll();
    }

    model.put("messages", messages);
    return "main";
  }
}

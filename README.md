# Info:
1. Проект **Simple Twitter** - простой клон Twitter-а
2. Написан на **Java + Spring**
3. Написан в процессе разбора скринкастов на youtube-канале [letsCode](https://www.youtube.com/channel/UC1g3kT0ZcSXt4_ZyJOshKJQ/featured)

# Что было использовано:
- Spring Boot
- Spring MVC
- Spring Data JPA
- Postgresql
- Spring Security
- Шаблонизатор FreeMarker
- Bootstrap
- Spring Boot Mail Starter (для отправки email с помощью Spring)
- Flyway (это инструмент для миграции БД)
- Hamcrest
- Mockito

# Реализованный функционал:
1. **Сохранение твитов (текст, тэг, картинка):**
![](https://github.com/aleksey-nsk/simple_twitter/blob/master/screenshots/1_save_tweets.png)

2. **Просмотр твитов (возможность фильтрации по тэгу).**
3. **Отдельно просмотр и редактирование своих собственных сообщений.**
4. **Регистрация пользователей (reCAPTCHA, валидация полей, активация аккаунта через почтовый ящик):**
![](https://github.com/aleksey-nsk/simple_twitter/blob/master/screenshots/4_registr_new_user.png)

5. **Добавлена роль Администратор (имеет право на просмотр списка пользователей, и редактирование их ролей):**
![](https://github.com/aleksey-nsk/simple_twitter/blob/master/screenshots/5_admin_role.png)

6. **У пользователей есть возможность редактировать свои профили (пароль, email).**
7. **Подписки и подписчики:**
![](https://github.com/aleksey-nsk/simple_twitter/blob/master/screenshots/7_subscribe.png)

8. **Добавлено интеграционное тестирование, и юнит тестирование.**
9. **Пагинация.**

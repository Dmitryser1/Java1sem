# Library Management System REST API

RESTful веб-сервис для управления библиотечными ресурсами, разработанный с использованием Spring Framework.

## Технологии

- Java 17
- Spring Framework 6.1.2
- Spring Data JPA
- PostgreSQL
- Maven
- Jackson (JSON/XML)
- XSLT

## Почему Spring REST вместо JAX-RS?

1. **Интеграция с экосистемой Spring:**
   - Бесшовная интеграция с существующими Spring компонентами
   - Единый подход к конфигурации
   - Согласованное управление зависимостями

2. **Простота использования:**
   - Меньше конфигурации
   - Интуитивно понятные аннотации
   - Автоматическая сериализация/десериализация

3. **Богатая функциональность:**
   - Встроенная поддержка контент-негоциации
   - Гибкая обработка исключений
   - Расширенная валидация

## Установка и настройка

1. **Требования:**
   - JDK 17
   - Maven 3.8+
   - PostgreSQL 12+
   - Apache Tomcat 10.1

2. **Настройка базы данных:**
   ```sql
   CREATE DATABASE library;
   ```

3. **Конфигурация:**
   - Отредактируйте `src/main/webapp/WEB-INF/applicationContext.xml`:
     ```xml
     <property name="url" value="jdbc:postgresql://localhost:5432/library"/>
     <property name="username" value="your_username"/>
     <property name="password" value="your_password"/>
     ```

4. **Сборка:**
   ```bash
   mvn clean install
   ```

5. **Развертывание:**
   - Скопируйте WAR файл в директорию webapps Tomcat
   - Или разверните через IDE

## API Endpoints

### Авторы

- **GET** `/api/authors` - Получить список всех авторов
- **GET** `/api/authors/{id}` - Получить автора по ID
- **POST** `/api/authors` - Создать нового автора
- **PUT** `/api/authors/{id}` - Обновить существующего автора
- **DELETE** `/api/authors/{id}` - Удалить автора

### Книги

- **GET** `/api/books` - Получить список всех книг
- **GET** `/api/books/{id}` - Получить книгу по ID
- **POST** `/api/books` - Создать новую книгу
- **PUT** `/api/books/{id}` - Обновить существующую книгу
- **DELETE** `/api/books/{id}` - Удалить книгу

## Форматы данных

API поддерживает как JSON, так и XML форматы. Укажите желаемый формат через:

1. **Query параметр:**
   ```
   /api/books?format=json
   /api/books?format=xml
   ```

2. **Accept заголовок:**
   ```
   Accept: application/json
   Accept: application/xml
   ```

## XSLT Преобразования

Для XML ответов доступно XSLT преобразование в HTML:

- `/api/authors?format=xml` - Список авторов в HTML формате
- `/api/books?format=xml` - Список книг в HTML формате

## Примеры запросов

### Создание автора (JSON)
```bash
curl -X POST http://localhost:8080/library/api/authors \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Лев",
    "lastName": "Толстой",
    "birthDate": "1828-09-09",
    "nationality": "Russian"
  }'
```

### Создание книги (JSON)
```bash
curl -X POST http://localhost:8080/library/api/books \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Война и мир",
    "isbn": "9785170878872",
    "publicationYear": 1869,
    "availableCopies": 5,
    "author": {
      "id": 1
    }
  }'
```

## Безопасность

В текущей версии аутентификация и авторизация не реализованы. Для продакшн использования рекомендуется добавить:

- Spring Security
- JWT токены
- HTTPS

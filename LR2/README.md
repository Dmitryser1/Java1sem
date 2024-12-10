# Лабораторная работа №2: Spring Framework Library Management System

Веб-приложение для управления библиотекой, разработанное с использованием Spring Framework.

## Технологии

- Java 17
- Spring Framework 6.1.2
- Hibernate 6.4.1
- PostgreSQL 15
- Apache Tomcat 10.1.33
- Maven
- JSP/JSTL

## Предварительные требования

1. JDK 17
   - Скачайте и установите JDK 17 с [официального сайта Oracle](https://www.oracle.com/java/technologies/downloads/#java17)
   - Добавьте JAVA_HOME в системные переменные: `C:\Program Files\Java\jdk-17`
   - Добавьте `%JAVA_HOME%\bin` в PATH

2. Apache Tomcat 10.1.33
   - Скачайте [Apache Tomcat 10.1.33](https://tomcat.apache.org/download-10.cgi)
   - Распакуйте в `C:\Program Files\Apache Software Foundation\Tomcat 10.1`
   - Добавьте CATALINA_HOME в системные переменные

3. PostgreSQL 15
   - Установите [PostgreSQL 15](https://www.postgresql.org/download/)
   - Запомните пароль для пользователя postgres
   - Убедитесь, что сервер запущен (порт 5432)

4. IntelliJ IDEA
   - Установите [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) (рекомендуется Ultimate версия)

## Настройка проекта

1. Клонирование репозитория:
   ```bash
   git clone <repository-url>
   cd library-spring
   ```

2. Настройка базы данных:
   ```sql
   CREATE DATABASE library;
   ```

3. Настройка IntelliJ IDEA:
   - Откройте проект
   - File -> Project Structure -> Project
     - Project SDK: выберите Java 17
     - Language level: 17
   - File -> Project Structure -> Modules
     - Убедитесь, что все папки правильно помечены:
       - `src/main/java` как Sources
       - `src/main/resources` как Resources
       - `src/main/webapp` как Web Resource Directory

4. Настройка Tomcat в IDEA:
   - File -> Settings -> Build, Execution, Deployment -> Application Servers
   - Нажмите '+' и выберите Tomcat Server
   - Укажите путь к Tomcat: `C:\Program Files\Apache Software Foundation\Tomcat 10.1`
   - Run -> Edit Configurations
   - Нажмите '+' -> Tomcat Server -> Local
   - В вкладке Deployment:
     - Нажмите '+' -> Artifact -> library-spring:war exploded
     - Application context: `/library`

## Сборка и запуск

1. Сборка проекта:
   ```bash
   mvn clean install
   ```

2. Запуск:
   - В IntelliJ IDEA нажмите на зеленый треугольник (Run)
   - Или используйте Shift + F10

3. Проверка:
   - Откройте браузер
   - Перейдите по адресу: http://localhost:8080/library
   - Должна отобразиться главная страница приложения

## Структура проекта

```
src/main/java/com/example/library/
├── controller/          # Spring MVC контроллеры
│   ├── AuthorController.java
│   └── BookController.java
├── model/              # Сущности
│   ├── Author.java
│   └── Book.java
├── repository/         # Репозитории для работы с БД
│   ├── AuthorRepository.java
│   └── BookRepository.java
└── service/           # Бизнес-логика
    ├── AuthorService.java
    └── BookService.java

src/main/webapp/
├── WEB-INF/
│   ├── views/         # JSP представления
│   ├── applicationContext.xml
│   ├── dispatcher-servlet.xml
│   └── web.xml
└── index.jsp
```

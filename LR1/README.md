# Library Management System

JavaEE приложение, демонстрирующее трехуровневую архитектуру с использованием IntelliJ IDEA и PostgreSQL.

## Предварительные требования

1. JDK 17 или выше
2. IntelliJ IDEA 2024 (Ultimate Edition)
3. PostgreSQL 12.x или выше
4. Maven 3.x

## Настройка проекта в IntelliJ IDEA

1. Установка PostgreSQL:
   - Скачайте и установите PostgreSQL с официального сайта
   - Создайте базу данных с именем 'library'
   - Запустите скрипт `src/main/resources/db/init.sql`

2. Импорт проекта:
   - Откройте IntelliJ IDEA
   - Выберите File -> Open
   - Укажите путь к папке проекта
   - Выберите Import as Maven project

3. Настройка сервера:
   - Откройте вкладку Database (правая панель)
   - Нажмите '+' -> Data Source -> PostgreSQL
   - Заполните данные подключения к БД
   - Проверьте подключение кнопкой "Test Connection"

4. Настройка запуска:
   - Откройте Run -> Edit Configurations
   - Нажмите '+' -> Tomcat Server -> Local
   - Выберите путь к Tomcat (если не установлен, скачайте)
   - На вкладке Deployment нажмите '+' -> Artifact
   - Выберите library-management:war exploded
   - Установите Application context: /library

5. Сборка и запуск:
   - Нажмите Build -> Build Project
   - Запустите проект зеленой кнопкой Run или Shift+F10

## Структура проекта

- `src/main/java/com/example/library`
  - `entity/` - JPA сущности (Book, Author)
  - `ejb/` - EJB бизнес-логика
  - `web/` - Сервлеты и веб-компоненты
- `src/main/resources` - Конфигурационные файлы
- `src/main/webapp` - Веб-ресурсы

## Доступ к приложению

После запуска приложение будет доступно по адресу: http://localhost:8080/library

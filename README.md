## Дополнительные файлы
1. **_Пакет запросов Postman_**: ![DC_Library.postman_collection.json](https://github.com/HaarDD/digital-chief-check-library/blob/feature/rest/additional-files/DC_Library.postman_collection.json) 
2. **_Бизнес-модель сущностей_**:
   + Google – ТЗ к тестовому заданию digital chief.docx
     https://docs.google.com/document/d/12c-vcGv2MyTJhftiwpEvj8BvTdy_TWiG/edit?usp=sharing&ouid=103874322013067777204&rtpof=true&sd=true
   + ![GitHub – ТЗ к тестовому заданию digital chief.docx](https://github.com/HaarDD/digital-chief-check-library/blob/feature/rest/additional-files/%D0%A2%D0%97%20%D0%BA%20%D1%82%D0%B5%D1%81%D1%82%D0%BE%D0%B2%D0%BE%D0%BC%D1%83%20%D0%B7%D0%B0%D0%B4%D0%B0%D0%BD%D0%B8%D1%8E%20digital%20chief.docx)

## Использованные зависимости:
* **_spring-boot-starter-web_**: поддержка веб-приложений Spring Boot, включая REST
* **_spring-boot-starter-data-jpa_**: поддержка работы с данными через JPA в Spring Boot.
* **_postgresql_**: драйвер PostgreSQL
* **_liquibase-core_**: создание миграций
* **_spring-boot-starter-actuator_**: для просмотра сущестующих URL'ов
* **_spring-boot-devtools_**: быстрая перезагрузка приложения
* **_springdoc-openapi-starter-webmvc-ui_**: для генерации OpenAPI/Swagger документации
* **_jackson-databind_**: преобразование POJO в json и наоборот
* **_lombok_**: упрощение написания POJO классов
* **_mapstruct_**: создание мапперов для преобразования классов (entity в dto и наоборот)
* **_hibernate-validator_**: валидация
* **_spring-boot-docker-compose_**: интеграция docker compose в spring boot

## Порядок запуска:
1. при наличии docker:
   ```
   docker-compose build
   docker-compose up
   ```
2. запуск без Docker
   1. проверить конфигурацию подключения к БД в файле `database.yaml`
   2. создать базу данных с именем "**digital_chief_check_library**"
   3. запустить `DigitalChiefCheckLibraryApplication` с профилем "**no_docker**"

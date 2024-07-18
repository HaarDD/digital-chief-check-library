## Дополнительные файлы
1. **_Бизнес-модель сущностей_**: ./additional-files/ТЗ к тестовому заданию digital chief.docx
2. **_Пакет запросов Postman_**: ./additional-files/DC_Library.postman_collection.json

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

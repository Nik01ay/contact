# Contact

Храниение контактов в postgres c web интерфейсом 


Используемые технологии:
1. Java 17.0.2
2. Spring Boot
3. Gradle
4. Lombok
5. Docker
6. PostgeSql


## Список функий Веб интерфейса
- `Create Contact` – кнопка для вызова окна создания контакта.
- `Edit` – ссылка для  высзова окна редактирования котакта
-  `Delete` – ссылка для удаления контакта

## Запуск
### запуск postgres через docker
Для запуска postgres через docker необходимо ввести в докере команду: 
`docker exec -it docker-postgres-1`
### запуск приложения
Для запуска приложения нужно запустить класс `ContactApplication`

## Параметры по умолчанию
postgres:
    `username: root`
    `password: root`
    `port: 5432`
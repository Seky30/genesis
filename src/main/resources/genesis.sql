-- genesis.users definition

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) DEFAULT NULL,
  `person_id` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uuid` varchar(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_unique` (`person_id`),
  UNIQUE KEY `user_unique_1` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO users (id, name, surname, person_id, uuid)
VALUES (19, 'Herry', 'Patter', 'kR0aZ7vW2nDl', '19f95754-79b5-4398-8338-6b46da38b25a');

INSERT INTO users (id, name, surname, person_id, uuid)
VALUES (21, 'Steaven', 'Black', 'aO8kP3mZ6dIw', 'b42f4889-4c85-4df4-803f-e42c3529961c');

INSERT INTO users (id, name, surname, person_id, uuid)
VALUES (22, 'Peter', 'Black', 'hM5bZ8nK4aVf', '2178b0c6-d9d8-4d43-85ff-e867daa12bca');

INSERT INTO users (id, name, surname, person_id, uuid)
VALUES (23, 'Martin', 'Koler', 'mY6sT1jA3cLz', 'df1f432f-ed09-4a6a-84b9-b8ab2f2bb936');

INSERT INTO users (id, name, surname, person_id, uuid)
VALUES (24, 'Martin', 'Novák', 'qE3lY6uT0vKd', 'ecf4d33c-8a79-48a0-a334-c4c67284b974');
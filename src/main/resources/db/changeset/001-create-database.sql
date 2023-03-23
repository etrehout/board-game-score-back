--liquibase formatted sql
--changeset efontaine:23032023
CREATE DATABASE IF NOT EXISTS board_game_score;

USE board_game_score;

CREATE TABLE IF NOT EXISTS user (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  surname VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS relationship (
  user1_id INT NOT NULL,
  user2_id INT NOT NULL,
  status ENUM('None','Pending','Friends') NOT NULL,
  PRIMARY KEY (user1_id, user2_id),
  FOREIGN KEY (user1_id) REFERENCES user(id),
  FOREIGN KEY (user2_id) REFERENCES user(id)
);

CREATE TABLE IF NOT EXISTS board_game (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  description TEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS game (
  id INT NOT NULL AUTO_INCREMENT,
  board_game_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (board_game_id) REFERENCES board_game(id)
);

CREATE TABLE IF NOT EXISTS score (
  game_id INT NOT NULL,
  user_id INT NOT NULL,
  score VARCHAR(50) NOT NULL,
  winner bit,
  PRIMARY KEY (game_id, user_id),
  FOREIGN KEY (game_id) REFERENCES user(id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE DATABASE bitcoin;
SHOW DATABASES;
USE bitcoin;
CREATE TABLE `Usuario` (
	`id` int NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(50) NOT NULL,
	`cpf` VARCHAR(14) NOT NULL,
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(100) NOT NULL,
	PRIMARY KEY(`id`)) ENGINE=InnoDB;
	
CREATE TABLE `Ordem` (
	`id` int NOT NULL AUTO_INCREMENT,
	`preco` decimal(6,2) NOT NULL,
	`tipo` VARCHAR(20) NOT NULL,
	`data` datetime NOT NULL,
	`status` VARCHAR(30) NOT NULL,
	`user_id` int NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`user_id`) REFERENCES `Usuario` (`id`)) ENGINE=InnoDB;
	
ALTER TABLE Usuario ADD COLUMN role VARCHAR (55);

INSERT INTO `Usuario` (`id`, `nome`, `cpf`, `username`, `password`, `role`) VALUES
(1, 'José Luan Brito', '43.633.362-3', 'jo', '$2a$10$mIZeHBJeFNdYKiMibfdHW.qsJ1KLuJU5q5bB73tXTJzLCZorpksj2', 'user'),
(2, 'Denis', '43.633.362-3', 'admin', '$2a$10$f0UH1CL3T7DIB.NRcSWyE.VwHqncjgNhhwQqn0fKyd/avy6i6gpY6', 'admin');

INSERT INTO `Ordem` (`id`, `preco`, `tipo`, `data`, `status`, `user_id`) VALUES
(1, '25.10', 'COMPRA', '2021-06-29 00:00:00', 'ENVIADA', 1),
(2, '185.10', 'COMPRA', '2021-06-29 00:00:00', 'ENVIADA', 1),
(3, '85.10', 'COMPRA', '2021-06-29 00:00:00', 'ENVIADA', 2);
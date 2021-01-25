INSERT INTO `test`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('1', '0001', 'Televisión', '1200', '100');
INSERT INTO `test`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('2', '0002', 'Proyector', '400', '50');
INSERT INTO `test`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('3', '0003', 'Monitor', '300', '30');
INSERT INTO `test`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('4', '0004', 'Headset', '150', '200');
INSERT INTO `test`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('5', '0005', 'Microondas', '1200', '100');
INSERT INTO `test`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('6', '0006', 'Calentador', '400', '50');
INSERT INTO `test`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('7', '0007', 'Horno', '300', '30');
INSERT INTO `test`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('8', '0008', 'Lavadora', '150', '200');

INSERT INTO `test`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('9', '0009', 'Radiador', '1200', '100');
INSERT INTO `test`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('10', '0010', 'Guitarra', '400', '50');
INSERT INTO `test`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('11', '0011', 'Mouse', '300', '30');
INSERT INTO `test`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('12', '0012', 'Keyboard', '150', '200');


INSERT INTO `test`.`user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES ('9001', 'a@a', 'Admin', 'Admin', '$2a$10$2DHv24iI/uwmLBoR1ObyKutZ.q9E/fGuJa2OZBOr6JFw/dA3KVZvm');
INSERT INTO `test`.`user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES ('9002', 'u@u', 'User', 'User', '$2a$10$2DHv24iI/uwmLBoR1ObyKutZ.q9E/fGuJa2OZBOr6JFw/dA3KVZvm');

INSERT INTO `test`.`role` (`id`, `name`) VALUES ('98', 'ROLE_USER');
INSERT INTO `test`.`role` (`id`, `name`) VALUES ('99', 'ROLE_USER');
INSERT INTO `test`.`role` (`id`, `name`) VALUES ('100', 'ROLE_ADMIN');


INSERT INTO `test`.`users_roles` (`user_id`, `role_id`) VALUES ('9002', '98');
INSERT INTO `test`.`users_roles` (`user_id`, `role_id`) VALUES ('9001', '99');
INSERT INTO `test`.`users_roles` (`user_id`, `role_id`) VALUES ('9001', '100');
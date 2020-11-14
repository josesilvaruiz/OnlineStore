INSERT INTO `onlinestore`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('1', '0001', 'Televisión', '1200', '100');
INSERT INTO `onlinestore`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('2', '0002', 'Proyector', '400', '50');
INSERT INTO `onlinestore`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('3', '0003', 'Monitor', '300', '30');
INSERT INTO `onlinestore`.`products` (`id`, `barcode`, `name`, `price`, `stock`) VALUES ('4', '0004', 'Headset', '150', '200');

INSERT INTO `onlinestore`.`user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES ('9001', 'a@a', 'Admin', 'Admin', '$2a$10$2DHv24iI/uwmLBoR1ObyKutZ.q9E/fGuJa2OZBOr6JFw/dA3KVZvm');
INSERT INTO `onlinestore`.`user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES ('9002', 'u@u', 'User', 'User', '$2a$10$2DHv24iI/uwmLBoR1ObyKutZ.q9E/fGuJa2OZBOr6JFw/dA3KVZvm');

INSERT INTO `onlinestore`.`role` (`id`, `name`) VALUES ('98', 'ROLE_USER');
INSERT INTO `onlinestore`.`role` (`id`, `name`) VALUES ('99', 'ROLE_USER');
INSERT INTO `onlinestore`.`role` (`id`, `name`) VALUES ('100', 'ROLE_ADMIN');


INSERT INTO `onlinestore`.`users_roles` (`user_id`, `role_id`) VALUES ('9002', '98');
INSERT INTO `onlinestore`.`users_roles` (`user_id`, `role_id`) VALUES ('9001', '99');
INSERT INTO `onlinestore`.`users_roles` (`user_id`, `role_id`) VALUES ('9001', '100');
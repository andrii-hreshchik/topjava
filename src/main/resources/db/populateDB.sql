DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (user_id, date_time, description, calories) VALUES
  (100000, '2018-03-22 08:30:00', 'breakfast', 400),
  (100000, '2018-03-22 14:30:00', 'dinner', 800),
  (100000, '2018-03-22 19:30:00', 'supper', 400),
  (100000, '2018-03-23 07:30:00', 'breakfast', 300),
  (100000, '2018-03-23 13:30:00', 'dinner', 1000),
  (100000, '2018-03-23 18:30:00', 'supper', 800);
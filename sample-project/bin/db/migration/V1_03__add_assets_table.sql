CREATE TABLE assets(
  id SERIAL PRIMARY KEY,
  file_name VARCHAR(255) NOT NULL,
  user_id INTEGER references users(id)
);

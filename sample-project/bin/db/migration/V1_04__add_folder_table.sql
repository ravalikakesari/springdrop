CREATE TABLE folders(
  id SERIAL PRIMARY KEY,
  folder_name VARCHAR(255) NOT NULL,
  user_id INTEGER references users(id),
  parent_id INTEGER REFERENCES folders(id)
);

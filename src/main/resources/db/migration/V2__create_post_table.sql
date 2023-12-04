CREATE TABLE Post (
                      id SERIAL PRIMARY KEY,
                      content TEXT,
                      created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
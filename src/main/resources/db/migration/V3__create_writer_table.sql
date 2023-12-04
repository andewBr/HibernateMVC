CREATE TABLE Writer (
                        id        SERIAL PRIMARY KEY,
                        firstName VARCHAR(50) NOT NULL,
                        lastName  VARCHAR(50) NOT NULL,
                        post_id INT,
                        FOREIGN KEY (post_id) references post(id)
);
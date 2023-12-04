CREATE TABLE Post_Label (
                            post_id  INT,
                            label_id INT,
                            PRIMARY KEY (post_id, label_id),
                            FOREIGN KEY (post_id) REFERENCES Post (id),
                            FOREIGN KEY (label_id) REFERENCES Label (id)
);
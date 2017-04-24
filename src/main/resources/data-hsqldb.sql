INSERT INTO cells (name) VALUES
    ('A3'),('B3'),('C3'),
    ('A2'),('B2'),('C2'),
    ('A1'),('B1'),('C1');

INSERT INTO statuses (name) VALUES
    ('IN_PROGRSS'), ('X_WON'), ('O_WON'), ('DRAW');

INSERT INTO games (name, status_id) VALUES
    ('Game1', 1);
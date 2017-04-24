INSERT INTO cells (name) VALUES
    ('A3'),('B3'),('C3'),
    ('A2'),('B2'),('C2'),
    ('A1'),('B1'),('C1');

INSERT INTO statuses (name) VALUES
    ('IN_PROGRESS'), ('X_WON'), ('O_WON'), ('DRAW');

INSERT INTO games (id, name, status_id) VALUES
    (1, 'Game1', 1),
    (2, 'Game2', 2),
    (3, 'Game3', 3);

INSERT INTO moves (game_id, number, cell_id) VALUES
    (1, 1, 7),
    (1, 2, 5);
INSERT INTO cells (name) VALUES
    ('A1'),('A2'),('A3'),
    ('B1'),('B2'),('B3'),
    ('C1'),('C2'),('C3');

INSERT INTO statuses (name) VALUES
    ('IN_PROGRESS'), ('X_WON'), ('O_WON'), ('DRAW');

-- INSERT INTO games (id, name, status_id) VALUES
--     (1, 'Game1', 1),
--     (2, 'Game2', 2),
--     (3, 'Game3', 3);
--
-- INSERT INTO moves (game_id, number, cell_id) VALUES
--     (1, 1, 7),
--     (1, 2, 5);
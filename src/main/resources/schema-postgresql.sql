DROP TABLE moves IF EXISTS;
DROP TABLE games IF EXISTS;
DROP TABLE statuses IF EXISTS;
DROP TABLE cells IF EXISTS;

DROP SEQUENCE statuses_seq IF EXISTS;
DROP SEQUENCE cells_seq IF EXISTS;
DROP SEQUENCE games_seq IF EXISTS;
DROP SEQUENCE moves_seq IF EXISTS;

CREATE SEQUENCE statuses_seq AS INTEGER START WITH 1;
CREATE SEQUENCE cells_seq AS INTEGER START WITH 1;
CREATE SEQUENCE games_seq AS INTEGER START WITH 1;
CREATE SEQUENCE moves_seq AS INTEGER START WITH 1;

CREATE TABLE statuses
(
  id              INTEGER GENERATED BY DEFAULT AS SEQUENCE statuses_seq PRIMARY KEY,
  name            VARCHAR(255)
);

CREATE TABLE cells
(
  id              INTEGER GENERATED BY DEFAULT AS SEQUENCE cells_seq PRIMARY KEY,
  name            VARCHAR(255)
);

CREATE TABLE games
(
  id              INTEGER GENERATED BY DEFAULT AS SEQUENCE games_seq PRIMARY KEY,
  name            VARCHAR(255),
  status_id       INTEGER      NOT NULL,
  FOREIGN KEY ( status_id ) REFERENCES statuses (id) ON DELETE CASCADE
);

CREATE TABLE moves
(
  id            INTEGER GENERATED BY DEFAULT AS SEQUENCE moves_seq PRIMARY KEY,
  game_id       INTEGER      NOT NULL,
  number        INTEGER      NOT NULL,
  cell_id       INTEGER      NOT NULL,
  FOREIGN KEY ( game_id ) REFERENCES games (id) ON DELETE CASCADE,
  FOREIGN KEY ( cell_id ) REFERENCES cells (id) ON DELETE CASCADE
);
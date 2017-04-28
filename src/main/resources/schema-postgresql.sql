DROP TABLE IF EXISTS moves;
DROP TABLE IF EXISTS games;
DROP TABLE IF EXISTS statuses;
DROP TABLE IF EXISTS cells;

DROP SEQUENCE IF EXISTS statuses_seq;
DROP SEQUENCE IF EXISTS cells_seq;
DROP SEQUENCE IF EXISTS games_seq;
DROP SEQUENCE IF EXISTS moves_seq;

CREATE SEQUENCE statuses_seq START WITH 1;
CREATE SEQUENCE cells_seq START WITH 1;
CREATE SEQUENCE games_seq START WITH 1;
CREATE SEQUENCE moves_seq START WITH 1;

CREATE TABLE statuses
(
  id              INTEGER PRIMARY KEY DEFAULT nextval('statuses_seq'),
  name            VARCHAR NOT NULL
);

CREATE TABLE cells
(
  id              INTEGER PRIMARY KEY DEFAULT nextval('cells_seq'),
  name            VARCHAR NOT NULL
);

CREATE TABLE games
(
  id              INTEGER PRIMARY KEY DEFAULT nextval('games_seq'),
  name            VARCHAR NOT NULL,
  status_id       INTEGER NOT NULL,
  FOREIGN KEY ( status_id ) REFERENCES statuses (id) ON DELETE CASCADE
);

CREATE TABLE moves
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('moves_seq'),
  game_id       INTEGER      NOT NULL,
  number        INTEGER      NOT NULL,
  cell_id       INTEGER      NOT NULL,
  FOREIGN KEY ( game_id ) REFERENCES games (id) ON DELETE CASCADE,
  FOREIGN KEY ( cell_id ) REFERENCES cells (id) ON DELETE CASCADE
);
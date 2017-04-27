package my.testtasks.games.dao;

import my.testtasks.games.model.Move;

import java.util.List;

/** Created by Grischenko Maxim on 23.04.17. */

public interface MoveDao {
    Move save(Move move, int gameId);

    List<Move> getAll(int gameId);
}

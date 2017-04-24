package my.testtasks.games.dao;

import my.testtasks.games.model.Move;

import java.util.List;

/** Created by Grischenko Maxim on 23.04.17. */

public interface MoveDao {
    Move save(Move move);

    // false if not found
    boolean delete(int id);

    // null if not found
    Move get(int id);

    List<Move> getAll();
}

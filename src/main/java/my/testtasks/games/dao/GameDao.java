package my.testtasks.games.dao;

import my.testtasks.games.model.Game;

import java.util.List;

/** Created by Grischenko Maxim on 23.04.17. */

public interface GameDao {
    Game save(Game game);

    // false if not found
    boolean delete(int id);

    // null if not found
    Game get(int id);

    List<Game> getAll();

}

package my.testtasks.games.service;

import my.testtasks.games.model.Cell;
import my.testtasks.games.model.Status;
import my.testtasks.games.util.NotFoundException;
import my.testtasks.games.model.Game;

import java.util.List;
import java.util.Map;

/** Created by Grischenko Maxim on 23.04.17. */

public interface GameService {
    Game save(Game game);

    void delete(int id) throws NotFoundException;

    Game get(int id) throws NotFoundException;

    List<Game> getAll();

    Game update(Game game);

    Status checkWin(Map<Cell, Integer> moves);
}

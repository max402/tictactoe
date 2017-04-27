package my.testtasks.games.service;

import my.testtasks.games.model.Cell;
import my.testtasks.games.model.Move;
import java.util.Map;

/** Created by Grischenko Maxim on 23.04.17. */

public interface MoveService {

    Move save(Move move, int gameId);

    Map<Cell, Integer> getAll(int gameId);

}

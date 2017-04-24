package my.testtasks.games.service;

import my.testtasks.games.util.NotFoundException;
import my.testtasks.games.model.Game;

import java.util.List;

/** Created by Grischenko Maxim on 23.04.17. */

public interface GameService {
    Game save(Game game);

    void delete(int id) throws NotFoundException;

    Game get(int id) throws NotFoundException;

    //void update(GameTo game);

    List<Game> getAll();

    void update(Game game);

}

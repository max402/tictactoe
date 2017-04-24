package my.testtasks.games.service;

import my.testtasks.games.util.NotFoundException;
import my.testtasks.games.model.Move;

import java.util.List;

/** Created by Grischenko Maxim on 23.04.17. */

public interface MoveService {

    Move save(Move game);

    void delete(int id) throws NotFoundException;

    Move get(int id) throws NotFoundException;

    //void update(MoveTo game);

    List<Move> getAll();

    void update(Move game);
}

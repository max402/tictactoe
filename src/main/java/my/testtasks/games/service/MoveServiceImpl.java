package my.testtasks.games.service;

import my.testtasks.games.util.NotFoundException;
import my.testtasks.games.model.Move;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by Grischenko Maxim on 23.04.17. */
@Service
public class MoveServiceImpl implements MoveService {
    @Override
    public Move save(Move game) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public Move get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public List<Move> getAll() {
        return null;
    }

    @Override
    public void update(Move game) {

    }
}

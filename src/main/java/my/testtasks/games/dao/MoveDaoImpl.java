package my.testtasks.games.dao;

import my.testtasks.games.model.Move;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Created by Grischenko Maxim on 23.04.17. */
@Repository
public class MoveDaoImpl implements MoveDao{
    public Move save(Move move) {
        return null;
    }

    public boolean delete(int id) {
        return false;
    }

    public Move get(int id) {
        return null;
    }

    public List<Move> getAll() {
        return null;
    }
}

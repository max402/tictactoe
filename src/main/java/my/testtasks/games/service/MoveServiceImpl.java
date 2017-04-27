package my.testtasks.games.service;

import my.testtasks.games.dao.MoveDao;
import my.testtasks.games.model.Cell;
import my.testtasks.games.model.Move;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/** Created by Grischenko Maxim on 23.04.17. */
@Service
public class MoveServiceImpl implements MoveService {
    @Autowired
    private MoveDao moveDao;


    @Override
    public Move save(Move move, int gameId) {
        return moveDao.save(move, gameId);
    }

    @Override
    public Map<Cell, Integer> getAll(int gameId) {
        Map<Cell, Integer> map = new HashMap<>();
        for(Move move : moveDao.getAll(gameId)) {
            map.put(move.getCell(), move.getNumber());
        }
        return map;
    }
}

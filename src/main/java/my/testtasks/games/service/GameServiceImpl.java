package my.testtasks.games.service;

import my.testtasks.games.util.NotFoundException;
import my.testtasks.games.dao.GameDao;
import my.testtasks.games.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by Grischenko Maxim on 23.04.17. */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;

    @Override
    public Game save(Game game) {
        return gameDao.save(game);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        gameDao.delete(id);
    }

    @Override
    public Game get(int id) throws NotFoundException {
        return gameDao.get(id);
    }

    @Override
    public List<Game> getAll() {
        return gameDao.getAll();
    }

    @Override
    public void update(Game game) {
        gameDao.save(game);
    }
}

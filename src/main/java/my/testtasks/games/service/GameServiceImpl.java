package my.testtasks.games.service;

import my.testtasks.games.model.Cell;
import my.testtasks.games.model.Status;
import my.testtasks.games.util.NotFoundException;
import my.testtasks.games.dao.GameDao;
import my.testtasks.games.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public Game update(Game game) {
        return gameDao.save(game);
    }

    public Status checkWin(Map<Cell, Integer> moves) {

        if(moves.size()==9) return Status.DRAW;

        Set<List<Cell>> cellSets = new HashSet<>();
        cellSets.add(Arrays.asList(Cell.A1, Cell.A2, Cell.A3));
        cellSets.add(Arrays.asList(Cell.B1, Cell.B2, Cell.B3));
        cellSets.add(Arrays.asList(Cell.C1, Cell.C2, Cell.C3));
        cellSets.add(Arrays.asList(Cell.A1, Cell.B1, Cell.C1));
        cellSets.add(Arrays.asList(Cell.A2, Cell.B2, Cell.C2));
        cellSets.add(Arrays.asList(Cell.A3, Cell.B3, Cell.C3));
        cellSets.add(Arrays.asList(Cell.A1, Cell.B2, Cell.C3));
        cellSets.add(Arrays.asList(Cell.C1, Cell.B2, Cell.A3));

        Set<Cell> movesX = new HashSet<>();
        Set<Cell> movesO = new HashSet<>();

        moves.forEach((k,v)->{
            if(v%2==0) {
                movesO.add(k);
            } else {
                movesX.add(k);
            }
        });

        for(List<Cell> cellSet:cellSets) {

            //check x
            if( movesX.contains(cellSet.get(0)) && movesX.contains(cellSet.get(1)) && movesX.contains(cellSet.get(2)) ) {
                return Status.X_WON;
            }

            //check o
            if( movesO.contains(cellSet.get(0)) && movesO.contains(cellSet.get(1)) && movesO.contains(cellSet.get(2)) ) {
                return Status.O_WON;
            }
        }

        return Status.IN_PROGRESS;

    }

}

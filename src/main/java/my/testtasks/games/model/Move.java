package my.testtasks.games.model;

/** Created by Grischenko Maxim on 23.04.17. */

public class Move {
    private Integer id;
    private int number;
    private Game game;
    private Cell cell;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}

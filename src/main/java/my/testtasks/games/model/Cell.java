package my.testtasks.games.model;

/** Created by Grischenko Maxim on 23.04.17. */

public enum Cell {
    A1(1),A2(2),A3(3),
    B1(4),B2(5),B3(6),
    C1(7),C2(8),C3(9);

    int id;

    Cell(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

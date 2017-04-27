package my.testtasks.games.model;

/** Created by Grischenko Maxim on 23.04.17. */

public enum Status {
    IN_PROGRESS(1, "In progress"),
    X_WON(2, "X won"),
    O_WON(3, "O won"),
    DRAW(4, "Draw");

    private final int id;
    private final String text;

    private Status(final int id, final String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return text;
    }
}

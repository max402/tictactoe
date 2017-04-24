package my.testtasks.games.model;

/** Created by Grischenko Maxim on 23.04.17. */

public enum Status {
    IN_PROGRESS("In progress"),
    X_WON("X won"),
    O_WON("O won"),
    DRAW("Draw");

    private final String text;

    private Status(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

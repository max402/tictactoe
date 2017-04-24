package my.testtasks.games.model;

/** Created by Grischenko Maxim on 23.04.17. */

public class Game {
    private Integer id;
    private String name;
    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isNew() {
        return (getId() == null);
    }
}

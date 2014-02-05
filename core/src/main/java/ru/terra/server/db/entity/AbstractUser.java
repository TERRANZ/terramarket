package ru.terra.server.db.entity;

/**
 * Date: 17.12.13
 * Time: 16:12
 */
public class AbstractUser {
    protected Integer id;
    protected int level;
    protected String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractUser(Integer id, int level, String name) {
        this.id = id;
        this.level = level;
        this.name = name;
    }
}

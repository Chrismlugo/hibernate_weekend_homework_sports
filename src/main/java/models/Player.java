package models;

import javax.persistence.Column;

public class Player extends Employee{
    private PlayerPosition position;

    public Player() {
    }

    public Player(String name, int salary, PlayerPosition position) {
        super(name, salary);
        this.position = position;
    }

    @Column(name="position")
    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }
}

package models;


import javax.persistence.*;

@Entity
@Table(name="players")
public class Player extends Employee{
    private PlayerPosition position;
    private Manager manager;



    public Player(String name, int salary, PlayerPosition position, Manager manager) {
        super(name, salary);
        this.position = position;
        this.manager = manager;

    }

    @Column(name="position")
    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="manager_id", nullable = false)
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }


}

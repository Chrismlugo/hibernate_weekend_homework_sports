package models;


import db.DBHelper;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="managers")
public class Manager extends Employee {
    private int budget;
    private Team team;
    private Set<Player> players;

    public Manager() {
    }

    public Manager(String name, int salary, int budget) {
        super(name, salary);
        this.budget = budget;
        this.players = new HashSet<Player>();


    }



    @Column(name="budget")
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void signPlayer(Player player){

            this.budget -= player.getSalary();
    }

    public void payWinBonus(){
        for(Player player : players){
            int oldSalary = player.getSalary();
            double bonus = oldSalary *0.02;
            double newSalary = oldSalary + bonus;
            player.setSalary((int)newSalary);
            budget -= bonus;
            DBHelper.saveOrUpdate(player);


        }
    }




}

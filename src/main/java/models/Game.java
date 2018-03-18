package models;

import db.DBHelper;

import java.util.Random;

public class Game {
    private Team opponent1;
    private int opponent1Score;
    private Team opponent2;
    private int opponent2Score;
    private Team winner;

    public Game() {
    }

    public Game(Team opponent1, Team opponent2) {
        this.opponent1 = opponent1;
        this.opponent1Score = 0;
        this.opponent2 = opponent2;
        this.opponent2Score = 0;
    }

    public int getOpponent1Score() {
        return opponent1Score;
    }

    public void setOpponent1Score(int opponent1Score) {
        this.opponent1Score = opponent1Score;
    }

    public int getOpponent2Score() {
        return opponent2Score;
    }

    public void setOpponent2Score(int opponent2Score) {
        this.opponent2Score = opponent2Score;
    }

    public Team getOpponent1() {
        return opponent1;
    }

    public void setOpponent1(Team opponent1) {
        this.opponent1 = opponent1;
    }

    public Team getOpponent2() {
        return opponent2;
    }

    public void setOpponent2(Team opponent2) {
        this.opponent2 = opponent2;
    }

    public void play(){
        Random ran = new Random();
        int randomNumber = ran.nextInt((5 - 0) + 1) + 0;
        setOpponent1Score(randomNumber);
        int randomNumber2 = ran.nextInt((5 - 0) + 1) + 0;
        setOpponent2Score(randomNumber2);
        if(opponent1Score > opponent2Score){
           winner = opponent1;
        }else{
            winner = opponent2;
        } if(opponent1Score == opponent2Score){
            opponent1.draw();
            DBHelper.saveOrUpdate(opponent1);
            opponent2.draw();
            DBHelper.saveOrUpdate(opponent2);
        }

        winner.win();
        DBHelper.saveOrUpdate(winner);

    }
}

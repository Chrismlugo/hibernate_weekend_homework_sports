import db.DBHelper;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        League league = new League("Premiership");
        DBHelper.saveOrUpdate(league);

Manager manager1 = new Manager("Chris Murphy", 65000, 1500000);
DBHelper.saveOrUpdate(manager1);

Manager manager2 = new Manager("Alex Ferguson", 55000, 5000000);
DBHelper.saveOrUpdate(manager2);


Team team1 = new Team("soccer united", 12, manager1, league);
DBHelper.saveOrUpdate(team1);


Team team2 = new Team("Man reds", 0, manager2, league);
DBHelper.saveOrUpdate(team2);

Player player1 = new Player("Pat Mccourt", 80000, PlayerPosition.MIDFIELDER, manager1);
DBHelper.saveOrUpdate(player1);


List<Team> foundTeams = DBHelper.getAll(Team.class);
Manager foundManager = DBHelper.find(Manager.class, manager2.getId());
League foundLeague = DBHelper.find(League.class,league.getId());






    }
}

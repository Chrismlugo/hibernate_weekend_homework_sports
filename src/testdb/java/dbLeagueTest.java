import db.DBHelper;
import models.League;
import models.Manager;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class dbLeagueTest {
    League league;
    Manager manager;
    Team team;

    @Before
    public void setUp() throws Exception {
        league = new League("PFL");
        manager = new Manager("chris", 120000, 4000000);
        team = new Team("the kickers", 5, manager, league);
        DBHelper.saveOrUpdate(league);
        DBHelper.saveOrUpdate(manager);
        DBHelper.saveOrUpdate(team);
    }

//    @Test
//    public void canAddTeam() {
//      League found = DBHelper.find(League.class,league.getId());
//       Team foundTeam = DBHelper.find(Team.class,team.getId());
//       DBHelper.addTeamToLeague(foundTeam,found);
//       assertEquals(1, found.getTeams().size());
//    }
}

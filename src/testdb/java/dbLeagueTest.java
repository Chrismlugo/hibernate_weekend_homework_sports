import db.DBHelper;
import models.League;
import models.Manager;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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


    @Test
    public void canSaveTeams() {
       List<Team> found = DBHelper.getTeamsInLeague(league);
       assertEquals(1, found.size());

    }

    @Test
    public void canRemoveTeams() {
      Team found =  DBHelper.find(Team.class,team.getId());
        DBHelper.delete(found);
        List<Team> teamList = DBHelper.getTeamsInLeague(league);
        assertEquals(0, teamList.size());
    }
}

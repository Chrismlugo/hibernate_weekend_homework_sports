import db.DBHelper;
import models.League;
import models.Manager;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class dbTeamTest {
    League league;
    Manager manager;
    Team team;


    @Before
    public void setUp() throws Exception {
        league = new League("PFL");
        DBHelper.saveOrUpdate(league);
        manager = new Manager("Chris Murphy", 65000, 1500000);
        DBHelper.saveOrUpdate(manager);

        team = new Team("soccer united", 12, manager, league);
        DBHelper.saveOrUpdate(team);
    }

    @Test
    public void canSave() {
        Team found = DBHelper.find(Team.class, team.getId());
        assertEquals(12, found.getPoints());
    }

    @Test
    public void canDelete() {
        Team newTeam = new Team("Bayern Munich", 10, manager,league);
        DBHelper.saveOrUpdate(newTeam);
        assertEquals(2, DBHelper.getAll(Team.class).size());
        DBHelper.delete(newTeam);
        assertEquals(1, DBHelper.getAll(Team.class).size());
    }

    @Test
    public void canGetTeamsLeague() {
        Team foundTeam = DBHelper.find(Team.class, team.getId());
        League foundLeague = DBHelper.find(League.class,league.getId());

        assertEquals("PFL", foundTeam.getLeague().getName());
    }
}

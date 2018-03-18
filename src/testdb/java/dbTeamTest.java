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

}

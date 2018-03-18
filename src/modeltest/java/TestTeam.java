import models.League;
import models.Manager;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTeam {
    League league;
    Manager manager;
    Team team;

    @Before
    public void setUp() throws Exception {
        league = new League("MLS");
        manager = new Manager("Chris Murphy", 65000, 1500000);
        team = new Team("soccer united", 12, manager, league);
    }

    @Test
    public void canWin() {
        team.win();
        assertEquals(15, team.getPoints());
    }
}

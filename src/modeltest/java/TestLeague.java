import models.League;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLeague {
    League league;

    @Before
    public void setUp() throws Exception {
        league = new League("Premiership");
    }

    @Test
    public void hasName() {
        assertEquals("Premiership", league.getName());
    }

    @Test
    public void hasNoTeams() {
        assertEquals(0,league.getTeams().size());
    }
}

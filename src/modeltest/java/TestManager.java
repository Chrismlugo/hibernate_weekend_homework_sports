
import models.Manager;
import models.Player;
import models.PlayerPosition;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


public class TestManager {
    Manager manager;

    @Before
    public void setUp() throws Exception {
        manager = new Manager("Chris Murphy", 45000, 1000000);
    }

    @Test
    public void hasName() {
        assertEquals("Chris Murphy", manager.getName());
    }

    @Test
    public void hasBudget() {
        assertEquals(1000000, manager.getBudget());
    }

    @Test
    public void hasNoPlayers() {
        assertEquals(0, manager.getPlayers().size());
    }

    @Test
    public void canSignPlayer() {
      Player  player = new Player("Zheng Zhi", 100000, PlayerPosition.STRIKER, manager);
      manager.signPlayer(player);
      assertEquals(900000, manager.getBudget());
    }
}

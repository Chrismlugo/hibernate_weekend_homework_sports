import models.Manager;
import models.Player;
import models.PlayerPosition;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPlayer {
    Player player;
    Manager manager;

    @Before
    public void setUp() throws Exception {
        manager = new Manager("Neil Lennon", 40000, 1200000);
        player = new Player("Zheng Zhi", 50000, PlayerPosition.STRIKER, manager);
    }

    @Test
    public void hasPosition() {
        assertEquals(PlayerPosition.STRIKER, player.getPosition());
    }

    @Test
    public void hasManager() {
        assertEquals(manager, player.getManager());
    }

    @Test
    public void hasSalary() {
        assertEquals(50000, player.getSalary());
    }
}

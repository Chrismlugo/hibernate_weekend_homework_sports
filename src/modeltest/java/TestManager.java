
import models.Manager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


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
}

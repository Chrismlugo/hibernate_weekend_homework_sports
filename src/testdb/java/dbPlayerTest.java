import db.DBHelper;
import models.Manager;
import models.Player;
import models.PlayerPosition;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class dbPlayerTest {
    Manager manager;
    Player player;

    @Before
    public void setUp() throws Exception {
        manager = new Manager("Neil Lennon", 40000, 1200000);
        DBHelper.saveOrUpdate(manager);

        player = new Player("Zheng Zhi", 50000, PlayerPosition.STRIKER, manager);
        DBHelper.saveOrUpdate(player);
    }

    @Test
    public void canGetWinBonus() {
        Manager foundManager = DBHelper.find(Manager.class,manager.getId());
        foundManager.payWinBonus();
        Player foundPlayer = DBHelper.find(Player.class,player.getId());
        assertEquals(51000, foundPlayer.getSalary());
    }
}

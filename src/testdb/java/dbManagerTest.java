import db.DBHelper;
import models.Manager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class dbManagerTest {
    Manager manager;

    @Before
    public void setUp() throws Exception {
        manager = new Manager("Brendan Rodgers", 35000, 4500000);
        DBHelper.saveOrUpdate(manager);
    }

    @Test
    public void canSave() {

        Manager found = DBHelper.find(Manager.class, manager.getId());
        assertEquals("Brendan Rodgers", found.getName() );
    }

    @Test
    public void canUpdate() {
        Manager found = DBHelper.find(Manager.class, manager.getId());
        found.setBudget(12000000);
        DBHelper.saveOrUpdate(found);

        assertEquals(12000000, found.getBudget());
    }
}


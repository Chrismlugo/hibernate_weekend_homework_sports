import models.Game;
import models.League;
import models.Manager;
import models.Team;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
    League league;
    Manager manager;
    Team team1;
    Team team2;
    Game game;

    @Before
    public void setUp() throws Exception {
        team1 = new Team("Porto",0,manager, league);
        team2 = new Team("Benfica",0,manager, league);
        game = new Game(team1, team2);
    }

    @Test
    public void gameHasWinner() {
        game.play();
        assert(game.getWinner() instanceof Team);

    }
}

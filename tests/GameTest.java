import components.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest  {
    public final Game game = new Game("Tetrus", "Puzzle", 20.99, 50);

    @Test
    public void saveAndGetGameTest() {
        this.game.saveGame();
        Game game = Game.getGame("Tetrus");
        assertEquals(this.game.getName(), game.getName());
    }

    @Test
    public void inSaleTest() {
        assertTrue(this.game.inSale());
    }
}

import components.Game;
import components.Review;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReviewTest {
    public final Game game = new Game("Tetrus", "Puzzle", 20.99, 50);
    public final Review review = new Review(
            game,
            50,
            "N.v.t",
            50,
            "N.v.t",
            50,
            "N.v.t"
    );

    @Test
    public void saveReviewTest() {
        this.game.saveGame();
        this.review.saveReview();
        Review review = Review.getReview(this.game.getName(), this.review.uuid);
        assertEquals(this.review.uuid, review.uuid);
    }
}

package components;

import helper.Helper;

import java.io.*;
import java.util.ArrayList;

public class Review implements Serializable {
    private String uuid;
    private Game game;
    private int gameplayGrade;
    private String gameplayContext;
    private int graphicsGrade;
    private String graphicsContext;
    private int storylineGrade;
    private String storylineContext;
    private int averageGrade;

    public Review(
            Game game,
            int gameplayGrade,
            String gameplayContext,
            int graphicsGrade,
            String graphicsContext,
            int storylineGrade,
            String storylineContext
    ) {
        this.game = game;
        this.gameplayGrade = gameplayGrade;
        this.gameplayContext = gameplayContext;
        this.graphicsGrade = graphicsGrade;
        this.graphicsContext = graphicsContext;
        this.storylineGrade = storylineGrade;
        this.storylineContext = storylineContext;
        this.averageGrade = (gameplayGrade + graphicsGrade + storylineGrade) / 3;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getGameplayGrade() {
        return gameplayGrade;
    }

    public void setGameplayGrade(int gameplayGrade) {
        this.gameplayGrade = gameplayGrade;
    }

    public String getGameplayContext() {
        return gameplayContext;
    }

    public void setGameplayContext(String gameplayContext) {
        this.gameplayContext = gameplayContext;
    }

    public int getGraphicsGrade() {
        return graphicsGrade;
    }

    public void setGraphicsGrade(int graphicsGrade) {
        this.graphicsGrade = graphicsGrade;
    }

    public String getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(String graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public int getStorylineGrade() {
        return storylineGrade;
    }

    public void setStorylineGrade(int storylineGrade) {
        this.storylineGrade = storylineGrade;
    }

    public String getStorylineContext() {
        return storylineContext;
    }

    public void setStorylineContext(String storylineContext) {
        this.storylineContext = storylineContext;
    }

    public int getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(int averageGrade) {
        this.averageGrade = averageGrade;
    }

    /** Save the current object as a review */
    public void saveReview() {
        this.uuid = Helper.uuid();

        String dirpath = STR."./files/games/\{this.game.getName()}/reviews/";
        File directories = new File(dirpath);
        if (!directories.exists()) {
            boolean created = directories.mkdirs();
            if (!created) return;
        }

        try {
            String filepath = STR."\{dirpath}\{this.uuid}.ser";
            FileOutputStream fileOutput = new FileOutputStream(filepath);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(this);
            objectOutput.close();
            fileOutput.close();
        } catch (Exception error) {
            Helper.handleException(error);
        }
    }

    /**
     * Get a review of a game
     * @param gameName - The name of the game
     * @param uuid - The uuid of the review
     */
    public static Review getReview(String gameName, String uuid) {
        String filepath = STR."./files/games/\{gameName}/reviews/\{uuid}.ser";
        File file = new File(filepath);
        if (!file.exists()) return null;

        Review review = null;

        try {
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            Object obj = objectInput.readObject();
            if (obj instanceof Review) review = (Review) obj;
        } catch (Exception err) {
            Helper.handleException(err);
        }

        return review;
    }

    /**
     * Get all the reviews of a game
     * @param gameName - The name of the game
     */
    public static ArrayList<Review> getAllReviews(String gameName) {
        ArrayList<Review> reviews = new ArrayList<>();
        for (File file : Helper.listFiles(STR."./files/games/\{gameName}/reviews")) {
            Review review = Review.getReview(gameName, file.getName());
            if (review != null) reviews.add(review);
        }
        return reviews;
    }
}

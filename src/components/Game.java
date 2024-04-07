package components;

import helper.Helper;
import java.io.*;
import java.util.ArrayList;

public class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // dit is voor om het op te slaan
    public String name;
    public String category;
    public double price;
    public int grade;
    public int totalReviews = 1;

    public Game(String name, String category, double price, int grade) {
        this.name = name;
        this.category = category;
        this.price = Math.round(price * 100.0) / 100.0;
        this.grade = grade;
    }

    /** Save the current object as a game */
    public void saveGame() {
        String dirpath = STR."./files/games/\{this.name}/";
        File directories = new File(dirpath);
        if (!directories.exists()) {
            boolean created = directories.mkdirs();
            if (!created) return;
        }

        try {
            String filepath = STR."\{dirpath}/game.ser";
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
     * Get a saved game
     * @param name - The name of the game to get
     */
    public static Game getGame(String name) {
        String filepath = STR."./files/games/\{name}/game.ser";
        File file = new File(filepath);
        if (!file.exists()) return null;

        Game game = null;

        try {
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            Object obj = objectInput.readObject();
            if (obj instanceof Game) game = (Game) obj;
        } catch (Exception err) {
            Helper.handleException(err);
        }

        return game;
    }

    /** Get all the games */
    public static ArrayList<Game> getAllGames() {
        ArrayList<Game> games = new ArrayList<>();
        for (File file : Helper.listFiles("./files/games/")) {
           Game game = Game.getGame(file.getName());
           if (game != null) games.add(game);
        }
        return games;
    }

    /** Check if the game object is for sale */
    public boolean inSale() {
        return this.grade < 55;
    }
}

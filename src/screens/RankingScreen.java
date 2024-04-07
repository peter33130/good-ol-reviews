package screens;

import components.Game;
import components.Screen;
import helper.Helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RankingScreen extends Screen {
    public RankingScreen() {}

    public RankingScreen(String notification) {
        super(notification);
    }

    @Override
    public void showScreen() {
        System.out.println("[Rangschikking]");

        List<String> categories = new ArrayList<>();
        for (Game game : Game.getAllGames()) categories.add(game.category);
        categories = categories.stream().distinct().collect(Collectors.toList()); // haal dubbelen weg

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Normaal");

        // laat gebruiker keuze maken
        int counter = 2;
        for (String category : categories) {
            System.out.println(STR."\{counter}. \{category}");
            counter++;
        }

        System.out.print("Maak uw keuze: ");

        int choice = scanner.nextInt();
        String category = choice == 1 ? null : categories.get(choice - 2);

        Helper.clearScreen();

        // sorteer games op cijfer
        ArrayList<Game> games = Game.getAllGames();
        games.sort((game1, game2) -> Integer.compare(game2.grade, game1.grade));

        // print alle games
        counter = 1;
        for (Game game : games) {
            if (category != null && !category.equals(game.category)) continue;
            System.out.print(STR."\{counter}. \{game.name}, prijs: €\{Helper.formatToEuro(game.price)}, rating: \{game.grade}");
            if (game.inSale()) System.out.print(" (KORTING)");
            System.out.println();
            counter++;
        }

        new StartScreen("\nBoven u staan de resultaten").showScreen();
    }
}

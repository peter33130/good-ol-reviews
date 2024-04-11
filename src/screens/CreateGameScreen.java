package screens;

import components.Game;
import components.Screen;
import helper.Helper;

import java.util.Scanner;

public class CreateGameScreen extends Screen {
    public CreateGameScreen() {}

    public CreateGameScreen(String notification) {
        super(notification);
    }

    @Override
    public void showScreen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[Game toevoegen of veranderen]");

        System.out.print("Wat is de naam van game?: ");
        String name = scanner.nextLine();
        System.out.print("Wat is de categorie van game?: ");
        String category = scanner.nextLine();
        System.out.print("Wat is de prijs van game?: ");
        double price = scanner.nextDouble();

        // sla game op
        Game game = new Game(name, category, price, 100);
        game.saveGame();

        // terug naar hoofdmenu
        Helper.clearScreen();
        new StartScreen(STR."'\{name}' successvol aangemaakt.").showScreen();
    }
}

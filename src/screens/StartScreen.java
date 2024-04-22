package screens;

import components.Screen;
import helper.Helper;

import java.util.Scanner;
import java.io.File;
public class StartScreen extends Screen {
    public StartScreen() {}

    public StartScreen(String notification) {
        super(notification);
    }

    @Override
    public void showScreen() {
        Scanner scanner = new Scanner(System.in);

        // print menu
        System.out.println("1. Ranglijst");
        System.out.println("2. Kortingen");
        System.out.println("3. Laat een review achter");
        System.out.println("4. Voeg een game toe / Game aanpassen");
        System.out.print("Voer het getal in van het menu waar u naar toe wilt: ");

        // kijk welk item is geselecteert
        String selected = scanner.next();
        Screen screen;

        String folderPath = "./files/games/";
        File folder = new File(folderPath);

        // kijkt of folder leeg is(voor als een )
        if ((selected.equals("1") || selected.equals("2") | selected.equals("3")) && !folder.exists()) {
            Helper.clearScreen();
            new StartScreen("Geen games gevonden").showScreen();
        }
        
        switch (selected) {
            case "1" -> screen = new RankingScreen();
            case "2" -> screen = new DiscountScreen();
            case "3" -> screen = new CreateReviewScreen();
            case "4" -> screen = new CreateGameScreen();
            default -> screen = new StartScreen("Je hebt een ongeldig nummer ingevoerd, probeer het opnieuw.");
        }

        Helper.clearScreen(); // maak scherm leeg
        screen.showScreen(); // laat gekozen scherm zien
    }

    public static void printlogo() {
        System.out.println("  ________                  .___        .__/\\    ________                              ");
        System.out.println(" /  _____/  ____   ____   __| _/   ____ |  )/   /  _____/_____    _____   ____   ______");
        System.out.println("/   \\  ___ /  _ \\ /  _ \\ / __ |   /  _ \\|  |   /   \\  ___\\__  \\  /     \\_/ __ \\ /  ___/");
        System.out.println("\\    \\_\\  (  <_> |  <_> ) /_/ |  (  <_> )  |__ \\    \\_\\  \\/ __ \\|  Y Y  \\  ___/ \\___ \\");
        System.out.println(" \\______  /\\____/ \\____/\\____ |   \\____/|____/  \\______  (____  /__|_|  /\\___  >____  >");
        System.out.println("        \\/                   \\/                        \\/     \\/      \\/     \\/     \\/");
    }
}

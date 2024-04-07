package screens;

import components.Screen;
import helper.Helper;

import java.util.Scanner;

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
        System.out.println("4. Voeg een nieuwe game toe");
        System.out.print("Voer het getal in van het menu waar u naar toe wilt: ");

        // kijk welk item is geselecteert
        String menuItemSelected = scanner.next();
        Screen screen;
        switch (menuItemSelected) {
            case "1" -> screen = new RankingScreen();
            case "2" -> screen = new DiscountScreen();
            case "3" -> screen = new CreateReviewScreen();
            case "4" -> screen = new CreateGameScreen();
            default -> screen = new StartScreen("Je hebt een ongeldig nummer ingevoerd, probeer het opnieuw.");
        }

        Helper.clearScreen(); // maak scherm leeg
        screen.showScreen(); // laat gekozen scherm zien
    }

    public static void printSpaceInvaderArt() {
        System.out.println("   ##          ##");
        System.out.println("     ##      ##         )  )");
        System.out.println("   ##############");
        System.out.println(" ####  ######  ####");
        System.out.println("######################");
        System.out.println("##  ##############  ##     )   )");
        System.out.println("##  ##          ##  ##");
        System.out.println("      ####  ####");
    }
}

package screens;

import components.Game;
import components.Review;
import components.Screen;
import helper.Helper;
import surveys.StandardSurvey;

import java.util.Scanner;

public class CreateReviewScreen extends Screen {
    public CreateReviewScreen() {}

    public CreateReviewScreen(String notification) {
        super(notification);
    }

    @Override
    public void showScreen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[Review achterlaten]"); // titel

        // game ophalen
        System.out.print("Wat is de naam van de game?: ");
        Game game = Game.getGame(scanner.nextLine());
        if (game == null) {
            System.out.println("Sorry, deze game bestaat niet.");
            this.showScreen();
            return;
        }

        System.out.print("Welk cijfer geeft u de gameplay?: ");
        int gameplayGrade = scanner.nextInt();
        if (!this.verifyRating(gameplayGrade)) {
            System.out.println("Sorry, dit cijfer is niet geldig. Geef een cijfer tussen 1 en 100.");
            Helper.clearScreen();
            this.showScreen();
            return;
        }
        scanner.nextLine(); // bug fix
        System.out.print("Waarom geeft u dit cijfer voor de gameplay?: ");
        String gameplayContext = scanner.nextLine();

        System.out.print("Welk cijfer geeft u de graphics?: ");
        int graphicsGrade = scanner.nextInt();
        if (!this.verifyRating(graphicsGrade)) {
            System.out.println("Sorry, dit cijfer is niet geldig. Geef een cijfer tussen 1 en 100.");
            Helper.clearScreen();
            this.showScreen();
            return;
        }
        scanner.nextLine(); // bug fix
        System.out.print("Waarom geeft u dit cijfer voor de graphics?: ");
        String graphicsContext = scanner.nextLine();

        System.out.print("Welk cijfer geeft u de storyline?: ");
        int storylineGrade = scanner.nextInt();
        if (!this.verifyRating(storylineGrade)) {
            System.out.println("Sorry, dit cijfer is niet geldig. Geef een cijfer tussen 1 en 100.");
            Helper.clearScreen();
            this.showScreen();
            return;
        }
        System.out.print("Waarom geeft u dit cijfer voor de storyline?: ");
        scanner.nextLine(); // bug fix
        String storylineContext = scanner.nextLine();

        // maak review
        Review review = new Review(game, gameplayGrade, gameplayContext, graphicsGrade, graphicsContext, storylineGrade, storylineContext);
        review.saveReview();

        game.totalReviews += 1;
        game.grade = (review.averageGrade + game.grade) / game.totalReviews;
        game.saveGame();

        this.askForSurvey(scanner); // vraag voor vragenlijst
    }


    public boolean verifyRating(int rating) {
        return rating >= 1 && rating <= 100;
    }
    public void askForSurvey(Scanner scanner) {
        System.out.print("Wilt u nog een korte vragenlijst invullen?: ");

        String anwser = scanner.nextLine();
        switch (anwser) {
            case "ja" -> {
                Helper.clearScreen();
                new StandardSurvey().start();
            }
            case "nee" -> {}
            default -> {
                Helper.clearScreen();
                System.out.println("Antwoord alstublieft met ja of nee.");
                this.askForSurvey(scanner);
            }
        }

        Helper.clearScreen();
        new StartScreen("Dank u wel voor uw review.").showScreen();
    }
}

import components.Game;
import components.questions.FollowUpQuestion;
import components.questions.NormalQuestion;
import helper.Helper;
import screens.StartScreen;

import java.util.function.Function;

public class Main {
    public void main(String[] args) {
        this.runMainMenu("");
    }

    public void runMainMenu(String notification) {
        try {
            Helper.clearScreen(); // maak scherm leeg
            StartScreen.printSpaceInvaderArt();
            StartScreen screen = new StartScreen(notification);
            System.out.println();
            screen.showScreen();
        } catch (Exception error) {
            this.runMainMenu("Er is iets fout gegaan, sorry.");
        }
    }
}

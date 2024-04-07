package components.questions;

import java.util.Scanner;

public abstract class BaseQuestion {
    public String title;
    public boolean multipleChoice;
    public String[] anwsers = new String[0];

    public BaseQuestion(String title) {
        this.title = title;
    }

    public BaseQuestion(String title, boolean multipleChoice, String[] anwsers) {
        this(title);
        this.multipleChoice = multipleChoice;
        this.anwsers = anwsers;
    }

    public String askQuestion() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder();

        System.out.println(this.title);

        // create list when anwser is multiple-choice
        if (this.multipleChoice && this.anwsers.length > 0) {
            int counter = 0;
            for (String anwser : this.anwsers) {
                message.append(this.integerToLetter(counter)).append(". ").append(anwser).append("\n");
                counter++;
            }
        }

        message.append("Maak uw keuze: " );
        System.out.print(message);

        String anwser = scanner.next();
        if (this.multipleChoice && this.anwsers.length > 0 && anwser.length() > 1) {
            System.out.println("Deze vraag is meerkeuze, probeer het opnieuw.");
            this.askQuestion();
        }

        return anwser;
    }

    public String integerToLetter(int i) {
        String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return alfabet.split("")[i];
    }
}

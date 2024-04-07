package surveys;

import components.Survey;
import components.questions.FollowUpQuestion;
import components.questions.NormalQuestion;

import java.util.function.Function;

public class StandardSurvey extends Survey {
    public StandardSurvey() {
        super(new NormalQuestion[]{
                new NormalQuestion("Wat vindt u van onze winkel?"),
                new NormalQuestion(
                        "Hoe vaak gamet u?",
                        true,
                        new String[]{
                                "Korter dan 1 uur",
                                "1 tot 2 uur",
                                "2 tot 3 uur",
                                "Langer dan 3 uur",
                        }),
                new NormalQuestion(
                        "Welke soort games speelt u het meest?",
                        true,
                        new String[]{
                                "RPG",
                                "Shooter",
                                "Retro",
                                "Puzzle"
                        }
                ),
                new NormalQuestion(
                        "Gaat u naar andere winkels voor retro-games?",
                        true,
                        new String[]{
                                "Ja",
                                "Nee"
                        },
                        new FollowUpQuestion[]{
                                new FollowUpQuestion("Welke winkels?"),
                        },
                        (String anwser) -> { return anwser.equalsIgnoreCase("a"); }
                        ),
                new NormalQuestion(
                        "Is dit de eerste keer voor u in deze winkel?",
                        true,
                        new String[]{
                                "Ja",
                                "Nee"
                        },
                        new FollowUpQuestion[]{
                                new FollowUpQuestion("Wat is uw eerste indruk?"),
                        },
                        (String anwser) -> { return anwser.equalsIgnoreCase("a"); }
                        ),
                new NormalQuestion("Opmerking, feedback, suggesties")
        });
    }
}

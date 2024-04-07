package components.questions;


import java.util.function.Function;

public class NormalQuestion extends BaseQuestion {
    public FollowUpQuestion[] followUpQuestions = new FollowUpQuestion[0];
    public Function<String, Boolean> followUpCondition;

    public  NormalQuestion(String title) {
        super(title);
    }

    public NormalQuestion(String title, Function<String, Boolean> followUpCondition) {
        super(title);
        this.followUpCondition = followUpCondition;
    }

    public NormalQuestion(String title, FollowUpQuestion[] followUpQuestions) {
        super(title);
        this.followUpQuestions = followUpQuestions;
    }

    public NormalQuestion(String title, boolean multipleChoice, String[] anwsers) {
        super(title, multipleChoice, anwsers);
    }

    public NormalQuestion(
            String title,
            boolean multipleChoice,
            String[] anwsers,
            FollowUpQuestion[] followUpQuestions,
            Function<String, Boolean> followUpCondition
    ) {
        super(title, multipleChoice, anwsers);
        this.followUpQuestions = followUpQuestions;
        this.followUpCondition = followUpCondition;
    }

    @Override
    public String askQuestion() {
        String anwser = super.askQuestion();
        if (this.followUpQuestions.length > 0 && this.followUpCondition.apply(anwser)) {
            for (FollowUpQuestion followUpQuestion : this.followUpQuestions) followUpQuestion.askQuestion();
        }

        return anwser;
    }
}

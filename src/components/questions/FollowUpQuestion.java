package components.questions;

public class FollowUpQuestion extends BaseQuestion {
    public FollowUpQuestion(String title) {
        super(title);
    }

    public FollowUpQuestion(String title, boolean multipleChoice, String[] anwsers) {
        super(title, multipleChoice, anwsers);
    }
}

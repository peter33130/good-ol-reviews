package components;

import components.questions.FollowUpQuestion;
import components.questions.NormalQuestion;

public abstract class Survey {
    private NormalQuestion[] questions;

    public NormalQuestion[] getQuestions() {
        return questions;
    }

    public void setQuestions(NormalQuestion[] questions) {
        this.questions = questions;
    }

    public Survey(NormalQuestion[] questions) {
        this.questions = questions;
    }

    public void start() {
        for (NormalQuestion question : this.questions) question.askQuestion();
    }
}

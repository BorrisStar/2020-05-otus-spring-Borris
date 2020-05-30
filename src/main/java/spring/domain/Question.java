package spring.domain;

import java.util.List;

public class Question {
    private List<String> questionAndAnswers;

    public List<String> getQuestionAndAnswers() {
        return questionAndAnswers;
    }

    public void setQuestionAndAnswers(List<String> questionAndAnswers) {
        this.questionAndAnswers = questionAndAnswers;
    }

    public Question(List<String> list) {
        questionAndAnswers = list;
    }
}

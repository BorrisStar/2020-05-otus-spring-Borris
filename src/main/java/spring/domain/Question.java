package spring.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
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

package spring.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Anketa {

    private List<Question> questions;

    public Anketa() {
    }

    public Anketa(List<Question> questions) {this.questions = questions;}

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}

package spring.domain;

import java.util.List;

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

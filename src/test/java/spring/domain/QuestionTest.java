package spring.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Class Question")
class QuestionTest {

    @Test
    @DisplayName("корректно создается конструктором")
    void schouldHaveCorrectConstructor() {
        List<String> list = List.of("one", "two", "three");
        Question question = new Question(list);

        assertEquals("one", question.getQuestionAndAnswers().get(0));
    }
}
package spring.dao;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.domain.Question;
import spring.service.AnketaService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnketaDaoSimpleTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
    AnketaService anketaService = context.getBean(AnketaService.class);


    @Test
    void findByNumber() {
        List<String> list = List.of("What course do you study?", "1) 1", "2) 2", "3) 3", "4) 4");
        Question question = new Question(list);
        assertEquals(question.getQuestionAndAnswers(), anketaService.findByNumber(0).getQuestionAndAnswers());
    }

    @Test
    void getAll() {
        assertEquals(6, anketaService.getAll().size());
    }
}
package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring.domain.Question;
import spring.service.AnketaService;


@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        AnketaService anketaService = context.getBean(AnketaService.class);

        System.out.println("Anketa for Students:");
        for (Question questionAndAnswer : anketaService.getAll()) {
            for (String str : questionAndAnswer.getQuestionAndAnswers()) {
                System.out.println(str);
            }
            System.out.println();
        }
    }
}

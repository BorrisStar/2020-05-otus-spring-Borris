package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import spring.service.ScannerService;
import spring.service.StudentSurveyService;

import java.io.IOException;

//Программа должна спросить у пользователя фамилию и имя, спросить 5 вопросов из CSV-файла и вывести результат тестирования.
@ComponentScan
@ShellComponent
public class Main {

    @ShellMethod(key = "start survey", value = "Start survey of students")
    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        StudentSurveyService surveyService = context.getBean(StudentSurveyService.class);

        surveyService.questioning(new ScannerService().getScannerIn());
    }
}

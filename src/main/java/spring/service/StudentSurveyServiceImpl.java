package spring.service;

import org.springframework.context.MessageSource;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Service;
import spring.domain.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Service
@ShellComponent
public class StudentSurveyServiceImpl implements StudentSurveyService{

    private final AnketaServiceImpl anketaService;
    private final ScannerService scannerService;
    private final MessageSource source;
    private final Locale locale = Locale.forLanguageTag("ru-Ru");

    public StudentSurveyServiceImpl(AnketaServiceImpl anketaService, ScannerService scannerService, MessageSource messageSource) {
        this.anketaService = anketaService;
        this.scannerService = scannerService;
        this.source = messageSource;
    }

    @Override
    @ShellMethod(key = "start survey", value = "Start survey of students")
    public void questioning() throws IOException {
        Scanner in = scannerService.getScannerIn();

        System.out.println("Anketa for Hogwarts students:");

        String family = getFIO(in, "InputSecondName");

        String name = getFIO(in, "InputFirstName");

        List<Integer> answers = getAnswers(in);

        getSurveyResult(answers, family, name);

        System.out.println(source.getMessage("ThankYou", null, locale));
    }

    @Override
    public List<Integer> getAnswers(Scanner in) {

        List<Integer> answers = new ArrayList<>();

        for (
                Question questionAndAnswer : anketaService.getAll()) {
            for (String str : questionAndAnswer.getQuestionAndAnswers()) {
                System.out.println(str);
            }
            System.out.println();
            System.out.println(source.getMessage("InputNumber", null, locale));

            //Простая проверка
            if (in.hasNextInt()) {
                int result = in.nextInt();
                if (result >= 1 && result <= 4) {
                    answers.add(result);
                } else {
                    throw new IllegalArgumentException("Неверный диапазон числа");
                }
            } else {
                throw new IllegalArgumentException("Введенный символ не число");
            }
            System.out.println();
        }
        in.close();

        return answers;
    }

    @Override
    public String getFIO(Scanner in, String s) {
        System.out.println(source.getMessage(s, null, locale));
        return in.nextLine();
    }

    @Override
    public void getSurveyResult(List<Integer> answers, String family, String name) {
        System.out.println();

        System.out.println(source.getMessage("FIO", null, locale) + family + " " + name);
        System.out.println(source.getMessage("TestResult", null, locale));
        for (int count : answers) {
            System.out.println(++count + ". " + answers.get(count - 1));
        }
    }
}

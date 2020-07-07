package spring.service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Service;
import spring.domain.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@ShellComponent
public class StudentSurveyServiceImpl implements StudentSurveyService{

    private final AnketaServiceImpl anketaService;
    private final ScannerService scannerService;

    public StudentSurveyServiceImpl(AnketaServiceImpl anketaService, ScannerService scannerService) {
        this.anketaService = anketaService;
        this.scannerService = scannerService;
    }

    @Override
    @ShellMethod(key = "start survey", value = "Start survey of students")
    public void questioning() throws IOException {
        Scanner in = scannerService.getScannerIn();

        System.out.println("Anketa for Hogwarts students:");

        String family = getFIO(in, "Введите вашу фамилию: ");

        String name = getFIO(in, "Введите ваше имя: ");

        List<Integer> answers = getAnswers(in);

        getSurveyResult(answers, family, name);

        System.out.println("Спасибо за участие в тестировании!");
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
            System.out.println("Введите номер вашего ответа (число от 1 до 4): ");

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
        System.out.println(s);
        return in.nextLine();
    }

    @Override
    public void getSurveyResult(List<Integer> answers, String family, String name) {
        System.out.println();
        System.out.println("ФИО:" + family + " " + name);
        System.out.println("Результаты теста:");
        for (int count : answers) {
            System.out.println(++count + ". " + answers.get(count - 1));
        }
    }
}

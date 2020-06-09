package spring.service;

import org.springframework.stereotype.Service;
import spring.domain.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class StudentSurveyService {

    private final AnketaServiceImpl anketaService;

    public StudentSurveyService(AnketaServiceImpl anketaService) {
        this.anketaService = anketaService;
    }

    public void questioning(Scanner in) throws IOException {

        System.out.println("Anketa for Hogwarts students:");

        String family = getFIO(in, "Введите вашу фамилию: ");

        String name = getFIO(in, "Введите ваше имя: ");

        List<Integer> answers = getAnswers(in);

        getSurveyResult(answers, family, name);

        System.out.println("Спасибо за участие в тестировании!");
    }

    private List<Integer> getAnswers(Scanner in) {

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

    private String getFIO(Scanner in, String s) {
        System.out.println(s);
        return in.nextLine();
    }

    private void getSurveyResult(List<Integer> answers, String family, String name) {
        System.out.println();
        System.out.println("ФИО:" + family + " " + name);
        System.out.println("Результаты теста:");
        for (int count : answers) {
            System.out.println(++count + ". " + answers.get(count - 1));
        }
    }
}

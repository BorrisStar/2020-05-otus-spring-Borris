package spring.service;

import org.springframework.stereotype.Service;
import spring.domain.Question;

import java.io.IOException;
import java.util.Scanner;

@Service
public class StudentSurveyService {

    private final AnketaServiceImpl anketaService;
    private final ScannerService scannerService;

    public StudentSurveyService(
            AnketaServiceImpl anketaService,
            ScannerService scannerService) {
        this.anketaService = anketaService;
        this.scannerService = scannerService;
    }

    public void questioning() throws IOException {
        Scanner in = scannerService.getScannerIn();
        int[] answers = new int[6];
        int answerCount = 0;
        System.out.println("Anketa for Hogwarts students:");

        System.out.println("Введите вашу фамилию: ");
        String family = in.nextLine();
        System.out.println("Введите ваше имя: ");
        String name = in.nextLine();

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
                    answers[answerCount++] = result;
                } else {
                    throw new IllegalArgumentException("Неверный диапазон числа");
                }
            } else {
                throw new IllegalArgumentException("Введенный символ не число");
            }
            System.out.println();
        }
        in.close();

        System.out.println();
        System.out.println("ФИО:" + family + " " + name);
        System.out.println("Результаты теста:");

        for (int count : answers) {
            System.out.println(++count + ". " + answers[count - 1]);
        }
        System.out.println("Спасибо за участие в тестировании!");
    }
}

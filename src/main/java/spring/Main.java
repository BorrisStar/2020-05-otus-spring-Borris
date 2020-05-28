package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.domain.Question;
import spring.service.AnketaService;

//Приложение по проведению тестирования студентов (только вывод вопросов)
//        Цель: создать приложение с помощью Spring IoC, чтобы познакомиться с основной функциональностью IoC,
//        на которой строится весь Spring. Результат: простое приложение, сконфигурированное XML-контекстом.
//        Описание задание:
//
//        В ресурсах хранятся вопросы и различные ответы к ним в виде CSV файла (5 вопросов).
//        Вопросы могут быть с выбором из нескольких вариантов или со свободным ответом - на Ваше желание и усмотрение.
//        Приложение должна просто вывести вопросы теста из CSV-файла с возможными вариантами ответа.

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
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

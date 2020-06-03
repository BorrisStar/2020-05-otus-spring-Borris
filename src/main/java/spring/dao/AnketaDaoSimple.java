package spring.dao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import spring.domain.Anketa;
import spring.domain.Question;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
@Repository
@PropertySource("classpath:application.properties")
public class AnketaDaoSimple implements AnketaDao {

    @Value("${filePath}")
    private String filePath;

    private Anketa anketa;

    @PostConstruct
    private void init() throws IOException {

        List<Question> questions = new ArrayList<>();

        Path path = Paths.get(filePath);
        Scanner scanner = new Scanner(path);

        String scanResult;
        List<String> list = new ArrayList<>();

        while (!(scanResult = scanner.nextLine()).equals(".")) {
            if (!scanResult.equals(";")) {
                list.add(scanResult);
            } else {
                Question question = new Question(new ArrayList(list));
                questions.add(question);
                list.clear();
            }
        }

        anketa = new Anketa(questions);
        scanner.close();
    }

    @Override
    public Question findByNumber(Integer number) {

        if (number >= 0
            && !anketa.getQuestions().isEmpty()
            && number <= anketa.getQuestions().size()) {
            return anketa.getQuestions().get(number);
        } else {
            throw new IndexOutOfBoundsException("Вопроса с таким номером не существует!");
        }
    }

    @Override
    public List<Question> getAll() {
        return anketa.getQuestions();
    }
}

package spring.service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public interface StudentSurveyService {

    void questioning() throws IOException;

    List<Integer> getAnswers(Scanner in) ;

    String getFIO(Scanner in, String s) ;

    void getSurveyResult(List<Integer> answers, String family, String name) ;
}

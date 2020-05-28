package spring.service;

import spring.domain.Question;

import java.util.List;

public interface AnketaService {

    Question findByNumber(Integer number);

    List<Question> getAll();
}

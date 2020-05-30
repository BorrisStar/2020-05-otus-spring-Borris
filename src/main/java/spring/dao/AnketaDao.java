package spring.dao;

import spring.domain.Question;

import java.util.List;

public interface AnketaDao {

    Question findByNumber(Integer number);

    List<Question> getAll();
}

package spring.service;

import spring.dao.AnketaDao;
import spring.domain.Question;

import java.util.List;

public class AnketaServiceImpl implements AnketaService {

    private final AnketaDao dao;

    public AnketaServiceImpl(AnketaDao dao) {
        this.dao = dao;
    }

    @Override
    public Question findByNumber(Integer number) {
        return dao.findByNumber(number);
    }

    @Override
    public List<Question> getAll() {
        return dao.getAll();
    }
}

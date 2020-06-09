package spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.dao.AnketaDao;
import spring.domain.Question;

import java.util.List;

@Service
public class AnketaServiceImpl implements AnketaService {

    private final AnketaDao dao;

    public AnketaServiceImpl(@Qualifier("anketaDaoSimple") AnketaDao dao) {
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

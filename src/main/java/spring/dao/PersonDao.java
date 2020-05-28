package spring.dao;

import spring.domain.Person;

public interface PersonDao {

    Person findByName(String name);
}

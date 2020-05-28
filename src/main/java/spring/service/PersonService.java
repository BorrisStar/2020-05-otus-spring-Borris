package spring.service;

import spring.domain.Person;

public interface PersonService {

    Person getByName(String name);
}

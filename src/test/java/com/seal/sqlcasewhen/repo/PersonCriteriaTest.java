package com.seal.sqlcasewhen.repo;

import com.seal.sqlcasewhen.entity.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonCriteriaTest {

    @Autowired
    PersonCriteria personCriteria;

    @Test
    @Sql({"/person.sql"})
    public void testGetPerson() {
        List<Person> list = personCriteria.getPerson();

        Assertions.assertThat(list).isNotNull();
        Assertions.assertThat(list).isNotEmpty();
        Assertions.assertThat(list.size()).isEqualTo(8);
    }
}
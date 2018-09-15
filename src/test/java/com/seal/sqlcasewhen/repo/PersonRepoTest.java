package com.seal.sqlcasewhen.repo;

import com.seal.sqlcasewhen.PersonDTO;
import com.seal.sqlcasewhen.entity.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PersonRepoTest {

    @Autowired
    PersonRepo personRepo;
    @Autowired
    EntityManager entityManager;

    @Test
    @Sql("/person.sql")
    public void getPersonDTO() {
        Collection<PersonRepo.PersonDTO1> list = personRepo.getPersonDTO();
//        Collection<PersonDTO> list = personRepo.getPersonDTO();

        Assertions.assertThat(list).isNotEmpty();
        Assertions.assertThat(list.size()).isEqualTo(8);

    }

    @Test
    @Sql("/person.sql")
    public void getPersonByEntityManager() {
        List<Object[]> list = (List<Object[]>) entityManager.createNativeQuery("select name,\n" +
                "case\n" +
                "    when age > 20 and age < 25 then ''\n" +
                "    when age >= 25 and age <= 30 then 'xx'\n" +
                "    when age > 30 then ''\n" +
                "    else '' \n" +
                "end as xxx \n" +
                "from person").getResultList();

        Assertions.assertThat(list).isNotEmpty();

        list.forEach(i -> {
            System.out.println(i[0]);
            System.out.println(i[1]);
        });
    }

    @Test
    @Sql("/person.sql")
    public void getPersonAndCity() {
        List<Object[]> list = (List<Object[]>) entityManager
                .createNativeQuery("select name, city from person, address")
                .getResultList();

        Assertions.assertThat(list).isNotEmpty();
        list.forEach(i -> {
            System.out.println(i[0]);
            System.out.println(i[1]);
        });
    }
}
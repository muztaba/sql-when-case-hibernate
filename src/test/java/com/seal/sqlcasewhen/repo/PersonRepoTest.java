package com.seal.sqlcasewhen.repo;

import com.seal.sqlcasewhen.PersonDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonRepoTest {

    @Autowired
    PersonRepo personRepo;

    @Test
    @Sql("/person.sql")
    public void getPersonDTO() {
        List<PersonDTO> list = personRepo.getPersonDTO();

        Assertions.assertThat(list).isNotEmpty();
        Assertions.assertThat(list.size()).isEqualTo(8);

    }
}
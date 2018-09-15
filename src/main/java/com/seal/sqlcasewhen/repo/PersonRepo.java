package com.seal.sqlcasewhen.repo;

import com.seal.sqlcasewhen.PersonDTO;
import com.seal.sqlcasewhen.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

    @Query(nativeQuery = true, value = "select name,\n" +
            "case\n" +
            "    when age > 20 and age < 25 then ''\n" +
            "    when age >= 25 and age <= 30 then 'xx'\n" +
            "    when age > 30 then ''\n" +
            "    else ''\n" +
            "end as xxx\n" +
            "from person")
    Collection<PersonDTO1> getPersonDTO();

    @Query(nativeQuery = true,
    value = "select name, city from person, address")
    Collection<PersonCityDTO> getPersonByAddress();

    static interface PersonDTO1 {
        String getName();
        String getXxx();
    }

    static interface PersonCityDTO {
        String getName();

        String getCity();
    }
}

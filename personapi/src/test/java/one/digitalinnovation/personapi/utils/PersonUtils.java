package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Dayan";
    private static final String LAST_NAME = "Monteiro";
    private static final String CPF_NUMBER = "123.456.789-01";
    private static final String PERSON_ID = 1L;
    private static final String BIRTH_DATE = LocalDate.of(1987, 25, 7);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("25-07-1987")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO())
                        .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhonesUtils.createFakeENtity())
                        .build();

    }
}

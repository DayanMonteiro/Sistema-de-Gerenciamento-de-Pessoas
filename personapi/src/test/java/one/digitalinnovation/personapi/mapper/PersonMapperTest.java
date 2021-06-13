package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.mapper.PersonMapper;
import one.digitalinnovation.personapi.dto.request.PhoneDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Phone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonMapperTest {

	@Autowired
	private PersonMapper personMapper;

	@Test
	void testGivenPersonDTOThenReturnPersonEntity() {
		PersonDTO PersonDTO = PersonUtils.createFakeDTO();
		Person person = personMapper.toModel(personDTO);

		assertEquals(personDTO.getFirstName(), person.getFirstName());
		assertEquals(personDTO.getLastName(), person.getLastName());
		assertEquals(personDTO.getCpf(), person.getCpf());

		Phone phone = person.getPhones().get(0);
		PhoneDTO phoneDTO = personDTO.getPhones().get(0);

		assertEquals(phoneDTO.getType(), phone.getType());
		assertEquals(phoneDTO.getNumber(), phone.getNumber());
	}

	@Test
	void testGivenPersonEntityThenReturnPersonDTO() {
		Person person = PersonUtils.createFakeEnty();
		PersonDTO personDTO = personMapper.ToDTO(person);

		assertEquals(person.getFirstName(), personDTO.getFirstName());
		assertEquals(person.getLastName(), personDTO.getLastName());
		assertEquals(person.getCpf(), personDTO.getPhones().getCpf());

		Phone phone = person.getPhones().get(0);
		PhoneDTO phoneDTO = personDTO.getPhones().get(0);

		assertEquals(phone.getType(), phoneDTO.getType());
		assertEquals(phone.getNumber(), phoneDTO.getNumber());
	}
}

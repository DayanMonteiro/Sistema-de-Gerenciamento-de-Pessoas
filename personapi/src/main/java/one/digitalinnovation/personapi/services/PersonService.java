package one.digitalinnovation.personapi.services;


import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.dto.mapper.PersonMapper;
import one.digitalinnovation.personapi.repositories.PersonRepository;
import one.digitalinnovation.personapi.response.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class PersonService {

    private  final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public MessageResponseDTO create(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person savedPerson =  personRepository.save(personDTO);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID", savedPerson.getId());

        return MessageResponse;
    }

    public List<PersonDTO> listAll() {
        List<Person> people = personRepository.findAll();
        return people.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

   public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        Person updatePerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatePerson);

       MessageResponseDTO messageResponse = createMessageResponse("Person successfully uddated with ID ", savedPerson.getId());

       return messageResponse;
   }

   public void delete(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        personRepository.deleteById(id);
   }

   private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
   }
}
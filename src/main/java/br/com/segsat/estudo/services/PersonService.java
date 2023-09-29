package br.com.segsat.estudo.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.segsat.estudo.data.vo.v1.PersonVO;
import br.com.segsat.estudo.exceptions.ResourceNotFoundException;
import br.com.segsat.estudo.mapper.DozerMapper;
import br.com.segsat.estudo.model.Person;
import br.com.segsat.estudo.respositories.PersonRepository;

@Service
public class PersonService {

	private Logger log = Logger.getLogger(PersonService.class.getName());
	
	@Autowired
	private PersonRepository personRepository;
	
	public PersonVO findById(Long id) {
		log.info("find One Person");
		Person personID = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records for found this ID!"));
		
		return DozerMapper.parseObject(personID, PersonVO.class);
	}
	
	public List<PersonVO> findAll() {
		log.info("find All Person");
		return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class) ;
	}

	public PersonVO create (PersonVO personVO) {
		log.info("Creating one Person");
		
		Person personModific = DozerMapper.parseObject(personVO, Person.class); 
		PersonVO personModificVO =DozerMapper.parseObject (personRepository.save(personModific), PersonVO.class);
		return personModificVO;
	}
	
	public PersonVO update (PersonVO personVO) {
		log.info("update Person");
		Person pers = personRepository.findById(personVO.getId()).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		
		pers.setFirstName(personVO.getFirstName());
		pers.setLastName(personVO.getLastName());
		pers.setAddress(personVO.getAddress());
		pers.setGender(personVO.getGender());;
		
		PersonVO personModific = DozerMapper.parseObject(personRepository.save(pers), PersonVO.class) ;
		return personModific;
	}
	
	public void delete (Long id) {
		log.info("Delete Person");
		Person Person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		personRepository.delete(Person);
	}
}

package br.com.segsat.estudo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.segsat.estudo.data.vo.v1.PersonVO;
import br.com.segsat.estudo.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	

	@Autowired
	 private PersonService personService;

	@GetMapping(value = "/{id}")
	public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {
		return personService.findById(id);
	}

	@GetMapping(value = "/listPerson")
	public List<PersonVO> findAll() {
		return personService.findAll();
	}
	
	@PostMapping(value = "/create")
	public PersonVO create (PersonVO personVO) {
		return personService.create(personVO);
	}
	
	@PutMapping(value = "/update")
	public PersonVO update (PersonVO personVO) {
		return personService.update(personVO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
		personService.delete(id);
		return  ResponseEntity.noContent().build();
	}

}

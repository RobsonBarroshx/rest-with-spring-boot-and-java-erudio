package br.com.segsat.estudo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.segsat.estudo.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

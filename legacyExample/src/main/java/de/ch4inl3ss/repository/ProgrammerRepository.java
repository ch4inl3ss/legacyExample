package de.ch4inl3ss.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.ch4inl3ss.entity.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Long> {

	List<Programmer> findByAge(int age);

	List<Programmer> findByLastName(String lastName);

}

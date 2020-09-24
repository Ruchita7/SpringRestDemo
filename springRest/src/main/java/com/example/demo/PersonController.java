package com.example.demo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@RestController
public class PersonController {
	
	@Autowired
	PersonDao personDao;
	

	//@RequestMapping(path="/getList",produces= {"application/xml"})
	@RequestMapping(path="/getList")
	public List<Person> retrieveAllPersons() {
		return personDao.findAll();
	}
	
	@RequestMapping("/findById/{id}")
	public Optional<Person> findPersonById(@PathVariable("id") int id) {
		return personDao.findById(id);
	}
	
	@PostMapping(path="/person",consumes={"application/json"}, produces={"application/xml"})
	public Person addPerson(@RequestBody Person person)	{
		personDao.save(person);
		return person;
	}
	
	@DeleteMapping("/person/{id}")
	public String deletePerson(@PathVariable("id") int id)	{
		Person person = personDao.getOne(id);
		personDao.delete(person);
		return "deleted";
	}
	
	@PutMapping(path="/person",consumes= {"application/json"})
	public Person updatePerson(@RequestBody Person person)  {
		personDao.save(person);
		return person;
	}
	
}

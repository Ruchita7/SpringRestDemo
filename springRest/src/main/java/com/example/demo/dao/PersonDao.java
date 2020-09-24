package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Person;

@Component
public interface PersonDao extends JpaRepository<Person, Integer> {

}

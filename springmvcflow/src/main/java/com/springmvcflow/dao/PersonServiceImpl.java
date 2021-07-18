package com.springmvcflow.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcflow.model.Person2;

interface PersonService
{
	public void addPerson(Person2 person);
	public void updatePerson(Person2 person);
	public Person2 getPersonById(int id);
	public List<Person2> listPersons();
	public void removePerson(int id);
 }
@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonDaoImpl personDao;

	@Override
	public void addPerson(Person2 person) {
		// TODO Auto-generated method stub
		personDao.addPerson(person);
	}

	@Override
	public void updatePerson(Person2 person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person2 getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person2> listPersons() {
		// TODO Auto-generated method stub
		return personDao.listPersons();
	}

	@Override
	public void removePerson(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}

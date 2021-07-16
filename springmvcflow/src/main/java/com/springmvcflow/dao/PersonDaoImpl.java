package com.springmvcflow.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.springmvcflow.model.Person;
import com.utils.HibernateUtils;


interface PersonDao {
	public void addPerson(Person person);

	public void updatePerson(Person person);

	public List<Person> listPersons();

	public Person getPersonById(int id);

	public void removePerson(int id);
}

class Test
{
	Test()
	{
		super();
		
		System.out.println("This is Test class Constructor!!!");
		
	}
}

@Repository
public class PersonDaoImpl implements PersonDao {

	
		
	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		 
		System.out.println("Transaction Begin!!");
		
		//SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session=HibernateUtils.getSessionFactory().openSession();
		Transaction ts=session.beginTransaction();
		
		Person p=new Person();
		p.setId(10);
		p.setName("Rehan");
		p.setCountry("India");
		
		
		session.save(person);
	}

	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Person> listPersons() {
		// TODO Auto-generated method stub
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		System.out.println();
		Query query=session.createQuery("from Person2");
		List<Person> list=query.list();
		for(Person student : list)
		  {
		System.out.println(" Student Name: "+student.getName());
		  }
		return list;
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePerson(int id) {
		// TODO Auto-generated method stub

	}

	public static void main(String args[])
	{
		Test st=new Test();
		PersonDaoImpl per=new PersonDaoImpl();
		Person person=new Person();	
		per.addPerson(person);
		List<Person> list=per.listPersons();
		System.out.println(list);
		for(Person p:list)
		{
			System.out.println("Name: "+p.getName());
		}
	}
}

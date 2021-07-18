package com.springmvcflow.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.springmvcflow.model.Person2;
import com.utils.HibernateUtils;

interface PersonDao {
	public void addPerson(Person2 person);

	public void updatePerson(Person2 person);

	public List<Person2> listPersons();

	public Person2 getPersonById(int id);

	public void removePerson(int id);
}

class Test {
	Test() {
		super();

		System.out.println("This is Test class Constructor!!!");

	}
}

@Repository
public class PersonDaoImpl implements PersonDao {

	@Override
	public void addPerson(Person2 person) {
		// TODO Auto-generated method stub

		Session session = null;
		Transaction txn = null;
		try {  
		    SessionFactory sessionFactory =HibernateUtils.getSessionFactory(); 
		    session = sessionFactory.openSession();  
		    txn = session.beginTransaction();
		    session.save(person); 
		    txn.commit();

		} catch (Exception e) { 
		    System.out.println(e.getMessage());
		} finally {
		    if (!txn.wasCommitted()) {
		        txn.rollback();
		    }

		    session.flush();  
		    session.close();   
		}
		
	}

	@Override
	public void updatePerson(Person2 person) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Person2> listPersons() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction txt=null;
		List<Person2> list= new ArrayList<Person2>();
		try {
			session=HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
			
			Query query = session.createQuery("from Person2");
			list = query.list();
			//txt.commit();
			System.out.println("I am here after transaction commited");
			for (Person2 student : list) {
				System.out.println(" Student Name: " + student.getName());
			}
	
		}
		catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		finally {
		
			session.flush();
			session.close();
			
		}
				return list;
	}

	@Override
	public Person2 getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePerson(int id) {
		// TODO Auto-generated method stub

	}

	public static void main(String args[]) {
		
		PersonDaoImpl pdao=new PersonDaoImpl();
		Person2 person=new Person2();
		person.setId(50);
		person.setCountry("India");
		person.setName("Asif Shaikh");
		pdao.addPerson(person);
		
		pdao.listPersons();
		
	}
}

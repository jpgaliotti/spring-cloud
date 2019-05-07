package com.springdev.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdev.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			
			// query students: lastName='Lannister'
			theStudents = session.createQuery("from Student s where s.lastName='Lannister'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Lannister");
			displayStudents(theStudents);
			
			
			// query students: lastName='Stark' OR firstName='Juan'
			theStudents = session.createQuery("from Student s where s.lastName='Stark' or s.firstName='Juan'").getResultList();
			
			// display students
			System.out.println("\n\nStudents with last name of Stark OR first name of Juan");
			displayStudents(theStudents);
			
			
			// query students where email LIKE '%springdev.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%springdev.com'").getResultList();
			
			// display students
			System.out.println("\n\nStudents whose email ends with springdev.com");
			displayStudents(theStudents);
			
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}

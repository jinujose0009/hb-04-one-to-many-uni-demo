package com.jinu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jinu.entity.Instructor;
import com.jinu.entity.InstructorDetails;
import com.jinu.entity.Student;

public class DeleteGetinstructorDetailsDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
			
			int instid=3;
			//start Instructor
			session.beginTransaction();
			
			InstructorDetails instructorDetails=session.get(InstructorDetails.class, instid);
			System.out.println("Instructor Details....."+instructorDetails);
			System.out.println("Instructor..........."+instructorDetails.getInsstructor());
			session.delete(instructorDetails);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done..!");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//resolve connection leaking issue
			session.close();
			factory.close();
		}
		
		

	}

}

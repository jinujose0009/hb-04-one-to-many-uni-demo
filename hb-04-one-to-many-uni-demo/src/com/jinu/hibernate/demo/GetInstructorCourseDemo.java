package com.jinu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jinu.entity.Course;
import com.jinu.entity.Instructor;
import com.jinu.entity.InstructorDetails;
import com.jinu.entity.Student;

public class GetInstructorCourseDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
			
			session.beginTransaction();
			int theid=1;
			//Get instructor from db
			Instructor theinstInstructor=session.get(Instructor.class, 1);
			
			System.out.println("Instructor...."+theinstInstructor);
			System.out.println("Cources...."+theinstInstructor.getCources());
			
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done..!");
			
		}
		finally{
			session.close();
			factory.close();
		}
		
		

	}

}

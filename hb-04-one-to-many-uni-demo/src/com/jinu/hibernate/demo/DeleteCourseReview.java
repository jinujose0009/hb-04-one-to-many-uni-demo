package com.jinu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jinu.entity.Course;
import com.jinu.entity.Instructor;
import com.jinu.entity.InstructorDetails;
import com.jinu.entity.Review;
import com.jinu.entity.Student;

public class DeleteCourseReview {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
			
			session.beginTransaction();
			int courseid=10;
			Course thecourse=session.get(Course.class, courseid);
			System.out.println("Course..."+thecourse);
			//delete course
			session.delete(thecourse);
			
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

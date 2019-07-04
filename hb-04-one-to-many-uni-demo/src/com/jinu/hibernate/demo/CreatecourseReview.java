package com.jinu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jinu.entity.Course;
import com.jinu.entity.Instructor;
import com.jinu.entity.InstructorDetails;
import com.jinu.entity.Review;
import com.jinu.entity.Student;

public class CreatecourseReview {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
			
			session.beginTransaction();
			Course thecourse=new Course("Basics of english");
			thecourse.addReviews(new Review("One of the best cource for beginers"));
			thecourse.addReviews(new Review("Not bad"));
			thecourse.addReviews(new Review("Good"));
			thecourse.addReviews(new Review("Best one"));
			thecourse.addReviews(new Review("Not good"));
			
			session.save(thecourse);
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

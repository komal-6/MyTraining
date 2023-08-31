package com.ignek.Hibernateexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Entity;

public class App 
{
    public static void main( String[] args )
    {
    	
    	StudentName sn = new StudentName();
    	sn.setFname("Komal");
    	sn.setMname("Dineshkumar");
    	sn.setLname("Panchal");
    	
    	
        Student s = new Student();
		s.setSid(101);
		s.setColor("Green"); 
		s.setSname(sn);
		/*
		 * s.setSid(102); s.setSname("Piya"); s.setColor("Yellow");
		 */
		  
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        session.persist(s);
        //s = (Student)session.get(Student.class,102);
        t.commit(); 
        System.out.println(s);
    }
}

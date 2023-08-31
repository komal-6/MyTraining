package com.ignek.HibernateDemo;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class App 
{
    public static void main( String[] args )
    {  
       Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class);
       SessionFactory sf = config.buildSessionFactory();
       Session session = sf.openSession();
       session.beginTransaction();
       
       
       Laptop laptop = session.load(Laptop.class, 106);
       //System.out.println(laptop);
       session.getTransaction().commit(); 
    
      
    }
}

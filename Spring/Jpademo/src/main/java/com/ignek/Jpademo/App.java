package com.ignek.Jpademo;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App 
{
    public static void main( String[] args )
    {
    	Student s = new Student();
        s.setSid(101);
        s.setSname("Komal");
        s.setTechnology("Java");
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
      //  Student student = em.find(Student.class, 102);
        em.persist(s);
        em.getTransaction().commit();
        System.out.println(s);
        //System.out.println(student);
    }
}

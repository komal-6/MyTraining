package com.example.cruddemo;

import com.example.cruddemo.dao.AppDao;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	//Executed after the spring bean has been loaded
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
			return runner -> {
				createInstructor(appDao);
				findById(appDao);
				deleteInstructorById(appDao);
			};
	}

	private void deleteInstructorById(AppDao appDao) {
		int id = 1;
		System.out.println("Deleting instructor id: "+id);
		appDao.deleteInstructorById(id);
		System.out.println("Deleted !!!");
	}

	private void findById(AppDao appDao) {
		int id = 1;
		System.out.println("Finding instructor id: "+id);
		Instructor tempInstructor = appDao.findInstructorById(id);
		System.out.println("Temp Instructor: "+tempInstructor);
		System.out.println("The associated instructorDetail only: "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDao appDao) {
		Instructor tempInstructor = new Instructor("Piya","Panchal","piyapanchal0611@gmail.com");
		InstructorDetail tempinstructorDetail = new InstructorDetail("http://www.youtube.com","Travelling");


		//associate the object
		tempInstructor.setInstructorDetail(tempinstructorDetail);

		System.out.println("Save instructor detail: "+tempInstructor);
		appDao.save(tempInstructor);
		//System.out.println("Done!");

	}

}

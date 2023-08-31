package com.example.cruddemo;

import com.example.cruddemo.dao.AppDao;
import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	//Executed after the spring bean has been loaded
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
			return runner -> {
				//createInstructor(appDao);
				//findById(appDao);
				//deleteInstructorById(appDao);
				//findInstructorDetail(appDao);
				//deleteInstructorDetail(appDao);
				//createInstructorWithCourses(appDao);
				//findInstructorWithCourses(appDao);
				//findCoursesForInstructor(appDao);
				//findInsrtuctorWithCourseJoinFetch(appDao);
				//updateInstructor(appDao);
				//updateCourse(appDao);
				//deleteInstructor(appDao);
				deleteCourse(appDao);
			};
	}

	private void deleteCourse(AppDao appDao) {
		int id = 10;
		System.out.println("Deleting course: "+id);
		appDao.deleteCourseById(id);
		System.out.println("Done!!!");
	}

	private void deleteInstructor(AppDao appDao) {
		int id = 6;
		System.out.println("Deleting instructor id: "+id);
		appDao.deleteInstructorById(id);
		System.out.println("Done!!!");
	}

	private void updateCourse(AppDao appDao) {
		int id = 10;
		System.out.println("Finding course id: "+id);
		Course course = appDao.findCourseById(id);
		System.out.println("Updating the course: "+id);
		course.setTitle("Java OOPS concepts");
		appDao.update(course);

	}

	private void updateInstructor(AppDao appDao) {
		int id = 6;
		System.out.println("Finding instructor id: "+id);
		Instructor instructor = appDao.findInstructorById(id);
		System.out.println("Updating instructor id: "+id);
		instructor.setLast_name("Luhar");
		appDao.update(instructor);
	}

	private void findInsrtuctorWithCourseJoinFetch(AppDao appDao) {
		int id = 6;
		System.out.println("Finding instructor id: "+id);
		Instructor instructor = appDao.findInstructorByIdJoinFetch(id);
		System.out.println("Instructor: "+instructor);
		System.out.println("The associated courses: "+instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDao appDao) {
		int id = 6;
		System.out.println("Finding instructor id: "+id);
		Instructor instructor = appDao.findInstructorById(id);
		System.out.println("Instructor: "+instructor);

		//find courses for instrucotr
		System.out.println("Finding course for instrctor id: "+id);
		List<Course> courses = appDao.findCoursesWithInstructorId(id);
		instructor.setCourses(courses);
		System.out.println("Courses: "+instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDao appDao) {
		int id = 6;
		System.out.println("Finding instructor id: "+id);
		Instructor instructor = appDao.findInstructorById(id);
		System.out.println("Instructor: "+instructor);
		System.out.println("Assocaited courses: "+instructor.getCourses());

	}

	private void createInstructorWithCourses(AppDao appDao) {
		Instructor tempInstructor = new Instructor("Komal","Panchal","komalpanchal113@gmail.com");
		InstructorDetail tempinstructorDetail = new InstructorDetail("http://www.youtube.com","Travelling");
		Course course = new Course("Spring boot");

		//associate the object
		tempInstructor.setInstructorDetail(tempinstructorDetail);

		System.out.println("Save instructor detail: "+tempInstructor);
		//appDao.save(tempInstructor);

		tempInstructor.add(course);
		appDao.save(tempInstructor);
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int id = 2;
		System.out.println("Deleting id: "+id);
		appDao.deleteInstructorDetailById(id);
		System.out.println("Done!!!");
	}

	private void findInstructorDetail(AppDao appDao) {
		int id = 2;
		InstructorDetail instructorDetail = appDao.findByInstructorDetailId(id);
		System.out.println("Instrucror Detail: "+instructorDetail);
		System.out.println("The Associated instructor: "+instructorDetail.getInstructor());
		System.out.println("Done!!!");
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
		Instructor tempInstructor = new Instructor("Komal","Panchal","komalpanchal113@gmail.com");
		InstructorDetail tempinstructorDetail = new InstructorDetail("http://www.youtube.com","Travelling");


		//associate the object
		tempInstructor.setInstructorDetail(tempinstructorDetail);

		System.out.println("Save instructor detail: "+tempInstructor);
		appDao.save(tempInstructor);
		//System.out.println("Done!");

	}

}

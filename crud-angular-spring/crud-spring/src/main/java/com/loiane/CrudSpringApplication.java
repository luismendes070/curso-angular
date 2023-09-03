package com.loiane;

import com.loiane.model.Course;
import com.loiane.repository.CourseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		try {
            System.setProperty("spring.profiles.active", "local");
			SpringApplication.run(com.loiane.CrudSpringApplication.class, args);
		}catch (IllegalStateException e){

		}
		catch (Exception e){

			e.printStackTrace();

		}finally {

		}
	} // end main method

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory("Front-end");

			courseRepository.save(c);
		};
	}
}

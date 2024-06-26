package Demo.example.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Demo.example.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{
	
	

	
}

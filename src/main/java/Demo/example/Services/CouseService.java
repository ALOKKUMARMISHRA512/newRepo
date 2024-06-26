package Demo.example.Services;

import java.util.List;

import Demo.example.entities.Course;

public interface CouseService {
	
	public List<Course> getCourses();
	
	public Course  getCourse(long couresId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public Course deleteCourse(long id);
	
}

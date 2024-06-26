package Demo.example.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Demo.example.Dao.CourseDao;
import Demo.example.entities.Course;

@Service
public class CourseServiceImpl  implements CouseService{

//	List<Course> list;
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
		
//		list = new ArrayList<>();
//		list.add(new Course(145,"java course", "this is java course"));
//		list.add(new Course(146, "Python course", "this is python course"));
		
	}
	
	
	@Override
	public List<Course> getCourses() {
		  return courseDao.findAll();
	}
	
	

//	@Override
//	public Course getCourse(long couresId) {
//		return courseDao.getOne(couresId);
//	}
	
    @Override
    public Course getCourse(long courseId) {
        return courseDao.findById(courseId).orElse(null);
    }
	
	
	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	
	
	@Override
	public Course updateCourse(Course course) {
//		for (Course c : list) {
//			if (c.getId() == course.getId()) {
//				c.setTitle(course.getTitle());
//				c.setDescription(course.getDescription());
//				return c;
//			}
//		}
		
		courseDao.save(course);
		return course;
		
	}
	
	
    @Override
    public Course deleteCourse(long id) {
        Course course = courseDao.findById(id).orElse(null);
        if (course != null) {
            courseDao.delete(course);
        }
        return course;
    }

	
	
}

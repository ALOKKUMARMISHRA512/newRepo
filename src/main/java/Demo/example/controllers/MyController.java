package Demo.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Demo.example.Services.CouseService;
import Demo.example.entities.Course;

@RestController
@RequestMapping("/courses")
public class MyController {
	
	 @Autowired
	private CouseService couseService;
	 
//	 @GetMapping("/home")
//	 public String home() {
//		 return "This is hOME Page";
//	 }
	
	@GetMapping
	public List<Course> getCourses(){
		return couseService.getCourses();
	}
	
//	@GetMapping("/courses/{couresId}")
//	public Course getCourse(@PathVariable String couresId){
//		return couseService.getCourse(Long.parseLong(couresId));
//	}
	
	
    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable String courseId) {
        try {
            Long id = Long.parseLong(courseId);
            Course course = couseService.getCourse(id);
            if (course != null) {
                return ResponseEntity.ok(course);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }
	
	
	
	@PostMapping
	public Course addCourses(@RequestBody Course course) {
		return couseService.addCourse(course);
	}
	
	
	@PutMapping
	public Course updateCourses(@RequestBody Course course) {
		return couseService.updateCourse(course);
		
	}
	
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String courseId) {
        try {
            Long id = Long.parseLong(courseId);
            Course deletedCourse = couseService.deleteCourse(id);
            if (deletedCourse != null) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }
	
}

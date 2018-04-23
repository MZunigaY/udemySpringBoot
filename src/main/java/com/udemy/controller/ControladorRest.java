package com.udemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.udemy.entity.Course;
import com.udemy.service.CourseService;

@RestController
public class ControladorRest {
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("/rest/api/records")
	public List<Course> listarTodo() {
		return courseService.listAllCourses();
	}
	
	@GetMapping("/rest/api/records/{nm}/{desc}")
	public List<Course> listarXbusqueda(@PathVariable("nm") String name, @PathVariable("desc") String description) {
		return courseService.listaXbusqueda(name, description);
	}
	
	@PostMapping("/rest/api/records")
	public ResponseEntity<?> addCourse(@RequestBody Course course, UriComponentsBuilder ucBuilder) {
		System.out.println("ENTRA O NO");
		courseService.addCourse(course);
		System.out.println("QUE PASA ACA");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/rest/api/records").buildAndExpand(course.getId()).toUri());
		
		return new ResponseEntity<String>(headers,HttpStatus.OK);
	}
	
	
	
//	Doesn't really work because the URL is already taken
//	@GetMapping("/rest/api/records/")
//	public List<Course> listarXbusqueda(@RequestParam(name="nm", required=false, defaultValue="") String name, 
//			@RequestParam(name="desc", required=false, defaultValue="") String description) {
//		
//		return courseService.listaXbusqueda(name, description);
//	}
	
}

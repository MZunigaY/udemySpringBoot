 package com.udemy.service;

import java.util.List;

import com.udemy.entity.Course;

public interface CourseService {
	
	public List<Course> listAllCourses();
	
	public Course addCourse(Course course);
	
	public int removeCourse(int id);
	
	public Course updateCourse(Course course);
	
	public List<Course> listaXbusqueda(String name, String description);
	
}

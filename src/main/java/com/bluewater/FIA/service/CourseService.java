package com.bluewater.FIA.service;

import java.util.List;

import com.bluewater.FIA.model.Course;

public interface CourseService {
	
	public List<Course> getAll();

	Long createCourse(Course course);

	Course getById(Long id);

	Long addPiloteToCourse(Long id, Course course);
	public String startCourse(Long id, Long vitess);

}

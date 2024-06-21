package com.bluewater.FIA.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bluewater.FIA.model.Course;
import com.bluewater.FIA.model.Pilote;
import com.bluewater.FIA.service.impl.CourseServiceImpl;
import com.bluewater.FIA.service.impl.PiloteServiceImpl;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("course")
@AllArgsConstructor
public class CourseController {

	private CourseServiceImpl courseServiceImpl;

	
	@GetMapping("")
	public List<Course> getAll(){
		return courseServiceImpl.getAll();
	}
	
	@GetMapping("/{id}")
	public Course getById(@PathVariable Long id){
		return courseServiceImpl.getById(id);
	}
	
	@PostMapping("")
	public Long createCourse(@RequestBody Course course) {
		return courseServiceImpl.createCourse(course);
	}
	
	@PostMapping("/{id_pilote}")
	public Long addPiloteToCourse(@PathVariable("id_pilote") Long id,  @RequestBody Course course) {

		return courseServiceImpl.addPiloteToCourse(id, course);
	}
	
	@GetMapping("/{id}/{vitess}/start")
	public String startCourse(@PathVariable Long id, @PathVariable Long vitess){
		
		return courseServiceImpl.startCourse(id, vitess);
	}
	


	
}

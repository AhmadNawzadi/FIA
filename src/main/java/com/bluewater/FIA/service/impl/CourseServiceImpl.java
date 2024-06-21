package com.bluewater.FIA.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bluewater.FIA.dao.CourseRepository;
import com.bluewater.FIA.model.Course;
import com.bluewater.FIA.model.Pilote;
import com.bluewater.FIA.service.CourseService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
	
	private CourseRepository courseRepository;
	private PiloteServiceImpl psi;

	@Override
	public List<Course> getAll() {
		return courseRepository.findAll();
	}

	@Override
	public Long createCourse(Course course) {
		course.setStartDate(LocalDate.now());
		courseRepository.save(course);
		return course.getId();
	}

	@Override
	public Course getById(Long id) {
		return courseRepository.findById(id).orElse(null);
	}

	@Override
	public Long addPiloteToCourse(Long id, Course course) {
		Pilote pilote = psi.getById(id);
		course.setPilotes(List.of(pilote));
		courseRepository.save(course);
		return course.getId();
		
	}

	@Override
	public String startCourse(Long id, Long vitess) {
		Course course = courseRepository.findById(id).orElse(null);
		StringBuilder result = new StringBuilder();
		
		course.getPilotes().stream().filter(i -> (i.getVoiture().getVitesse()) > vitess)
		.forEach(s -> result.append("le pilote %s peut participer a la course avec sa voiture %s"
				.formatted(s.getNom(), s.getVoiture().getNom())));
		
		return result.toString();
	}

}

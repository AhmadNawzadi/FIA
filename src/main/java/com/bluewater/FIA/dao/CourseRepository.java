package com.bluewater.FIA.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluewater.FIA.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}

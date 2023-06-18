package com.student.enquiry.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.enquiry.admin.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

}

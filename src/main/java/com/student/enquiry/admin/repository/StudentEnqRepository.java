package com.student.enquiry.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.enquiry.admin.entities.StudentEnquiresEntity;

public interface StudentEnqRepository extends JpaRepository<StudentEnquiresEntity, Integer>{

}

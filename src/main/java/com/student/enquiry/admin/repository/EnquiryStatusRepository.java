package com.student.enquiry.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.enquiry.admin.entities.EnquiryStatusEntity;

public interface EnquiryStatusRepository extends JpaRepository<EnquiryStatusEntity, Integer> {

}

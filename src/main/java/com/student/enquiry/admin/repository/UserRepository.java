package com.student.enquiry.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.enquiry.admin.entities.UserDetailsEntity;

public interface UserRepository extends JpaRepository<UserDetailsEntity, Integer> {

}

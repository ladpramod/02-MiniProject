package com.student.enquiry.admin.repository;

import com.student.enquiry.admin.entities.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetailsEntity, Integer> {

	public UserDetailsEntity findByEmail(String email);

	public UserDetailsEntity findByEmailAndPassword(String email, String password);
}

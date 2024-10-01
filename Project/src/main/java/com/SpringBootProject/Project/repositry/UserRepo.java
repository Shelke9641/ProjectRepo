package com.SpringBootProject.Project.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootProject.Project.entity.UserDetails;

public interface UserRepo extends JpaRepository<UserDetails, Integer> {

}

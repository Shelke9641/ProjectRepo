package com.SpringBootProject.Project.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.ui.Model;

import com.SpringBootProject.Project.entity.UserDetails;

public interface UserService {
    List<UserDetails> findAllUsers();
    boolean updateUserField(Long userId, String field, String value);
    void updateUser(User user);
	void updateUser(UserDetails user);
}

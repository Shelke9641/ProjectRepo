package com.SpringBootProject.Project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootProject.Project.entity.UserDetails;
import com.SpringBootProject.Project.repositry.UserRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserRepo repo;

    @GetMapping("/home")
    public String home() {
        return "index2";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserDetails u) {
        repo.save(u);
        System.out.println(u);
        return "redirect:/home";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<UserDetails> users = repo.findAll();
        model.addAttribute("userList", users);
        return "userList";
    }

    @PostMapping("/updateUser")
    public String updateUser1(@RequestParam("id") int id, @ModelAttribute UserDetails updatedUser) {
        UserDetails exist = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
        exist.setFname(updatedUser.getFname());
        exist.setGender(updatedUser.getGender());
        exist.setFemail(updatedUser.getFemail());
        exist.setFphone(updatedUser.getFphone());
        exist.setDate(updatedUser.getDate());
        exist.setEducation(updatedUser.getEducation());
        exist.setCountry(updatedUser.getCountry());
        exist.setState(updatedUser.getState());
        exist.setCity(updatedUser.getCity());
        repo.save(exist);
        return "redirect:/users";
    }

    // Add inline update method for updating specific user fields via AJAX
    @PostMapping("/updateUserInline")
    public ResponseEntity<?> updateUserInline(@RequestBody Map<String, String> updateData) {
        try {
            // Extract user ID, field name, and new value from the request body
            int userId = Integer.parseInt(updateData.get("id"));
            String field = updateData.get("field");
            String newValue = updateData.get("value");

            // Retrieve the existing user
            UserDetails user = repo.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));

            // Update the specific field based on the field name
            switch (field) {
                case "fname":
                    user.setFname(newValue);
                    break;
                case "gender":
                    user.setGender(newValue);
                    break;
                case "femail":
                    user.setFemail(newValue);
                    break;
                case "fphone":
                    user.setFphone(newValue);
                    break;
                case "date":
                    user.setDate(newValue);
                    break;
                case "education":
                    user.setEducation(newValue);
                    break;
                case "country":
                    user.setCountry(newValue);
                    break;
                case "state":
                    user.setState(newValue);
                    break;
                case "city":
                    user.setCity(newValue);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field name: " + field);
            }

            // Save the updated user record to the database
            repo.save(user);

            // Return a success response
            return ResponseEntity.ok("User updated successfully");
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            return ResponseEntity.status(500).body("Error occurred while updating user: " + e.getMessage());
        }
    }
}

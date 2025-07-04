package com.msbte.notes.provider.msbte_notes_provider.controller;

//import com.msbte.notes.provider.msbte_notes_provider.Model.MSBTE;
import com.msbte.notes.provider.msbte_notes_provider.Model.admin;
import com.msbte.notes.provider.msbte_notes_provider.Services.AdminService;

import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Show Signup Page
    @GetMapping("/singup")
    public String showSignupForm() {
        return "singup";
    }

    // Handle Signup
    @PostMapping("/singup1")
    public String register(@RequestParam String email, @RequestParam String password) {
        admin admin = new admin();
        admin.setEmail(email);
        admin.setPassword(password);
        adminService.register(admin);
        return "login";
    }

    // Show Login Page
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Handle Login
    @PostMapping("/dashbord")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        if (adminService.authenticate(email, password)) {
            session.setAttribute("adminEmail", email);
            return "dashbord";
        } else {
            return "redirect:/login.html?error=true";
        }
    }

    // Handle Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }


    
@DeleteMapping("/delete-user/{id}")
public ResponseEntity<String> deleteNote2(@PathVariable Long id) {
    adminService.deleteNote1(id);
    return ResponseEntity.ok("Note deleted successfully!");
}

  @ResponseBody
    @GetMapping("/user")
    public List<admin> getAllNotes2() {
        return adminService.getAllNotes1(); // return JSON data
    }
}

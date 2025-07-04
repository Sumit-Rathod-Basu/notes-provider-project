package com.msbte.notes.provider.msbte_notes_provider.controller;

import java.io.IOException;
import java.util.List;

//import com.msbte.notes.provider.msbte_notes_provider.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.msbte.notes.provider.msbte_notes_provider.Model.MSBTE;
import com.msbte.notes.provider.msbte_notes_provider.Services.MSBTEService;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/note")
@ComponentScan(basePackages = {"com.msbte.notes.provider.msbte_notes_provider.Services"})
public class MSBTEController 
{
            

       @Autowired
        private MSBTEService ms;
    
    @PostMapping("/uploadNotes")
           public String uploadNotes(
           @RequestParam String title,
            @RequestParam String subject,
            @RequestParam String semester,
            @RequestParam String description,
            @RequestParam boolean isPaid,
            @RequestParam MultipartFile pdf,
            @RequestParam MultipartFile image) throws IOException
        {
               ms.uploadNote(title,subject,semester,description,isPaid,pdf,image);
           return "dashbord";

        }

    /*       @GetMapping("/admin/dashboard")
    public String dashboardPage() {
        return "dashboard"; // ✅ This loads admin-dashboard.html
    } */

  // ✅ API for JavaScript fetch (used in fetchNotes() in your HTML)
    @ResponseBody
    @GetMapping("/notes")
    public List<MSBTE> getAllNotes() {
        return ms.getAllNotes(); // return JSON data
    }

    // ✅ DELETE Note by ID
@PostMapping("/update")
public ResponseEntity<String> updateNote(@RequestBody MSBTE updatedNote) {
    ms.updateNote(updatedNote);
    return ResponseEntity.ok("Note updated successfully!");
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteNote(@PathVariable Integer id) {
    ms.deleteNote(id);
    return ResponseEntity.ok("Note deleted successfully!");
}


}


package com.msbte.notes.provider.msbte_notes_provider.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.msbte.notes.provider.msbte_notes_provider.Model.MSBTE;
import com.msbte.notes.provider.msbte_notes_provider.Model.admin;

@Service
public class AdminService {
    @Autowired
    private com.msbte.notes.provider.msbte_notes_provider.Repository.adminRepo adminRepo;
    
    public void register(admin admin) {
        adminRepo.save(admin);
    }

    public boolean authenticate(String email, String password) {
        admin admin = adminRepo.findByEmail(email);
        return admin != null && admin.getPassword().equals(password);
    }

    public void deleteNote1(Long id) {
    adminRepo.deleteById(id);
        }

          public List<admin> getAllNotes1() {
        return adminRepo.findAll();
    }
}

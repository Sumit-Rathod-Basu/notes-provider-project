package com.msbte.notes.provider.msbte_notes_provider.Services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.msbte.notes.provider.msbte_notes_provider.Model.MSBTE;
import com.msbte.notes.provider.msbte_notes_provider.Repository.msbterepo;

@Service
public class MSBTEService {

    @Autowired
    private msbterepo noteRepo;

    public void uploadNote(String title, String subject, String semester, String description,
                           boolean isPaid, MultipartFile pdf, MultipartFile image) throws IOException {

        // ✅ Get absolute project path
        String basePath = System.getProperty("user.dir"); // Gets project root
        String imageDir = basePath + "/uploads/images";
        String pdfDir = basePath + "/uploads/pdfs";

        // ✅ Create directories if they don't exist
        new File(imageDir).mkdirs();
        new File(pdfDir).mkdirs();

        // ✅ Get clean file names
        String imageFileName = Paths.get(image.getOriginalFilename()).getFileName().toString();
        String pdfFileName = Paths.get(pdf.getOriginalFilename()).getFileName().toString();

        // ✅ Save files using absolute paths
        image.transferTo(new File(imageDir + "/" + imageFileName));
        pdf.transferTo(new File(pdfDir + "/" + pdfFileName));

        // ✅ Save only file names in DB
        MSBTE note = new MSBTE();
        note.setTitle(title);
        note.setSubject(subject);
        note.setSemester(semester);
        note.setDescription(description);
        note.setPaid(isPaid);
        note.setImageFilePath(imageFileName);
        note.setPdfFilePath(pdfFileName);

        noteRepo.save(note);
    }

    public List<MSBTE> getAllNotes() {
        return noteRepo.findAll();
    }
    public void updateNote(MSBTE updatedNote) {
    MSBTE existing = noteRepo.findById(updatedNote.getId()).orElseThrow();
    existing.setTitle(updatedNote.getTitle());
    existing.setSubject(updatedNote.getSubject());
    existing.setSemester(updatedNote.getSemester());
    existing.setDescription(updatedNote.getDescription());
    existing.setPaid(updatedNote.getPaid());
    noteRepo.save(existing);
}

public void deleteNote(Integer id) {
    noteRepo.deleteById(id);
}

}


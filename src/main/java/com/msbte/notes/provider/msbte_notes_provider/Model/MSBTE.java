package com.msbte.notes.provider.msbte_notes_provider.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class MSBTE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String subject;
    private String semester;

    @Column(name = "branch") // This is actually your "description"
    private String description;

    @Column(name = "paid")
    private boolean isPaid;

    @Column(name = "pdf_file_path")
    private String pdfFilePath;

    @Column(name = "image_file_path")
    private String imageFilePath;

    // ✅ Getters
    public Integer getId() { return id; }
    public String getTitle() { return title; }
    public String getSubject() { return subject; }
    public String getSemester() { return semester; }
    public String getDescription() { return description; }
    public boolean getPaid() { return isPaid; }
    public String getPdfFilePath() { return pdfFilePath; }
    public String getImageFilePath() { return imageFilePath; }

    // ✅ Setters
    public void setTitle(String title) { this.title = title; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setSemester(String semester) { this.semester = semester; }
    public void setDescription(String description) { this.description = description; }
    public void setPaid(boolean paid) { this.isPaid = paid; }
    public void setPdfFilePath(String pdfFilePath) { this.pdfFilePath = pdfFilePath; }
    public void setImageFilePath(String imageFilePath) { this.imageFilePath = imageFilePath; }
}

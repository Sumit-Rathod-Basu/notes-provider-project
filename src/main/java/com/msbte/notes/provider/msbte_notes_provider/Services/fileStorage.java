package com.msbte.notes.provider.msbte_notes_provider.Services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class fileStorage {

    public String saveFile(MultipartFile file, String folder) throws IOException {
    // ✅ Hardcoded absolute path (recommended for testing; later use config)
    String basePath = "C:/Users/Admin/Desktop/Don/jpa/MSBTE-Project/msbte_notes_provider/src/main/uploads";

    // ✅ Full directory path: basePath + /pdfs or /images or /any_folder
    String dir = basePath + File.separator + folder;
    Files.createDirectories(Paths.get(dir));  // create if not exists

    // ✅ Final full path
    String path = dir + File.separator + file.getOriginalFilename();
    file.transferTo(new File(path));

    System.out.println("File saved to: " + path);
    return path;
}

}

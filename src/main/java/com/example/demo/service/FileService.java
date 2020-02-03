package com.example.demo.service;

import com.example.demo.domain.File;
import com.example.demo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    @Value("${media.image.path}")
    public String absolutePath;

    @Value("video")
    public String dir;

    public File upload(MultipartFile file) {
        Path copyLocation = null;
        
        try {
            copyLocation = Paths
                    .get( absolutePath + java.io.File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return save(file.getOriginalFilename(), dir, 0, file.getContentType(), file.getSize());
    }

    public File save(String name, String dir, long created, String type, long size) {
        File file = new File(name, dir, created, type, size);
        return fileRepository.save(file);
    }

    public File findById(long id) {
        return fileRepository.findById(id);
    }

    public List<File> findByTutorialId(long id) {
        return fileRepository.findByTutorialId(id);
    }
}
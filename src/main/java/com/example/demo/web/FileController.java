package com.example.demo.web;

import com.example.demo.domain.File;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    @ResponseBody
    public File findById(long id) {
        return fileService.findById(id);
    }

    @RequestMapping(value = "/tutorial/{id}", method=RequestMethod.GET)
    @ResponseBody
    public List<File> findByTutorialId(@PathVariable long id) {
        return fileService.findByTutorialId(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public File upload(@RequestParam("file") MultipartFile file) {
        System.out.println(file);
        return fileService.upload(file);
    }
}
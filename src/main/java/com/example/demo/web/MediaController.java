package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MediaController {

    @Value("${media.image.path}")
    public String absolutePath;

    @RequestMapping(value="/media/image/{name}", method=RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable String name) throws IOException {
        File img = new File(absolutePath+name);
        return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
    }

}
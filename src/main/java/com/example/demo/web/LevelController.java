package com.example.demo.web;

import com.example.demo.domain.Language;
import com.example.demo.domain.Level;
import com.example.demo.repository.LanguageRepository;
import com.example.demo.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LevelController {

    @Autowired
    LevelRepository levelRepository;

    @RequestMapping(value="/level", method= RequestMethod.GET)
    @ResponseBody
    public List<Level> findAll() {
        return levelRepository.findAll();
    }

}
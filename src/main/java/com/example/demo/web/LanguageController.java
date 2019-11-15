package com.example.demo.web;

import com.example.demo.domain.Country;
import com.example.demo.domain.Language;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LanguageController {

    @Autowired
    LanguageRepository languageRepository;

    @RequestMapping(value="/language", method= RequestMethod.GET)
    @ResponseBody
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

}
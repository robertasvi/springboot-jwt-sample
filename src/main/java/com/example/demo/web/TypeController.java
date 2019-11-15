package com.example.demo.web;

import com.example.demo.domain.Language;
import com.example.demo.domain.Type;
import com.example.demo.repository.LanguageRepository;
import com.example.demo.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TypeController {

    @Autowired
    TypeRepository typeRepository;

    @RequestMapping(value="/type", method= RequestMethod.GET)
    @ResponseBody
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

}
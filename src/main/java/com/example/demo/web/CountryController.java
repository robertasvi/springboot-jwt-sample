package com.example.demo.web;

import com.example.demo.domain.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @RequestMapping(value="/country", method= RequestMethod.GET)
    @ResponseBody
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

}

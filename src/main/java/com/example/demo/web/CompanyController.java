package com.example.demo.web;

import com.example.demo.domain.Company;
import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Company add(@RequestBody Company company) {
        return companyService.save(company);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Company update(@RequestBody Company company) {
        return companyService.save(company);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Company findById(@PathVariable long id) {
        return companyService.findById(id);
    }

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public List<Company> findAll() {
        return companyService.findAll();
    }

}

package com.example.demo.web;

import com.example.demo.domain.Certificate;
import com.example.demo.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    CertificateService certificateService;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Certificate add(@RequestBody Certificate cert) {
        return certificateService.save(cert);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Certificate update(@RequestBody Certificate cert) {
        return certificateService.save(cert);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Certificate findById(@PathVariable long id) {
        return certificateService.findById(id);
    }

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public List<Certificate> findAll() {
        return certificateService.findAll();
    }

    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    @ResponseBody
    public List<Certificate> findByUserId(@PathVariable long id) {
        return certificateService.findByUserId(id);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        Certificate existed = this.certificateService.findById(id);
        certificateService.delete(existed);
    }


}

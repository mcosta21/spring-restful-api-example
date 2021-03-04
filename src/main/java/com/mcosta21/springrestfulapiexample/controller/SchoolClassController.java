package com.mcosta21.springrestfulapiexample.controller;

import java.util.List;

import com.mcosta21.springrestfulapiexample.repository.SchoolClassRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mcosta21.springrestfulapiexample.model.SchoolClass;

@RestController
@RequestMapping("/schoolClass")
public class SchoolClassController {
    
    private final SchoolClassRepository _schoolClassRepository;

    public SchoolClassController(SchoolClassRepository _schoolClassRepository) {
        this._schoolClassRepository = _schoolClassRepository;
    }

    @GetMapping("/")
    public List<SchoolClass> getStudents() {
        return _schoolClassRepository.findAll();
    }

    @PostMapping("/")
    public void postStudent(@RequestBody SchoolClass schoolClass) {
        _schoolClassRepository.save(schoolClass);
    }

}

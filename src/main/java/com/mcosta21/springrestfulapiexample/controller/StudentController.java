package com.mcosta21.springrestfulapiexample.controller;

import java.util.ArrayList;
import java.util.List;

import com.mcosta21.springrestfulapiexample.repository.SchoolClassRepository;
import com.mcosta21.springrestfulapiexample.repository.StudentRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcosta21.springrestfulapiexample.controller.request.StudentRequest;
import com.mcosta21.springrestfulapiexample.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
    
    private final StudentRepository _studentRepository;
    private final SchoolClassRepository _schoolClassRepository;

    public StudentController(StudentRepository _studentRepository, SchoolClassRepository _schoolClassRepository) {
        this._studentRepository = _studentRepository;
        this._schoolClassRepository = _schoolClassRepository;
    }

    @GetMapping("/")
    public List<StudentRequest> index() {
        List<Student> students = _studentRepository.findAll();

        List<StudentRequest> studentRequests = new ArrayList<StudentRequest>();
        
        for (Student _student : students) {
            
            String discipline = _student.getSchoolClass() != null ? _student.getSchoolClass().getDiscipline() : "";
            StudentRequest studentRequest = new StudentRequest(
                _student.getId(), 
                _student.getName(), 
                _student.getAddress(), 
                discipline);

            studentRequests.add(studentRequest);
        }

        return studentRequests;
    }

    @PostMapping("/")
    public void post(@RequestBody StudentRequest _student) {
        Student student = new Student(_student.getId(), _student.getName(), _student.getAddress(), null);
        _studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        var student = _studentRepository.findById(id);

        if(student.isPresent()) {
            _studentRepository.delete(student.get());
        }
        else {
            throw new Exception("Student not founded");
        }
    }


}

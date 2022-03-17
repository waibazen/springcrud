package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class Controller {

    @Autowired
    private StudentRepo studentRepo;



    @GetMapping("/")
    public String  home() {
        return "<h1>welcome to the Student Portal</h1>";
    }
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {

        Optional<Student> student= studentRepo.findById(id);//method ko return type optional rakham for nullcheck
        if (student.isEmpty())
            throw new RuntimeException("No Cusotmer git  found  ok ");//not working

        return student.get();
    }




    @PostMapping("/student/add")
    public Student createStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }


    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable("id") Long id) {

        Optional<Student> student = studentRepo.findById(id);
        if (student.isEmpty())
            throw new RuntimeException("No Cusotmer found check git changes");
            studentRepo.delete(student.get());

        return " student deleted:"+id;
    }
//	@PostMapping("/employee/{id}")
//	public String updateEmployee(@PathVariable("id") Long id) {
//
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if (employee.isEmpty())
//			throw new RuntimeException("No Employee found");
//		employeeRepository.saveorUpdate(employee.get());
//
//		return "employee deleted";
//	}

    @PutMapping("/student/{id}")
    public  Student updateStudent(@RequestBody Student student, @PathVariable long id) {

        Optional<Student> studentOptional = studentRepo.findById(id);

        if (studentOptional.isEmpty())
            throw new RuntimeException("No Employee found in git stagecrud");


        return studentRepo.save(student);


    }


}
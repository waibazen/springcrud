package com.example.demo.controller;

import com.example.demo.Exception.NoStudentFoundException;

//import com.example.demo.Exception.userNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
//import java.util.Optional;
import java.util.NoSuchElementException;

// javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
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
     try{
         Student  student= studentRepo.findById(id).get();
         return student;
     }   
    //method ko return type optional rakham for nullcheck

    catch(NoSuchElementException ex){//catch block takes precedence over controller advice
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
            //throw new NoStudentFoundException("404", "Student not found");
        }
   
       
    }




    @PostMapping("/student/add")
    public Student createStudent(@RequestBody Student student) {    //just return same object what it got from the request which is not necessary   to return the object
       return studentRepo.save(student);
        //System.out.println("Student added successfully");
    }


    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable("id") Long id ) {  //request parameter is id and it is of type long
    Student student = studentRepo.findById(id).get();
        try{
           
        studentRepo.delete(student);
        System.out.println("Student deleted successfully");
        }
        catch(NoStudentFoundException e){
            throw new ResponseStatusException( HttpStatus.NOT_FOUND,  "not found", e);
           
        }
        
        
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
    public  Student updateStudent(@RequestBody Student studentOptional, @PathVariable long id) throws Exception {
      

       Student  student= studentRepo.findById(id).get();
            student.setFirstName(studentOptional.getFirstName());
            student.setLastName(studentOptional.getLastName());
            student.setEmail(studentOptional.getEmail());
            student.setAddress(studentOptional.getAddress());
             

           return studentRepo.save(student);
           
    }




   
}
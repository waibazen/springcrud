package com.example.demo.controller;

import com.example.demo.Exception.NoStudentFoundException;

//import com.example.demo.Exception.userNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

//import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.slf4j.Logger;
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
public class StudentController {

    //private static final String STUDENT_NOT_FOUND = "Student not found";
    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
    private static final ObjectMapper mapper = new ObjectMapper();


    @Autowired
    private StudentRepo studentRepo;

    
    @GetMapping("/")
    public String  home() {
        return "<h1>welcome to the Student Portal</h1>";
    }
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        LOG.info("getAllStudents()");
        return studentRepo.findAll();
    }
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        LOG.info("getStudentById():"+id+"(+)");
        
     try{
         Student  student= studentRepo.findById(id).get();
         return student;
         
     }   
    //method ko return type optional rakham for nullcheck
    

    catch(NoSuchElementException ex){//catch block takes precedence over controller advice
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
            
        }

        catch(Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
        finally{
            LOG.info("getStudentById():"+id+"(-)");
        }
        
    }




    @PostMapping("/student/add")
    public Student createStudent(@RequestBody Student student) {    //just return same object what it got from the request which is not necessary   to return the object
       return studentRepo.save(student);
        //System.out.println("Student added successfully");
    }


    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable("id") Long id ) throws Exception {  //request parameter is id and it is of type long
    Student student = studentRepo.findById(id).get();
        try{
          student=null; 
        studentRepo.delete(student);
        System.out.println("Student deleted successfully");
        }
        catch(IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
       
        
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(),e.getCause());
           
        }
        
        
    }


    @PutMapping("/student/{id}")
    public  Student updateStudent(@RequestBody Student studentOptional, @PathVariable long id) throws Exception {
      

       Student  student= studentRepo.findById(id).get();
       try{

        if(studentOptional.getFirstName()!=null && studentOptional.getLastName()!=null && studentOptional.getEmail()!=null
        && studentOptional.getAddress()!=null){
            student.setFirstName(studentOptional.getFirstName());
            student.setLastName(studentOptional.getLastName());
        student.setEmail(studentOptional.getEmail());
        student.setAddress(studentOptional.getAddress());
        }
        else{
            throw new Exception("Please fill all the fields");
        }
        return studentRepo.save(student);
       
        
       }
         catch(NoStudentFoundException e){
              throw new ResponseStatusException( HttpStatus.NOT_FOUND,  "not found",e.getCause());
         }
         catch(Exception e){
              throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR,  "Internal Server Error brought to you buy",e.getCause());
         }  
            finally{
                LOG.info("updateStudent():"+id+"(-)");
            }
            
           
    }




   
}
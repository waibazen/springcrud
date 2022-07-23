package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

import ch.qos.logback.core.boolex.Matcher;

//@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
@AutoConfigureMockMvc
public class StudentControllerTest {
   // @Spy
    @InjectMocks
    StudentController studentController;
    
   @MockBean
   Student student;

    @MockBean
    private StudentRepo studentRepo;
    
    @Autowired
    private MockMvc mockMvc;
   
    
    @Test
    void test0_welcome_happypath_returnSuccess() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/")).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String actual = response.getContentAsString();
        
        assertEquals("<h1>welcome to the Student Portal</h1>", actual);
    }

    @Test
    void test01_validinput_returnsuccessResponse() throws Exception {
        //given
        Student RECORD_1 = new Student("John", "Doe","johnDoe@gmal.com","5631 madison ave");
        Student RECORD_2 = new Student("Jane", "Doer","janedoer@gmail.com","5632 madison ave");
		
		  List<Student> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2));
	    
        
        Mockito.when(studentRepo.findAll()).thenReturn(records);//mock behavior
        //when
       MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/api/students"))
       
        //print the request and response
       .andExpect(MockMvcResultMatchers.status().isOk())
        
       //then
       .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("John"))
       .andReturn();
	    	MockHttpServletResponse response = result.getResponse();  
            int Status = response.getStatus();  
	    	  //then more   
	    	assertEquals(200,Status); //asserting the status code );   
            assertNotNull(result.getResponse().getContentAsString()); //asserting the content of the response
      


        }

    @Test
    void test4_GetStudentById_happyPath_succeed() throws Exception {
      Student student1 = new Student(1L, "John", "Doe", "Jonhdoe@yahoo.com", "5631 Madison Ave");
      Student student2 = new Student(2L, "Jane", "Doe", "Janedoe@yahoo.com", "5632 Madison Ave");
        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2));
        Mockito.when(studentRepo.findById(1L)).thenReturn(students.stream().filter(s -> s.getId() == 1L).findFirst());
    MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/api/student/1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"))
        .andReturn();
        MockHttpServletResponse response = result.getResponse();
        int Status = response.getStatus();
        assertEquals(200, Status);
       
        
       
        
    }
    @Test
    void test5_GetStudentById_happyPath_succeed() throws Exception {
      Student student1 = new Student(1L, "John", "Doe", "Jonhdoe@yahoo.com", "5631 Madison Ave");
      Student student2 = new Student(2L, "Jane", "Doe", "Janedoe@yahoo.com", "5632 Madison Ave");
        List<Student> students = new ArrayList<>(Arrays.asList(student1, student2));
       Mockito.when(studentRepo.findById(1L)).thenReturn(students.stream().filter(s -> s.getId() == 1L).findFirst());
    MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/api/student/99"))
        //.andExpect(MockMvcResultMatchers.status().)
        //.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"))
        .andReturn();
        MockHttpServletResponse response = result.getResponse();
        int Status = response.getStatus();
        assertEquals(404, Status);
       

   
   
}
}


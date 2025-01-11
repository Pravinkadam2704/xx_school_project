package com.spring.school.schoolController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.school.schoolService.SchoolServiceInterface;
import com.spring.school.student.Student;

@RestController
public class schoolController {

    @Autowired
    private SchoolServiceInterface students;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students.getStudents();
    }

    //Get student names who studies in 8th std in the descending order of student id
    @GetMapping("/studentsnames")
    public List<String> getStudentsNames(){
        return students.getStudentsNames();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable String id){
        return students.getStudent(Integer.parseInt(id));
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        students.addStudent(student);
    }

    @PutMapping("/students")
    public void updateStudent(@RequestBody Student student){
        students.updateStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable String id){
        try {
            students.deleteStudent(Integer.parseInt(id));
        } catch (Exception e) {
            
        }
    }
}

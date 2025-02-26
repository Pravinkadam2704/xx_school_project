package com.spring.school.schoolService;

import java.util.List;

import com.spring.school.student.Student;

public interface SchoolServiceInterface {

    public List<Student> getStudents();

    public List<String> getStudentsNames();

    public Student getStudent(int id);

    public void addStudent(Student student);

    public void updateStudent(Student student);

    public void deleteStudent(int id);
    
}

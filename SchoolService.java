package com.spring.school.schoolService;
import com.spring.school.student.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SchoolService implements SchoolServiceInterface{

    List<Student> studentList;

    public SchoolService() {
        studentList=new ArrayList<>();
        studentList.add(new Student(101, "Pravin", 15, 10));
        studentList.add(new Student(102, "Akshay", 13, 8));
        studentList.add(new Student(103, "Vinod", 13, 8));
        studentList.add(new Student(104, "Rajesh", 15, 10));
        studentList.add(new Student(105, "Sahil", 14, 10));
        studentList.add(new Student(106, "Pratik", 14, 9));
        studentList.add(new Student(107, "Bhavesh", 13, 9));
        studentList.add(new Student(108, "Arun", 16, 10));
    }

    @Override
    public List<Student> getStudents() {
        return studentList;
    }

    @Override
    public List<String> getStudentsNames() {
        List<String> list=null;

        list=studentList.stream().filter(student->student.getStudentClass()==8)
                        .sorted(Comparator.comparingInt(Student::getStudentId).reversed())
                        .map(student->student.getStudentName()).collect(Collectors.toList());
        return list;
    }

    @Override
    public Student getStudent(int id) {

        for(Student student : studentList){
            if(student.getStudentId()==id){
                return student;
            }
        }

        return null;       
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void updateStudent(Student student) {
        for(Student s1 : studentList){
            if(s1.getStudentId()==student.getStudentId()){
                s1.setStudentAge(student.getStudentAge());
                s1.setStudentName(student.getStudentName());
                s1.setStudentClass(student.getStudentClass());

                return;
            }
        }
    }

    @Override
    public void deleteStudent(int id) {
        studentList=studentList.stream().filter(student->student.getStudentId()!=id)
                    .collect(Collectors.toList());
    }

    
}

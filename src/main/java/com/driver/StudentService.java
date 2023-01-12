package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addTeacherStudent(String studentName,String teacherName){
        studentRepository.addTeacherStudent(studentName, teacherName);
    }

    public Student getStudent(String name){
        return studentRepository.getStudent(name);
    }

    public Teacher getTeacher(String name){
        return studentRepository.getTeacher(name);
    }

    public List<String> getListOfStudentByTeacher(String name){
        return studentRepository.getListOfStudentByTeacher(name);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherAndItsStudent(String teacherName){
        studentRepository.deleteTeacherAndItsStudent(teacherName);
    }

    public void deleteAllTeacherStudent(){
        studentRepository.deleteAllTeacherStudent();
    }
}

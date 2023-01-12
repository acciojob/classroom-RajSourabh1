package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class StudentRepository {

    HashMap<String,Student> studentMap = new HashMap<>();
    HashMap<String,Teacher> teacherMap = new HashMap<>();
    HashMap<String,List<String>> teacherStudentMap = new HashMap<>();

    public void addStudent(Student student){
        studentMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }

    public void addTeacherStudent(String studentName,String teacherName){

        if(studentMap.containsKey(studentName) && teacherMap.containsKey(teacherName)){
            List<String> listStudentByTeacher = new ArrayList<>();

            if(teacherStudentMap.containsKey(teacherName))
                listStudentByTeacher= teacherStudentMap.get(teacherName);

            listStudentByTeacher.add(studentName);

            teacherStudentMap.put(teacherName,listStudentByTeacher);
        }
    }

    public Student getStudent(String name){
        return studentMap.get(name);
    }

    public Teacher getTeacher(String name){
        return teacherMap.get(name);
    }

    public List<String> getListOfStudentByTeacher(String name){
        List<String> studentList = new ArrayList<>();

        studentList = teacherStudentMap.get(name);

        return studentList;
    }

    public List<String> getAllStudents(){
        List<String> studentList = new ArrayList<>();

        for(String name : studentMap.keySet()){
            studentList.add(name);
        }

        return studentList;
    }

    public void deleteTeacherAndItsStudent(String teacherName){
        teacherMap.remove(teacherName);

        List<String> studentList = new ArrayList<>();

        studentList = teacherStudentMap.get(teacherName);
        for(String name : studentList){
            if(studentMap.containsKey(name))
                studentMap.remove(name);
        }

        teacherStudentMap.remove(teacherName);
    }

    public void deleteAllTeacherStudent(){
        studentMap = new HashMap<>();
        teacherMap = new HashMap<>();
        teacherStudentMap = new HashMap<>();
    }

}

package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class StudentRepository {

    HashMap<String,Student> studentMap = new HashMap<>();
    HashMap<Teacher,List<String>> teacherMap = new HashMap<>();

    public void addStudent(Student student){
        studentMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
        List<String> studentList = new ArrayList();
        teacherMap.put(teacher,studentList);
    }

    public void addTeacherStudent(String studentName,String teacherName){
        for (Teacher teacher1:teacherMap.keySet()) {
            if (Objects.equals(teacherName, teacher1.getName())) {
                List<String> list;
                list = teacherMap.get(teacher1);
                list.add(studentName);
                teacherMap.put(teacher1, list);
                return;
            }
        }
    }

    public Student getStudent(String name){
        return studentMap.get(name);
    }

    public Teacher getTeacher(String name){
        for(Teacher teacher:teacherMap.keySet()){
            if(Objects.equals(name, teacher.getName()))
                return teacher;
        }
        return null;
    }

    public List<String> getListOfStudentByTeacher(String name){
        for(Teacher teacher:teacherMap.keySet()){
            if(Objects.equals(name, teacher.getName()))
                return teacherMap.get(teacher);
        }
        return null;
    }

    public List<String> getAllStudents(){
        List<String> studentList = new ArrayList<>();

        for(String name : studentMap.keySet()){
            studentList.add(name);
        }
        return studentList;
    }

    public void deleteTeacherAndItsStudent(String teacherName){
        List<String> studentList = new ArrayList<>();
        for(Teacher teacher: teacherMap.keySet()){
            if(Objects.equals(teacherName, teacher.getName())){
                studentList = teacherMap.get(teacher);
                teacherMap.remove(teacher);
                break;
            }
        }
        for(String name : studentList){
            if(studentMap.containsKey(name))
                studentMap.remove(name);
        }
    }

    public void deleteAllTeacherStudent(){
        studentMap = new HashMap<>();
        teacherMap = new HashMap<>();
    }

}

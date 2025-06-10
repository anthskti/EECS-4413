package com.name.studentapp;

import java.util.ArrayList; 

import java.util.List; 

  

public class StudentDAO { 
    private static List<Student> students = new ArrayList<>(); 

    public Student create(Student student) { 
        students.add(student); 
        return student; 
    } 

  

    public List<Student> readAll() { 
        return students; 
    } 

  

    public Student read(int id) { 
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null); 
    } 

  

    public Student update(int id, Student student) { 
        // Implement update logic 
    	Student updatedStudent = null;
    	 for (int i = 0; i < students.size(); i++) {
    		 if (students.get(i).getId() == id) {
    			 students.set(i, student);
    			 updatedStudent = students.get(i);
    		 }
    	 }
        // ... 

        return updatedStudent; 

    } 

  

    public void delete(int id) { 

        students.removeIf(s -> s.getId() == id); 

    } 

} 
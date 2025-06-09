package com.phamanth.studentapp;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	private static List<Student> students = new ArrayList<>();
	
	// constructor
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
		for (Student s : students) {
			if (s.getId() == id) {
				s.setName(student.getName());
				s.setAge(student.getAge());
				s.setMajor(student.getMajor());
				return s;
			}
		}
		return null; // doesn't exist
	}
	
	public void delete(int id) {
		students.removeIf(s -> s.getId() == id);
	}
}

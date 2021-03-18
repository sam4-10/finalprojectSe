package edu.miu.mumschedule.demo.service;


import edu.miu.mumschedule.demo.domain.Student;

import java.util.List;

public interface StudentService {
public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save(Student theEmployee);
	
	public void deleteById(int theId);
	 Student findByName(String userName);

  //  Student findByEmail(String email);
  public Student addStudent(Student student);

	Student findStudentByEmail(String email);
}

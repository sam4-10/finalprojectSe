package edu.miu.mumschedule.demo.controller;

import java.util.List;

import edu.miu.mumschedule.demo.domain.Student;
import edu.miu.mumschedule.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/students")
public class StudentRegController {
private StudentService studentService;
	
	public StudentRegController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get student from db
		List<Student> students = studentService.findAll();
		
		// add to the spring model
		theModel.addAttribute("students", students);
		
		return "students/list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Student theStudent = new Student();
		
		theModel.addAttribute("student", theStudent);
		
		return "students/student-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int Id,
									Model theModel) {
		
		// get the student from the service
		Student student = studentService.findById(Id);
		
		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("student", student);
		
		// send over to our form
		return "students/student-form";			
	}
	
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		// save the student
		studentService.save(student);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("studentId") int Id) {
		
		// delete the student
		studentService.deleteById(Id);
		
		// redirect to /students/list
		return "redirect:/students/list";
		
	}
}

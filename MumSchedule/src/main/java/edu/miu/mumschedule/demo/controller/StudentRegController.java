package edu.miu.mumschedule.demo.controller;

import java.util.*;

import edu.miu.mumschedule.demo.domain.*;
import edu.miu.mumschedule.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/students")
public class StudentRegController {
	private UserService userService;
private StudentService studentService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private BlockServiceInterface blockService;
	@Autowired
	CredentialService credentialService;
	
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
		User user = new User();
	//	User email = userService.findUserByEmail("");
		theModel.addAttribute("user",user);
		
		theModel.addAttribute("student", theStudent);

//		if (email.equals(user.getEmail())) {
//
//
//		}
		
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

//	@GetMapping("/studentpage")
//	public String studentList(Model model){
//		List<Student> students = studentService.findAll();
//		model.addAttribute("students",students );
//		return "students/studentpage1";
//	}
@GetMapping("/studentpage")
public String studentpage(Model model){
//        List<Faculty> faculties = facultyService.findAll();
      //  model.addAttribute("student1",faculties );

	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String username = " ";
	Collection<? extends GrantedAuthority> authority = new ArrayList<>();
	if (principal instanceof UserDetails) {
		username = ((UserDetails)principal).getUsername();
		authority = ((UserDetails)principal).getAuthorities();
	} else {
		username = principal.toString();
	}
	System.out.println("username........" + username);
	System.out.println("authority........" + Arrays.toString(authority.toArray()));

//	Student student = studentService.findByName();
	return "students/studentpage1";
}

	@GetMapping("/courseList")
	public String listCourse(Model model){
		List<Course> courses = courseService.findAll();
		model.addAttribute("courses1",courses);
		return "students/list-courses2";
	}
	@GetMapping("/blockList")
	public String blockList(Model model){
		List<Block> blocks = blockService.findAll();
		model.addAttribute("blocks1",blocks );
		return "block/list-courses-view";
	}

	@GetMapping("/showFormForAdd1")
	public String showFormForAddview(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("student1", theStudent);

		return "students/student-form-view";
	}
	@GetMapping("/list-view")
	public String listCourse1(Model model) {
		List<Block> blocks = blockService.findAll();

		model.addAttribute("blocks1", blocks);
		return "block/list-courses-view";
	}

	@PostMapping("/save2")
	public String saveStudent1(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
		System.out.println("student............" + student);
		// save the student
		studentService.save(student);

		// use a redirect to prevent duplicate submissions
	//	"redirect:/accounts/{id}";
		redirectAttributes.addFlashAttribute("student",student);
		return "redirect:/students/studentpage";
	}

	@GetMapping("/listView")
	public String listEmployees1(Model theModel) {

     List<Student> students = studentService.findAll();
		// add to the spring model
		theModel.addAttribute("students1", students);

		return "students/list-students-view";
	}
	@GetMapping("/showFormForUpdate1")
	public String showFormForUpdate1(@RequestParam("studentId") int Id,
									 Model theModel) {

		// get the student from the service
		Student student = studentService.findById(Id);

		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("student1", student);

		// send over to our form
		return "students/student-form-view";
	}
	@GetMapping("/delete1")
	public String delete1(@RequestParam("studentId") int Id) {

		// delete the student
		studentService.deleteById(Id);

		// redirect to /students/list
		return "redirect:/stu/profile";

	}

	@GetMapping("/profile")
	public String seeprofile(Model model) throws Exception {
		Student student = getLoggedStudent();
		model.addAttribute("student", student);
		// List<String> specializations = Arrays.asList("DATA SCIENCE", "WEB APPLICATIONS", "SOFTWARE DESIGN");
		// model.addAttribute("specializations", specializations);
		return "students/profileUpdate";
	}
	public Student getLoggedStudent() throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		Student student = studentService.findByName(userName);
		return student;
	}

	@GetMapping("/courses")
	public String displayCourses(Model model) throws Exception {
		Student student = getLoggedStudent();
		Set<Course> courses=student.getCourseList();
		model.addAttribute("courses",courses);
		return "students/manageCourses";
	}
}

package edu.miu.mumschedule.demo.controller;




import edu.miu.mumschedule.demo.domain.*;
import edu.miu.mumschedule.demo.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private BlockServiceInterface blockService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private EntryService entryService;



    @GetMapping("/adminpage")
    public String Adminpage(Model model){
//        List<Faculty> faculties = facultyService.findAll();
//        model.addAttribute("faculties",faculties );
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
        return "admin/adminpage";
    }

    @GetMapping("/student")
    public String studentList(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students );
        return "admin/list-students";
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

        return "admin/student-form";
    }
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {

        // save the student
        studentService.save(student);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int Id) {

        // delete the student
        studentService.deleteById(Id);

        // redirect to /students/list
        return "redirect:/admin/student";

    }

    @GetMapping("/blockList")
    public String blockList(Model model){
        List<Block> blocks = blockService.findAll();
        model.addAttribute("blocks",blocks );
        return "block/list-blocks";
    }
    @GetMapping("/manageSchedule")
    public String manageSchedule( Model model){
        List<Entry> entryList=entryService.findAll();
        List<String> entryMonth = new ArrayList<String>();
        List<Block> blockList=new ArrayList<>();
        for(int i=0; i<entryList.size(); i++) {
            //entryMonth.add(entryList.get(i).getMonth().toString());
        }
        for(int i=0; i<entryList.size(); i++) {
           // blockList.addAll(entryList.get(i).getBlockList());
        }
        //  List<String> blockNames=blockList.stream().map(Block::getBlockName).collect(Collectors.toList());
        model.addAttribute("entryMonth",entryMonth);
        model.addAttribute("blockList",blockList);
        return "schedule/manageSchedule";
    }
    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get student from db
        List<Student> students = studentService.findAll();

        // add to the spring model
        theModel.addAttribute("students", students);

        return "admin/list-students";
    }

    @GetMapping("/courseList")
    public String listCourse(Model model){
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses",courses);
        return "students/list-courses";
    }
    @GetMapping("/facultyList")
    public String facultyList(Model model){
        List<Faculty> faculties = facultyService.findAll();
        model.addAttribute("faculties",faculties );
        return "admin/addsucess";
    }


    @RequestMapping("/deleteFaculty")
    public String deleteFaculty(@RequestParam("facultyID") Long id) {

        facultyService.deleteById(id);


        return "redirect:/admin/facultyList";

    }
}

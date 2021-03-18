package edu.miu.mumschedule.demo.controller;


import edu.miu.mumschedule.demo.domain.Course;
import edu.miu.mumschedule.demo.domain.Faculty;
import edu.miu.mumschedule.demo.domain.Student;
import edu.miu.mumschedule.demo.domain.User;
import edu.miu.mumschedule.demo.service.CourseService;
import edu.miu.mumschedule.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    CourseService courseService;

    @Autowired
    FacultyService facultyService;

    @GetMapping("/")
    public String assignFaculty(@ModelAttribute("faculty") Faculty faculty, Model model) {
        List<Faculty> faculties1 = facultyService.findAll();
        model.addAttribute("faculty", faculties1);

        return "/Faculty/addsucess";

    }
    @GetMapping("/loggedFaculty")//instead of ("/)
    public String loggedFacultyForm( Model model) {
        Faculty faculty=getLoggedInFaculty();
        //List<Faculty> faculties1 = facultyService.findAll();
        model.addAttribute("faculty", faculty);

        return "/Faculty/profileUpdate";

    }

    @RequestMapping("/assignFaculty")
    public String addFaculty(@ModelAttribute("faculty") Faculty faculty, Model model) {

        model.addAttribute("faculty", faculty);
        return "/Faculty/assign";
    }
    @PostMapping("/savefaculty")
    public String saveLoggedFaculty(@ModelAttribute("faculty") Faculty faculty, RedirectAttributes redirectAttributes) {
      //  Faculty faculty=getLoggedInFaculty();
        facultyService.save(faculty);
        redirectAttributes.addFlashAttribute("faculty",faculty);
        return "redirect:/faculty/facultypage";
    }
    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("faculty") Faculty faculty) {
        facultyService.save(faculty);
        return "redirect:/faculty/";
    }
//    @GetMapping("/showFormForUpdate1")
//    public String showFormForUpdate1(@RequestParam("studentId") int Id,
//                                     Model theModel) {
//
//        // get the student from the service
//        Student student = studentService.findById(Id);
//
//        // set student as a model attribute to pre-populate the form
//        theModel.addAttribute("student1", student);
//
//        // send over to our form
//        return "students/student-form-view";
//    }
    @GetMapping("/updateProfile")
    public String updateprofile(@RequestParam("facultyId") long Id ,Model model) {
        Faculty faculty = facultyService.findById(Id);
      //  Faculty faculty = getLoggedInFaculty();
        model.addAttribute("faculty", faculty);
        return "/faculty/assignLogged";
    }
    @GetMapping("/update")
    public String update(@RequestParam("facultyID") Long Id, Model model) {
        Faculty faculty = facultyService.findById(Id);
        model.addAttribute("faculty", faculty);
        return "/faculty/assign";
    }

    @RequestMapping("/deleteFaculty")
    public String deleteFaculty(@RequestParam("facultyID") Long id) {
        facultyService.deleteById(id);
        return "redirect:/faculty/";

    }

    @GetMapping("/facultypage")
    public String facultypage(Model model) {
//        List<Faculty> faculties = facultyService.findAll();
//        model.addAttribute("faculties",faculties );
        return "faculty/facultypage";
    }

    @GetMapping("/profile")
    public String seeprofile(Model model) throws Exception {
        Faculty faculty = getLoggedInFaculty();
        model.addAttribute("faculty", faculty);
        // List<String> specializations = Arrays.asList("DATA SCIENCE", "WEB APPLICATIONS", "SOFTWARE DESIGN");
        // model.addAttribute("specializations", specializations);
        return "faculty/profileUpdate";
    }
    @GetMapping("/msg")
    public String sendMsg(Model model) throws Exception {
       model.addAttribute("msg","Your request has been sent");
        return "faculty/msg";
    }

    @GetMapping("/courses")
    public String displayCourses(Model model){
        Faculty faculty = getLoggedInFaculty();
        Set<Course> courses=faculty.getCourseList();
        //all courses
        List<Course> allCourses=courseService.findAll();
        model.addAttribute("courses",courses);
        model.addAttribute("allCourses",allCourses);
        return "faculty/manageCourses";
    }
    @GetMapping("/prefferedcourses")
    public String displayPrefferedCourses(Model model){
        return "faculty/chosencourse";
    }

    public Faculty getLoggedInFaculty() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        Faculty faculty = facultyService.findByName(userName);
        return faculty;
    }
}

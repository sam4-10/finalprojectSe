package edu.miu.mumschedule.demo.controller;


import edu.miu.mumschedule.demo.domain.Course;
import edu.miu.mumschedule.demo.domain.Faculty;
import edu.miu.mumschedule.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @GetMapping("/")
    public String assignFaculty(@ModelAttribute("faculty") Faculty faculty, Model model) {

        List<Faculty> faculties1 = facultyService.findAll();
        // System.out.println("....................." +Arrays.toString(faculties1.toArray()));

        model.addAttribute("faculty", faculties1);


        return "/Faculty/addsucess";

    }

    @RequestMapping("/assignFaculty")
    public String addFaculty(@ModelAttribute("faculty") Faculty faculty, Model model) {

        model.addAttribute("faculty", faculty);
        return "/Faculty/assign";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("faculty") Faculty faculty) {
        facultyService.save(faculty);
        return "redirect:/faculty/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("facultyID") Long Id, Model model) {
        Faculty faculty = facultyService.findById(Id);
        model.addAttribute("faculty", faculty);
        return "/Faculty/assign";
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
    public String seeprofile(Model model) {
        Faculty faculty = getLoggedInFaculty();
        model.addAttribute("faculty", faculty);
        // List<String> specializations = Arrays.asList("DATA SCIENCE", "WEB APPLICATIONS", "SOFTWARE DESIGN");
        // model.addAttribute("specializations", specializations);
        return "faculty/profileUpdate";
    }

    @GetMapping("/courses")
    public String displayCourses(Model model) {
        Faculty faculty = getLoggedInFaculty();
        Set<Course> courses=faculty.getCourseList();
        model.addAttribute("courses",courses);
        return "faculty/manageCourses";
    }

    public Faculty getLoggedInFaculty() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String userName = auth.getName();
//        return facultyService.findByUserName(userName);
        Faculty faculty = facultyService.findById(7L);
        return faculty;
    }

}

package edu.miu.mumschedule.demo.controller;



import edu.miu.mumschedule.demo.domain.*;
import edu.miu.mumschedule.demo.service.BlockServiceInterface;
import edu.miu.mumschedule.demo.service.CourseService;
import edu.miu.mumschedule.demo.service.EntryService;
import edu.miu.mumschedule.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/block")
public class BlockRegController {
//
//    @Autowired
//    BlockServiceInterface blockServiceInterface;

    @Autowired
    EntryService entryService;
    @Autowired
    CourseService courseService;
    @Autowired
    BlockServiceInterface blockServiceInterface;
    @Autowired
    SectionService sectionService;


    @GetMapping("/list")
    public String listCourse(Model model) {
        List<Block> blocks = blockServiceInterface.findAll();

        model.addAttribute("blocks", blocks);
        return "block/list-courses";
    }

    @RequestMapping("/showFormForAdd")
    public String showForm(Model model) {
        Block block = new Block();
        List<Section> sections = sectionService.findAll();
        List<Course> courses = courseService.findAll();
        List<Faculty> faculties = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        //    block.setCourses(courses);

//        courses.stream().map(course -> faculties.addAll(course.getFacultyList()));
//        courses.stream().map(course -> studentList.addAll(course.getStudentList()));
//        faculties.stream().forEach(fa -> System.out.println(".............." + fa.getFacultyName()));
//        studentList.stream().forEach(student -> System.out.println("................." + student.getStudentID()));
        //  System.out.println("_____________"+ faculties.get(0).getEmail());
        model.addAttribute("students", studentList);
        model.addAttribute("faculties", faculties);
        model.addAttribute("courses", courses);
        model.addAttribute("sections",sections);
        model.addAttribute("block", block);
        return "block/course-form";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("block") Block block) {

        blockServiceInterface.save(block);
        return "redirect:/block/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("blockid") Long Id) {
        blockServiceInterface.deleteById(Id);
        return "redirect:/courses/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("blockid") Long Id, Model model) {
       Block block = blockServiceInterface.findById(Id);
        List<Section> sections = sectionService.findAll();
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("sections",sections);
       model.addAttribute("block",block);
        return "block/course-form";
    }

    @GetMapping("/courses/{blockid}")
    public String getCourses(Model model, @PathVariable Long blockid) {
        Block block = blockServiceInterface.findById(blockid);
        System.out.println("block.................." + block);
        model.addAttribute("block", block);
//        model.addAttribute("faculties", facultyService.findById(courseid));
        return "block/course-list";
    }


    @GetMapping("/sections/{blockid}")
    public String getSections(Model model, @PathVariable Long blockid) {
        Block block = blockServiceInterface.findById(blockid);
        System.out.println("block.................." + block);
        model.addAttribute("block", block);
//        model.addAttribute("faculties", facultyService.findById(courseid));
        return "block/section-list";
    }


}



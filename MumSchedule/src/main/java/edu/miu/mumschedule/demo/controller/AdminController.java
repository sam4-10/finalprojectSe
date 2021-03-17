package edu.miu.mumschedule.demo.controller;




import edu.miu.mumschedule.demo.domain.*;
import edu.miu.mumschedule.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

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

    @GetMapping("/adminpage")
    public String Adminpage(Model model){
//        List<Faculty> faculties = facultyService.findAll();
//        model.addAttribute("faculties",faculties );
        return "admin/adminpage";
    }

    @GetMapping("/student")
    public String studentList(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students );
        return "admin/list-students";
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
    public String manageSchedule(Model model){
        Entry entry=new Entry();
        Set<Block> blocks = entry.getBlockList();
        model.addAttribute("entry",entry);
        model.addAttribute("blocks",blocks );
        return "schedule/manageSchedule";
    }
}

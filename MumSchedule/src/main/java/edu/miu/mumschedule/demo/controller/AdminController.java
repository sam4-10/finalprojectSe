package edu.miu.mumschedule.demo.controller;




import edu.miu.mumschedule.demo.domain.*;
import edu.miu.mumschedule.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
        return "faculty/addsucess";
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
            entryMonth.add(entryList.get(i).getMonth().toString());
        }
        for(int i=0; i<entryList.size(); i++) {
            blockList.addAll(entryList.get(i).getBlockList());
        }
        //  List<String> blockNames=blockList.stream().map(Block::getBlockName).collect(Collectors.toList());
        model.addAttribute("entryMonth",entryMonth);
        model.addAttribute("blockList",blockList);
        return "schedule/manageSchedule";
    }
}

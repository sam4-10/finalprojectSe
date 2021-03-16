package edu.miu.mumschedule.demo.scheduleBuilderSubSystem;


import edu.miu.mumschedule.demo.domain.Block;
import edu.miu.mumschedule.demo.domain.Entry;
import edu.miu.mumschedule.demo.service.BlockServiceInterface;
import edu.miu.mumschedule.demo.service.CourseService;
import edu.miu.mumschedule.demo.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/schedule")
public class ScheduleBuilderController {

    @Autowired
    EntryService entryService;
    @Autowired
    BlockServiceInterface blockServiceInterface;
    @Autowired
    CourseService courseService;

    @GetMapping("list")
    public String listEntry(Model model){
        List<Entry> entries = entryService.findAll();
        model.addAttribute("entries",entries);
        return "schedule/schedule-list-entries";
    }

    @RequestMapping("/AddEntry")
    public String showFormEntry(Model model){
        Entry theEntry = new Entry();
        List<Block> blocks = blockServiceInterface.findAll();

        model.addAttribute("blocks", blocks);
        model.addAttribute("entry",theEntry);
        return "entry/entry-form";
    }

    @PostMapping("/save")
    public String saveEntry(@ModelAttribute("entry") Entry entry){
        entryService.save(entry);
        return "redirect:/entries/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("entryId") int Id){
        entryService.deleteById(Id);
        return "redirect:/entries/list";
    }
    @GetMapping("/update")
    public String update(@RequestParam("entryId") int Id, Model model){
        Entry entry= entryService.findById(Id);
        model.addAttribute("entry",entry);
        return "entry/entry-form";
    }
    @GetMapping("/blocks")
    public String getCourses(Model model, @RequestParam("entryId") Long entryid) {
        Entry entry = entryService.findById(entryid);
        System.out.println("entry.................." + entry);
        model.addAttribute("entry", entry);
//        model.addAttribute("faculties", facultyService.findById(courseid));
        return "entry/block-list";
    }


}

package edu.miu.mumschedule.demo.controller;

import java.util.List;


import edu.miu.mumschedule.demo.domain.Course;
import edu.miu.mumschedule.demo.domain.Section;
import edu.miu.mumschedule.demo.service.CourseService;
import edu.miu.mumschedule.demo.service.FacultyService;
import edu.miu.mumschedule.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/sections")
public class SectionController {
	private SectionService sectionService;
	@Autowired
	CourseService courseService;
	@Autowired
	FacultyService facultyService;

	public SectionController(SectionService sectionService) {
		super();
		this.sectionService = sectionService;
	}

	@GetMapping("/list")
	public String listSections(Model theModel) {

		// get student from db
		List<Section> sections = sectionService.findAll();

		// add to the spring model
		theModel.addAttribute("sections", sections);

		return "sections/list-sections";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Section section = new Section();
        List<Course> courses = courseService.findAll();
        theModel.addAttribute("courses",courses);
		theModel.addAttribute("section", section);

		return "sections/section-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("sectionId") int Id, Model theModel) {

		// get the student from the service
		Section section = sectionService.findById(Id);
		List<Course> courses = courseService.findAll();
		theModel.addAttribute("courses",courses);
		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("section", section);

		// send over to our form
		return "sections/section-form";
	}

	@GetMapping("/courses")
	public String getCourses(@RequestParam("sectionId") int Id, Model model){
		Section section = sectionService.findById(Id);
		System.out.println("section**********************************************.................." + section);
		model.addAttribute("section",section);
//        model.addAttribute("faculties", facultyService.findById(courseid));
		return "sections/list-courses";
	}

	@PostMapping("/save")
	public String saveSection(@ModelAttribute("section") Section section) {

		// save the section
		sectionService.save(section);

		// use a redirect to prevent duplicate submissions
		return "redirect:/sections/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("sectionId") int Id) {

		// delete the student
		sectionService.deleteById(Id);

		// redirect to /students/list
		return "redirect:/sections/list";

	}
}

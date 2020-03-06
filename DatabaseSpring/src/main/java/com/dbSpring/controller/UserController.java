package com.dbSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dbSpring.model.StudentModel;
import com.dbSpring.service.ServiceRepository;

@Controller
public class UserController {
	@Autowired
	private ServiceRepository serviceRepository;
	
	@RequestMapping(value ="/add", method  = RequestMethod.GET)
	public String getAddStudent() {
		return "add";
	}
	
	@RequestMapping(value = "/submit", method  = RequestMethod.POST)
	public String addStudent(@ModelAttribute StudentModel studentModel) {
		serviceRepository.save(studentModel);
		return "redirect:/display";
	}
	
	@GetMapping("/display")
	public String listStudents(Model model) {
		model.addAttribute("list", serviceRepository.findAll());
		return "display";
	}

	@GetMapping({"/{name}","/hello{name}"})
	public ModelAndView getHello(@PathVariable String name) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		if(name.equals(""))name ="World";
		mav.addObject("name", name);
		return mav;
	}
	
	@RequestMapping(value = "/delete", method  = RequestMethod.POST)
	public String deleteStudent(@RequestParam(value="id",required =true) String id) {
		int s_id = Integer.parseInt(id);
		serviceRepository.deleteById(s_id);
		return "redirect:/display";
	}
	
}

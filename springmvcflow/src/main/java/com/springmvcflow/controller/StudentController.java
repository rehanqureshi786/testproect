package com.springmvcflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcflow.dao.StudentDaoImpl;
import com.springmvcflow.model.StudentModel;

@Controller
public class StudentController {

	StudentDaoImpl dao=new StudentDaoImpl();
	
	@RequestMapping(value = "/student",method = RequestMethod.GET)
	public String display()
	{
		return "index";
	}
	
	@RequestMapping(value="/std")
	public String studentFront(Model model)
	{
		model.addAttribute("studentModel",new StudentModel());
		return "student";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("student")StudentModel student)
	{
		System.out.println("I am in Save");
		
	dao.addStudent(student);
	System.out.println("Data added Successfully!!!!");
	return new ModelAndView("index","message","Data Added Success!!!");
	}
}

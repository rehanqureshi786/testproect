package com.springmvcflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcflow.dao.UserDaoImpl;
import com.springmvcflow.model.User;
import com.springmvcflow.service.UserServiceImpl;

@Controller
public class UserController {
	
@Autowired
private UserServiceImpl userService;
@Autowired
private User user;
@Autowired
private UserDaoImpl userDao;

@RequestMapping(value="/")
public String start()
{
	return "index";
}

@RequestMapping(value = "/users" , method= RequestMethod.GET)
public String userStart(Model model)
{
	model.addAttribute("userCommand",user);
	return "Users";
}

@RequestMapping(value="userProcess",method=RequestMethod.POST)
public ModelAndView userProcess(@ModelAttribute("userCommand") User user)
{
	System.out.println("Fname: "+user.getFname());
	boolean i=userService.addUser(user);
	String errorMessage=userDao.getErrorMessage();
	ModelAndView mav=new ModelAndView();
	if(i==true)
	{
		mav.setViewName("index");
		mav.addObject("message","!!!User Registration Data Added Successfully!!!");	
	}
	else
	{
		mav.setViewName("Users");
		mav.addObject("message","!!!User Registration Data Not Added Successfully!!!"+errorMessage);
	}
	return mav;
}

@RequestMapping(value="showUser" ,method = RequestMethod.GET)
public ModelAndView showUsers()
{	
	List<User> list=userService.getUser();
	ModelAndView mav=new ModelAndView("showUser");
	mav.addObject("list",list);
	return mav;
}
}

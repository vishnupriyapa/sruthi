package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
	@Autowired
	ServiceInterface si;
	@RequestMapping("/hi")
	public ModelAndView display(@ModelAttribute("user") User user)
	{
		return new ModelAndView("hello");
	}
	@RequestMapping("/save")
	public ModelAndView saves(@ModelAttribute("user") User user)
	{
		si.save(user);
		return new ModelAndView("redirect:/list");

		
	}
	@RequestMapping("/list")
	public ModelAndView listuser(@ModelAttribute("user") User user)
	{
		List<User>ls=si.list();
		return new ModelAndView("display","listing",ls);

		
	}
	@RequestMapping("/edit")
	public ModelAndView edituser(@ModelAttribute("user") User user,HttpServletRequest req)
	{List<User>ls=si.list();
		int eid=Integer.parseInt(req.getParameter("id"));
		User us=si.fetchById(eid);
		ModelAndView m=new ModelAndView("display","listing",ls);
		m.addObject("editing",us);
		return m;

		
	}
	@RequestMapping("/delete")
	public ModelAndView deleteuser(@ModelAttribute("user") User user,HttpServletRequest req)
	{int did=Integer.parseInt(req.getParameter("id"));
		si.delete(did);
		return new ModelAndView("redirect:/list");

		
	}
	@RequestMapping("/update")
	public ModelAndView updateuser(@ModelAttribute("user") User user,HttpServletRequest req)
	{
		si.update(user);
		return new ModelAndView("redirect:/list");

		
	}
	
	
}

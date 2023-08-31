package com.ignek.MywebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("home")
	public ModelAndView home(Student s) {
		/*
		 * HttpSession session = req.getSession(); String name =
		 * req.getParameter("name");
		 */
		ModelAndView mv = new ModelAndView();
		System.out.println("Hello " +s);
//		session.setAttribute("name", myname);
		mv.addObject("obj",s);
		mv.setViewName("home");
		return mv;
	}
}

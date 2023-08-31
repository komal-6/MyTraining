package com.ignek;

import jakarta.servlet.http.*;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ignek.service.AddService;

@Controller
public class AddController {
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("t1") int i,@RequestParam("t2") int j){
		  //int i = Integer.parseInt(request.getParameter("t1"));
		  //int j = Integer.parseInt(request.getParameter("t2"));
		  
		  //int k = i + j;
		  AddService as = new AddService();
		  int k = as.add(i, j);
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("Display");
		  mv.addObject("result", k);
		  return mv;
	   }
}

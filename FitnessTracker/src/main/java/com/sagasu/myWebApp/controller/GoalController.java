package com.sagasu.myWebApp.controller;

import javax.naming.spi.DirStateFactory.Result;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sagasu.myWebApp.model.Goal;

@Controller
@SessionAttributes("goal")
public class GoalController {

	// This is executed when a page loads, when you enter it in browser, because it is get
	@RequestMapping(value = "addGoal", method = RequestMethod.GET)
	public String addGoal(Model model){
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute("goal", goal);
		
		return "addGoal";
	}
	
	@RequestMapping(value = "addGoal", method = RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result){
		
		System.out.println("has errors" + result.hasErrors());
		
		System.out.println("update Gaol" + goal.getMinutes());
		
		if(result.hasErrors()){
			return "addGoal";
		}
		
		//return "redirect:addMinutes.html";
		return "redirect:index.jsp";
	}
}


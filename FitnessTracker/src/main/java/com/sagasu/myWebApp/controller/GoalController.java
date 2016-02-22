package com.sagasu.myWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String updateGoal(@ModelAttribute("goal") Goal goal){
		
		System.out.println("update Gaol" + goal.getMinutes());
		
		return "redirect:addMinutes.html";
	}
}


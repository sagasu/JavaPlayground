package com.sagasu.myWebApp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sagasu.myWebApp.model.Activity;
import com.sagasu.myWebApp.model.Exercise;
import com.sagasu.myWebApp.model.Goal;
import com.sagasu.myWebApp.service.ExerciseService;

@Controller
public class MinutesController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@RequestMapping(value = "/addMinutes", method=RequestMethod.GET)
	public String getMinutes(@ModelAttribute ("exercise") Exercise exercise) {
		
		System.out.println("exercise: " + exercise.getMinutes());
		
		return "addMinutes";
	}
	
	@RequestMapping(value = "/addMinutes", method=RequestMethod.POST)
	public String addMinutes(@Valid @ModelAttribute ("exercise") Exercise exercise, HttpSession session, BindingResult result) {
		
		System.out.println("exercise: " + exercise.getMinutes());
		if(result.hasErrors()){
			return "addMinutes";
		}else{
			Goal goal = (Goal)session.getAttribute("goal");
			
			exercise.setGoal(goal);
			exerciseService.save(exercise);
		}
		
		return "addMinutes";
	}
	
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities(){
		return exerciseService.findAllActivities();
		
	}
	
	@RequestMapping(value = "/addMinutesForward")
	public String addMinutesForward(@ModelAttribute ("exercise") Exercise exercise) {
		
		System.out.println("exercise addMinutesForward: " + exercise.getMinutes());
		
		// needs to have html, unless we change web.xml servlet from *.html to /
		// Request is kept, so value of exercise will be passed
		return "forward:addMoreMinutes.html";
	}
	
	@RequestMapping(value = "/addMinutesRedirect")
	public String addMinutesRedirect(@ModelAttribute ("exercise") Exercise exercise) {
		
		System.out.println("exercise addMinutesRedirect: " + exercise.getMinutes());
		
		// Request is not kept, so value of exercise will be reset to default (0)
		return "redirect:addMoreMinutes.html";
	}
	
	@RequestMapping(value = "/addMoreMinutes")
	public String addMoreMinutes(@ModelAttribute ("exercise") Exercise exercise) {
		
		System.out.println("exercise addMoreMinutes: " + exercise.getMinutes());
		
		return "addMinutes";
	}

}

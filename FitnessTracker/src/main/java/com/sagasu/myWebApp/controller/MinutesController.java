package com.sagasu.myWebApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sagasu.myWebApp.model.Activity;
import com.sagasu.myWebApp.model.Exercise;

@Controller
public class MinutesController {
	
	@RequestMapping(value = "/addMinutes")
	public String addMinutes(@ModelAttribute ("exercise") Exercise exercise) {
		
		System.out.println("exercise: " + exercise.getMinutes());
		
		return "addMinutes";
	}
	
	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities(){
		List<Activity> activities = new ArrayList<Activity>();
		
		
		
		
		Activity run = new Activity();
		run.setDesc("Run");
		activities.add(run);
		
		String desc = run.getDesc();
		
		Activity bike = new Activity();
		bike.setDesc("Bike");
		activities.add(bike);
		
		Activity swim = new Activity();
		swim.setDesc("Swim");
		activities.add(swim);
		
		return activities;
		
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

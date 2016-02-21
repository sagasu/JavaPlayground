package com.sagasu.myWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sagasu.myWebApp.model.Exercise;

@Controller
public class MinutesController {
	
	@RequestMapping(value = "/addMinutes")
	public String addMinutes(@ModelAttribute ("exercise") Exercise exercise) {
		
		System.out.println("exercise: " + exercise.getMinutes());
		
		return "addMinutes";
	}
	
	@RequestMapping(value = "/addMinutes2")
	public String addMinutes2(@ModelAttribute ("exercise") Exercise exercise) {
		
		System.out.println("exercise addMinutes2: " + exercise.getMinutes());
		
		// needs to have html, unless we change web.xml servlet from *.html to /
		return "forward:addMoreMinutes.html";
	}
	
	@RequestMapping(value = "/addMoreMinutes")
	public String addMoreMinutes(@ModelAttribute ("exercise") Exercise exercise) {
		
		System.out.println("exercise addMoreMinutes: " + exercise.getMinutes());
		
		return "addMinutes";
	}

}

package com.sagasu.myWebApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagasu.myWebApp.model.Activity;
import com.sagasu.myWebApp.model.Exercise;
import com.sagasu.myWebApp.repository.ExerciseRepository;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;
	
	public List<Activity> findAllActivities(){
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
	//always start transactions on service tier
	@Transactional
	public Exercise save(Exercise exercise) {
		exercise = exerciseRepository.save(exercise);
		return exercise;
	}
}

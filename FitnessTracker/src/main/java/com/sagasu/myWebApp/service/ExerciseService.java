package com.sagasu.myWebApp.service;

import java.util.List;

import com.sagasu.myWebApp.model.Activity;
import com.sagasu.myWebApp.model.Exercise;

public interface ExerciseService {

	List<Activity> findAllActivities();

	Exercise save(Exercise exercise);
	

}
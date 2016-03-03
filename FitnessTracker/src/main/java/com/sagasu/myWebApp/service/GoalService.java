package com.sagasu.myWebApp.service;

import java.util.List;

import com.sagasu.myWebApp.model.Goal;

public interface GoalService {
	Goal save(Goal goal);

	List<Goal> findAllGoals();
}

package com.sagasu.myWebApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagasu.myWebApp.model.Goal;
import com.sagasu.myWebApp.repository.GoalRepository;

@Service("goalService")
public class GoalServiceImpl implements GoalService {

	@Autowired
	private GoalRepository goalRepository;
	
	public Goal save(Goal goal) {
		return goalRepository.save(goal);
	}

}

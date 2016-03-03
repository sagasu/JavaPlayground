package com.sagasu.myWebApp.repository;

import java.util.List;

import com.sagasu.myWebApp.model.Goal;

public interface GoalRepository {
	Goal save(Goal goal);

	List<Goal> loadAll();
}

package com.sagasu.myWebApp.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sagasu.myWebApp.model.Exercise;

@Repository("exerciseRepository")
public class ExerciseRepositoryImpl implements ExerciseRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Exercise save(Exercise exercise) {
		em.persist(exercise);
		em.flush();
		
		return exercise;
	}
}

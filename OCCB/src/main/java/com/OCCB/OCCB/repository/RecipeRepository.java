	package com.OCCB.OCCB.repository;
	import org.springframework.data.jpa.repository.JpaRepository;
	import com.OCCB.OCCB.model.Recipe;
	public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
		
	}
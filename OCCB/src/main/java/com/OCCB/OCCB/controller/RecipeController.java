
package com.OCCB.OCCB.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OCCB.OCCB.model.Recipe;
import com.OCCB.OCCB.repository.RecipeRepository;

   @RestController
   @CrossOrigin(origins = "http://localhost:3000")
   public class RecipeController {
	   
	   @Autowired 
	   RecipeRepository recipeRepository;
	   
	   @PostMapping("/api/recipe")
	   public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe ) {
		   
		   Recipe newRecipe = recipeRepository.save(recipe);
		   return new ResponseEntity<Recipe>(newRecipe, HttpStatus.OK);
		   }
   }
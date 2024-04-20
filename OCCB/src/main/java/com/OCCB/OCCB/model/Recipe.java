
 package com.OCCB.OCCB.model;
 
 import java.util.Date;

import jakarta.persistence.Column; import jakarta.persistence.Entity; import
jakarta.persistence.GeneratedValue; import jakarta.persistence.Id;

@Entity public class Recipe { 
	private @Id @GeneratedValue
	Integer recipeID;
	Integer user_userID;
	String title;
	String instruction;
	String ingredients;
	@Column
	(name="date_published ",nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") 
	private Date datePublished;
	public Integer getRecipeID() {
		return recipeID;
		}
	public void setRecipeID(Integer recipeID) {
		this.recipeID = recipeID;
		}
	public Integer getUser_userID() {
		return user_userID;
		}
	public void setUser_userID(Integer user_userID) {
		this.user_userID = user_userID;
		}
	public String getInstruction() {
		return instruction;
		}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
		}
	public String getTitle() {
		return title;
		}
	public void setTitle(String title) {
		this.title = title;
		}
	public String getIngredients() {
		return ingredients;
		}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
		}
	public Date getDatePublished() {
		return datePublished;
		}
	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
		}
}
package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Component
@Entity
@Table(name = "food", schema = "fitbuddy")
public class Food implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int food_id;
	
	@Column
	private String name;
	
	@Column
	private String url;
	
	@Column
	private int calories;
	
	@Column
	private int carbs;
	
	@Column
	private int protein;
	
	@Column
	private int fat;
	
	@JsonBackReference("meal-food")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "meal")
	private Meal meal;
	
	public Food() {
		super();
	}

	public Food(int food_id, String name, String url, int calories, int carbs, int protein, int fat, Meal meal) {
		super();
		this.food_id = food_id;
		this.name = name;
		this.url = url;
		this.calories = calories;
		this.carbs = carbs;
		this.protein = protein;
		this.fat = fat;
		this.meal = meal;
	}

	public int getId() {
		return food_id;
	}

	public void setId(int food_id) {
		this.food_id = food_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getCarbs() {
		return carbs;
	}

	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}
	
	public Meal getMeal() {
		return meal;
	}
	
	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calories;
		result = prime * result + carbs;
		result = prime * result + fat;
		result = prime * result + food_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + protein;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (calories != other.calories)
			return false;
		if (carbs != other.carbs)
			return false;
		if (fat != other.fat)
			return false;
		if (food_id != other.food_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (protein != other.protein)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Food [food_id=" + food_id + ", name=" + name + ", url=" + url + ", calories=" + calories + ", carbs="
				+ carbs + ", protein=" + protein + ", fat=" + fat + "]";
	}
}

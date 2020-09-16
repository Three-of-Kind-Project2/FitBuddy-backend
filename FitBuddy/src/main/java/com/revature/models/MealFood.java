package com.revature.models;

public class MealFood {

	private int meal_id;
	private int food_id;
	
	public MealFood() {
		super();
	}

	public MealFood(int meal_id, int food_id) {
		super();
		this.meal_id = meal_id;
		this.food_id = food_id;
	}

	public int getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + food_id;
		result = prime * result + meal_id;
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
		MealFood other = (MealFood) obj;
		if (food_id != other.food_id)
			return false;
		if (meal_id != other.meal_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MealFood [meal_id=" + meal_id + ", food_id=" + food_id + "]";
	}
	
}

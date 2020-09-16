package com.revature.models;

public class Food {

	private int id;
	private String name;
	private String url;
	private int calories;
	private int carbs;
	private int protein;
	private int fat;
	
	public Food() {
		super();
	}

	public Food(int id, String name, String url, int calories, int carbs, int protein, int fat) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.calories = calories;
		this.carbs = carbs;
		this.protein = protein;
		this.fat = fat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calories;
		result = prime * result + carbs;
		result = prime * result + fat;
		result = prime * result + id;
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
		if (id != other.id)
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
		return "Food [id=" + id + ", name=" + name + ", url=" + url + ", calories=" + calories + ", carbs=" + carbs
				+ ", protein=" + protein + ", fat=" + fat + "]";
	}
	
}

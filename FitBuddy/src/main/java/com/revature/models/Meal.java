package com.revature.models;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Component
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "meal", schema = "fitbuddy")
public class Meal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int meal_id;
	
	@Column
	private LocalDateTime date;
	
	@Column
	private String type;
	
	@JsonManagedReference("meal-user")
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;
	
	@JsonManagedReference("meal-food")
	@OneToMany(mappedBy = "meal", fetch = FetchType.LAZY)
	private Set<Food> foods;
	
	public Meal() {
		super();
	}

	public Meal(int meal_id, LocalDateTime date, String type, User user) {
		super();
		this.meal_id = meal_id;
		this.date = date;
		this.type = type;
		this.user = user;
	}

	public int getId() {
		return meal_id;
	}

	public void setId(int meal_id) {
		this.meal_id = meal_id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((foods == null) ? 0 : foods.hashCode());
		result = prime * result + meal_id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Meal other = (Meal) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (foods == null) {
			if (other.foods != null)
				return false;
		} else if (!foods.equals(other.foods))
			return false;
		if (meal_id != other.meal_id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Meal [meal_id=" + meal_id + ", date=" + date + ", type=" + type + ", user=" + user + ", foods=" + foods + "]";
	}
	
}

package com.reservo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "restaurants")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RestaurantEntity extends BaseEntity {
	
	@Column(length = 70, name="restaurant_name")
	private String restaurantName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "restaurants")
	private List<ReviewEntity> reviews = new ArrayList<ReviewEntity>();
	
	@Column(length = 80, unique = true, nullable = false)
	private String email;
	
//	@Column
//	private int rating;
	
	@Column(nullable = false, name="is_open")
	private boolean isOpen;
	
	@Column(length = 300, nullable = false, name="address")
	private String address;
	
	@OneToOne
	private CityEntity city;
	
	@Column(name="available_seats")
	private int availableSeats;
}

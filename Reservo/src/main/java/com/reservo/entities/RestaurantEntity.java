package com.reservo.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
			orphanRemoval = true, mappedBy = "restaurants")
	private List<ReviewEntity> reviews = new ArrayList<ReviewEntity>();
	
	@Column(length = 80, unique = true, nullable = false)
	private String email;
	
//	@Column
//	private int rating;
	
	@OneToOne
	@JoinColumn(name="owner_id", nullable = false)
	private OwnerEntity owner;
	
	@Column(nullable = false, name="is_open")
	private boolean isOpen;
	
	@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, 
			orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<TransactionEntity> transactions = new HashSet<TransactionEntity>();
	
	@Column(length = 300, nullable = false, name="address")
	private String address;
	
	@OneToOne
	@JoinColumn(name="city_id")
	private CityEntity city;
	
	@Column(name="available_seats")
	private int availableSeats;
	
	// Helper method to add a review
    public void addReview(ReviewEntity review) {
        reviews.add(review);
        review.setRestaurants(this);
    }

    // Helper method to remove a review
    public void removeReview(ReviewEntity review) {
        reviews.remove(review);
        review.setRestaurants(null);
    }

    // Helper method to add a transaction
    public void addTransaction(TransactionEntity transaction) {
        transactions.add(transaction);
        transaction.setRestaurant(this);
    }

    // Helper method to remove a transaction
    public void removeTransaction(TransactionEntity transaction) {
        transactions.remove(transaction);
        transaction.setRestaurant(null);
    }
}

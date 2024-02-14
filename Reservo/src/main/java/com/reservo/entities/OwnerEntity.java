package com.reservo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "owners")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
public class OwnerEntity extends BaseEntity{
	
	@Column(length = 50, name="first_name")
	private String firstName;
	
	@Column(length = 50, name="last_name")
	private String lastName;
	
	@Column(length = 150, unique = true)
	private String email;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@Column(length = 20, nullable = false, name="mobile_no")
	private String mobileNo;
	
	@Column(length = 300, nullable = false, name="address")
	private String address;	
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole role;
	
	@OneToOne(mappedBy = "owner", cascade  = CascadeType.ALL, orphanRemoval = true)
	private RestaurantEntity restaurant;
	
	// Helper method to set the restaurant
    public void setRestaurant(RestaurantEntity restaurant) {
        // Set the restaurant
        this.restaurant = restaurant;
        // Set the owner of the restaurant to this owner
        if (restaurant != null) {
            restaurant.setOwner(this);
        }
    }
    
    // Helper method to remove the restaurant
    public void removeRestaurant() {
        // If the restaurant exists
        if (restaurant != null) {
            // Remove the reference to this owner from the restaurant
            restaurant.setOwner(null);
            // Remove the restaurant from this owner
            this.restaurant = null;
        }
    }
}

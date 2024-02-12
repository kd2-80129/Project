package com.reservo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Booking_Status")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingStatusEntity extends BaseEntity{
   
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserEntity user; 
	
	@OneToOne(cascade = CascadeType.ALL)
	private ReservationEntity reservation;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private RestaurantEntity restaurant;
	
	private BookingStatus status;
}

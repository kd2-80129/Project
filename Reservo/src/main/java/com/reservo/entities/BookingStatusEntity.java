package com.reservo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "booking_status")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookingStatusEntity extends BaseEntity{

	@OneToOne
	@JoinColumn(name="reservation_id")
	private ReservationEntity reservations;
	
	@OneToOne
	@JoinColumn(name="restaurant_id")
	private RestaurantEntity restaurants;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserEntity users;
	
	@Column(length = 100, nullable = false, name = "booking_status")
	private BookingStatus bookingStatus;
	
	
}

package com.reservo.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reservations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReservationEntity extends BaseEntity{
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private RestaurantEntity restaurants;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	@Column(name = "reservation_datetime")
	private LocalDateTime reservationDateTime;
	
	@Column(nullable = false, name="party_size")
	private int partySize;	
}

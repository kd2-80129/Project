package com.reservo.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name  = "Reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationEntity extends BaseEntity{
 
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reservation_id")
	private RestaurantEntity restaurant;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@Column(name="reseravtion_date")
	private LocalDateTime reseravtionDate;
	
	@Column(name="party_size")
	private int partySize;
	

}

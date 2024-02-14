package com.reservo.entities;

import java.time.LocalDateTime;

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
import lombok.ToString;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TransactionEntity extends BaseEntity{

	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private RestaurantEntity restaurant;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	@OneToOne
	@JoinColumn(name="reservation_id")
	private ReservationEntity reservation;
	
	@Column(length = 150, unique = true, name="transacion_time")
	private LocalDateTime transactionTime;
	
	@Column(length = 20, nullable = false, name="payment_status")
	private boolean paymentStatus;
	
	@Column(nullable = false, name="total_amount")
	private double totalAmount;
	

}

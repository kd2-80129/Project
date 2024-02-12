package com.reservo.entities;

import java.time.LocalDateTime;
import java.util.List;

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
@Table(name = "Transactions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionEntity extends BaseEntity{

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="reservation_id")
	private ReservationEntity reservation;
	
	@Column(name="transaction_datetime")
	private LocalDateTime transactionDatetime; 
	
	@Column(name="payment_status")
	private boolean paymentStatus;
	
	@Column(name="total_amount")
	private double totalAmount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="restaurant_id")
	private RestaurantEntity restaurant;
	
	/* do not use join column on the list of entities cuz it is used on
	owning side to specify a column name for the f.k column 
	
	In a One-to-Many/Many-to-One relationship, the owning side is usually defined on the many side of the relationship. It’s usually the side that owns the foreign key.
    The @JoinColumn annotation defines that actual physical mapping on the owning side:
    
    The @JoinColumn annotation helps us specify the column we’ll use for joining an entity association or element collection. On the other hand, the mappedBy attribute 
    is used to define the referencing side (non-owning side) of the relationship
	*/

}

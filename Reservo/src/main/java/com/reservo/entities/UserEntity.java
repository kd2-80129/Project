package com.reservo.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password") // toString excluding password
public class UserEntity extends BaseEntity {
	
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
	
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private List<ReservationEntity> reservations = new ArrayList<ReservationEntity>();
	
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole role;
}

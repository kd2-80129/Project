package com.reservo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CityEntity extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "state_id")
	private StateEntity state;
	
	@NotBlank
	@Column(length = 100, name = "city_name", nullable = false)
	private String cityName;
	
	@Column(nullable = false, unique = true)
	private int pincode;
}

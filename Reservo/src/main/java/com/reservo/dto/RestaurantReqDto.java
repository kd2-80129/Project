package com.reservo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantReqDto {
	
	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	
	private String restaurantName;

	private String email;
	
	private boolean isOpen;
	
	private String address;
	
	private int availableSeats;
}

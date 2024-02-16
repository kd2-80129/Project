package com.reservo.dto;

import java.time.LocalDateTime;

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
public class ReservationReqDto {

	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	
	private LocalDateTime reservationDateTime;
	
	private int partySize;
	
}

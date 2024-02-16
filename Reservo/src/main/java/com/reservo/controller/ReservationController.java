package com.reservo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservo.dto.ReservationReqDto;
import com.reservo.entities.UserEntity;
import com.reservo.service.ReservationService;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@PostMapping("/reserve/{restId}")
	public ResponseEntity<?> makeReservation(@PathVariable Long restId, @RequestBody ReservationReqDto reqDto, HttpServletRequest req){
		HttpSession session = req.getSession();
		UserEntity user = (UserEntity) session.getAttribute("curr_user");
		
		if(user != null) {
			return ResponseEntity.status(HttpStatus.OK).body(reservationService.makeReservation(restId, reqDto, user));
		}
		String error = "Please Login First..!!";
		
		return ResponseEntity.status(HttpStatus.OK).body(error);
	}
}

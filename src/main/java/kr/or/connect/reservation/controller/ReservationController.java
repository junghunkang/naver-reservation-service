package kr.or.connect.reservation.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationService;

@RestController
@RequestMapping(path="/api/reservationinfo")
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@PostMapping
	public ReservationInfo write(@RequestBody ReservationInfo reservationInfo) {
		int reservationInfoId = reservationService.addReservationInfo(reservationInfo);
		ReservationInfo resultReservationInfo = reservationService.getReservationInfo(reservationInfoId);
		return resultReservationInfo;
	}
	
	
	@GetMapping
	public Map<String,Object> getReservationInfo(Principal principal) {
		String loginId;
		if(principal == null) loginId = "carami@example.com";
		else loginId = principal.getName();
		
		List<Reservation> list = reservationService.getReservationInfoByLoginId(loginId);
		int size = list.size();
		
		Map<String,Object> map = new HashMap<>();
		map.put("items",list);
		map.put("size", size);
		return map;
	}
	
	@PutMapping
	public Map<String,Object> updateReservation(@RequestBody Map<String,Integer> params){
		Integer reservationId = params.get("id");
		String result = reservationService.cancelReservation(reservationId);
		Map<String,Object> map = new HashMap<>();
		map.put("result", result);
		return map;
	}
	
}

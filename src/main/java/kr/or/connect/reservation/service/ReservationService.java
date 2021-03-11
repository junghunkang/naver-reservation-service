package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.ReservationInfo;

public interface ReservationService {
	public int addReservationInfo(ReservationInfo reservationInfo);
	public ReservationInfo getReservationInfo(int reservationInfoId);
	public List<Reservation> getReservationInfoByLoginId(String loginId);
	public String cancelReservation(int reservationId);
	
}

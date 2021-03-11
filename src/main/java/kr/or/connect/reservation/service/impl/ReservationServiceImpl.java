package kr.or.connect.reservation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.dto.Price;
import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	
	@Autowired
	ReservationDao reservationDao;
	
	@Transactional(readOnly = false)
	@Override
	public int addReservationInfo(ReservationInfo reservationInfo) {
		reservationInfo.setReservationDate(new Date());
		int reservationInfoId = reservationDao.insertReservationInfo(reservationInfo);
		for(Price price : reservationInfo.getPrices()) {
			price.setReservationInfoId(reservationInfoId);
			reservationDao.insertPrice(price);
		}
		
		return reservationInfoId;
	}
	
	@Transactional
	@Override 
	public ReservationInfo getReservationInfo(int reservationInfoId){
		ReservationInfo resultReservationInfo = reservationDao.getReservationInfo(reservationInfoId);
		resultReservationInfo.setPrices(reservationDao.getPricesById(reservationInfoId));
		
		return resultReservationInfo;
	}

	@Override
	public List<Reservation> getReservationInfoByLoginId(String loginId) {
		List<Reservation> list = reservationDao.getReservationInfoByLoginId(loginId);
		return list;
	}

	@Override
	public String cancelReservation(int reservationId) {
		return reservationDao.updateReservationInfo(reservationId);
	}

	
	

}

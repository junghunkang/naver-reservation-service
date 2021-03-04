package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.PromotionDao;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService{
	
	@Autowired
	PromotionDao promotionDao;
	
	@Transactional
	@Override
	public List<Promotion> getPromotions() {
		return promotionDao.selectAll();
	}

	@Transactional
	@Override
	public int getCount() {
		return promotionDao.selectCount();
	}

}

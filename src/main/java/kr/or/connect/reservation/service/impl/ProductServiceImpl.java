package kr.or.connect.reservation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.Price;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductDao productDao;
	
	@Transactional
	@Override
	public List<Product> products(Integer start) {
		List<Product> list = productDao.products(start, ProductService.LIMIT);
		return list;
	}

	@Transactional
	@Override
	public int getCount() {
		return productDao.getCount();
	}

	@Transactional
	@Override
	public Product getProduct(int id) {
		return productDao.selectById(id);
	}
	
	@Transactional
	@Override
	public List<ProductImage> getProdImage(int id) {
		return productDao.selectProdImgById(id);
	}

	@Transactional
	@Override
	public List<DisplayInfoImage> getDIsInfoImage(int id) {
		return productDao.selectDisInfoImgById(id);
	}

	@Transactional
	@Override
	public double getAvgScore(int id) {
		return productDao.selectAvgScoreById(id);
	}

	@Transactional
	@Override
	public List<ProductPrice> getProdPrice(int id) {
		return productDao.selectProdPriceById(id);
	}

	@Transactional
	@Override
	public List<ReservationUserComment> getUserCommentByProdId(Integer start, int id) {
		return productDao.selectReserUserCommentById(start, ProductService.COMMENT_LIMIT, id);
	}

	@Override
	public int getCommentCountById(int id) {
		return productDao.selectCommentCountByProdId(id);
	}

}

package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductDao productdao;
	
	@Transactional
	@Override
	public List<Product> products(Integer start) {
		List<Product> list = productdao.products(start, ProductService.LIMIT);
		return list;
	}

	@Transactional
	@Override
	public int getCount() {
		return productdao.getCount();
	}

}

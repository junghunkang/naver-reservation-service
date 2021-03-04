package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

@RestController
@RequestMapping(path="/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping
	public Map<String,Object> list(@RequestParam(name="start", required=false, defaultValue = "0")int start){
		List<Product> list = productService.products(start);
		int totalCount = productService.getCount();
		int productCount = list.size();
		
		Map<String, Object> map = new HashMap<>();
		map.put("products",list);
		map.put("totalCount", totalCount);
		map.put("productCount", productCount);
		return map;
	}
}

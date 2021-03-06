package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.service.ProductService;

@RestController
@RequestMapping(path="/api/displayinfos")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping
	public Map<String,Object> list(@RequestParam(name="start", defaultValue = "0")int start){
		List<Product> list = productService.products(start);
		int totalCount = productService.getCount();
		int productCount = list.size();
		
		Map<String, Object> map = new HashMap<>();
		map.put("products",list);
		map.put("totalCount", totalCount);
		map.put("productCount", productCount);
		return map;
	}
	
	@GetMapping("/comment")
	public Map<String,Object> userComment(@RequestParam(name="start",defaultValue = "0")int start, @RequestParam(name="productId", defaultValue="1")int productId){
		int totalCount = productService.getCommentCountById(productId);
		List<ReservationUserComment> list = productService.getUserCommentByProdId(start, productId);
		int commentCount = list.size();
		Map<String,Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("commentCount",commentCount);
		map.put("reservationUserComments", list);
		return map;
	}
	
	@GetMapping("/{id}")
	public Map<String,Object> getDisInfpDetail(@PathVariable(name="id") int id){
		Product product = productService.getProduct(id);
		List<ProductImage> productImages = productService.getProdImage(id);
		List<DisplayInfoImage> displayInfoImages = productService.getDIsInfoImage(id);
		double avgScore = productService.getAvgScore(id);
		List<ProductPrice> productPrices = productService.getProdPrice(id);
		Map<String,Object> map = new HashMap<>();
		map.put("product",product);
		map.put("productImages", productImages);
		map.put("displayInfpImages",displayInfoImages);
		map.put("avgScore",avgScore);
		map.put("productPrices",productPrices);
		return map;
	}
	
	
}

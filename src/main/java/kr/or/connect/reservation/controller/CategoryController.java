package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public Map<String,Object> list(){
		
		int count = categoryService.getCount();
		List<Category> list = categoryService.categories();
		Map<String, Object> map = new HashMap<>();
		map.put("size",count);
		map.put("item", list);
		
		return map;
	}

}

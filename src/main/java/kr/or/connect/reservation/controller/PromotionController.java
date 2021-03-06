package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.PromotionService;

@RestController
@RequestMapping(path="/api/promotions")
public class PromotionController {
	
	@Autowired
	PromotionService promotionService;
	
	@ApiOperation(value ="프로모션 정보 얻기")//web api의 간단한 설명을 적어준다.
	@ApiResponses({ // 응답메세지에 대한 명세 설명 
		@ApiResponse(code=200, message = "OK"),
		@ApiResponse(code=500, message = "Exception")
	})
	@GetMapping
	public Map<String,Object> list(){
		List<Promotion> list = promotionService.getPromotions();
		int size = promotionService.getCount();
		
		Map<String,Object> map = new HashMap<>();
		map.put("items",list);
		map.put("size", size);
		return map;
	}
}

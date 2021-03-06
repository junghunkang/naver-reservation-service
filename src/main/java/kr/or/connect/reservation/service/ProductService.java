package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.ReservationUserComment;

public interface ProductService {
	public static final Integer LIMIT = 4;
	public static final Integer COMMENT_LIMIT = 5;
	public List<Product> products(Integer start);
	public int getCount();
	public Product getProduct(int id);
	public List<ProductImage> getProdImage(int id);
	public List<DisplayInfoImage> getDIsInfoImage(int id);
	public double getAvgScore(int id);
	public List<ProductPrice> getProdPrice(int id);
	public List<ReservationUserComment> getUserCommentByProdId(Integer start, int id); 
	public int getCommentCountById(int id);
}

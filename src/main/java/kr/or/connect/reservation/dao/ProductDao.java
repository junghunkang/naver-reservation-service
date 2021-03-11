package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.Price;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.ReservationUserComment;

import static kr.or.connect.reservation.dao.ProductDaoSqls.*;


@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	private RowMapper<ProductImage> imgRowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	private RowMapper<DisplayInfoImage> disImgRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	private RowMapper<ProductPrice> prodPriRowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);
	private RowMapper<ReservationUserComment> commentRowMapper = BeanPropertyRowMapper.newInstance(ReservationUserComment.class);
	private RowMapper<ReservationInfo> reservationRowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
	private RowMapper<Price> priRowMapper =BeanPropertyRowMapper.newInstance(Price.class);
	
	public ProductDao(DataSource datasource) {
		this.jdbc = new NamedParameterJdbcTemplate(datasource);
		this.insertAction = new SimpleJdbcInsert(datasource).withTableName("reservation_info").usingGeneratedKeyColumns("id");
	}

	public List<Product> products(Integer start, Integer limit){
		Map<String,Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_ALL,params,rowMapper);
	}
	
	public int getCount() {
		return jdbc.queryForObject(GET_COUNT,Collections.emptyMap(), Integer.class);
	}
	
	public Product selectById(int id) {
		Map<String,?> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(SELECT_BY_ID,params,rowMapper);
	}
	
	public List<ProductImage> selectProdImgById(int id) {
		Map<String,?> params = Collections.singletonMap("id",id);
		return jdbc.query(SELECT_IMAGE_BY_ID,params,imgRowMapper);
	}
	
	public List<DisplayInfoImage> selectDisInfoImgById(int id){
		Map<String,?> params = Collections.singletonMap("id",id);
		return jdbc.query(SELECT_DISPLAY_INFO_IMAGE_BY_ID, params, disImgRowMapper);
	}
	
	public double selectAvgScoreById(int id) {
		Map<String,?> params = Collections.singletonMap("id",id);
		return jdbc.queryForObject(SELECT_AVG_SCORE,params, Double.class);
	}
	
	public List<ProductPrice> selectProdPriceById(int id){
		Map<String,?> params = Collections.singletonMap("id",id);
		return jdbc.query(SELECT_PRICE_BY_ID, params, prodPriRowMapper);
	}
	public List<ReservationUserComment> selectReserUserCommentById(Integer start, Integer limit, int id){
		Map<String,Integer> params = new HashMap<>();
		params.put("id", id);
		params.put("start", start);
		params.put("limit", limit);
	
		return jdbc.query(SELECT_COMMENT_BY_ID, params, commentRowMapper);
	}
	public int selectCommentCountByProdId(int id) {
		Map<String,?> params = Collections.singletonMap("id",id);
		return jdbc.queryForObject(SELECT_COMMENT_COUNT_BY_ID,params,Integer.class);
	}
	
	
}
package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.ProductDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Price;
import kr.or.connect.reservation.dto.Reservation;
import kr.or.connect.reservation.dto.ReservationInfo;

@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	private RowMapper<ReservationInfo> reservationRowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
	private RowMapper<Price> priRowMapper =BeanPropertyRowMapper.newInstance(Price.class);
	private RowMapper<Reservation> resInfoRowMapper = BeanPropertyRowMapper.newInstance(Reservation.class);
	
	public ReservationDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info").usingGeneratedKeyColumns("id");
	}
	
	public int insertReservationInfo(ReservationInfo reservationInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	public ReservationInfo getReservationInfo(int id) {
		Map<String,?> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(SELECT_RESERVATION_INFO, params, reservationRowMapper);
	}
	public void insertPrice(Price price) {
		Map<String, Object> params = new HashMap<>();
		params.put("reservationInfoId",price.getReservationInfoId());
		params.put("productPriceId",price.getProductPriceId());
		params.put("count", price.getCount());
		jdbc.update(INSERT_PRICE,params);
	}
	public List<Price> getPricesById(int reservationInfoId){
		Map<String,?> params = Collections.singletonMap("reservationInfoId", reservationInfoId);
		return jdbc.query(SELECT_PRICE_BY_RESERV_ID, params, priRowMapper);
	}
	public List<Reservation> getReservationInfoByLoginId(String loginId){
		Map<String,?> params = Collections.singletonMap("email",loginId);
		return jdbc.query(SELECT_RESERVATION_BY_EMAIL, params, resInfoRowMapper);
	}
}

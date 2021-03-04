package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Promotion;

import static kr.or.connect.reservation.dao.PromotionDaoSqls.*;

@Repository
public class PromotionDao {
	
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Promotion> rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);
	
	public PromotionDao(DataSource datasource) {
		jdbc = new NamedParameterJdbcTemplate(datasource);
	}
	
	
	public List<Promotion> selectAll(){
		return jdbc.query(SELECT_ALL, rowMapper);
	}
	
	public int selectCount() {
		return jdbc.queryForObject(GET_COUNT,Collections.emptyMap(),Integer.class);
	}
	
}

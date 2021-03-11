package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.MemberRole;
import static kr.or.connect.reservation.dao.MemberRoleDaoSqls.*;

@Repository
public class MemberRoleDao {
	private NamedParameterJdbcTemplate jdbc;
	
	private RowMapper<MemberRole> rowMapper = BeanPropertyRowMapper.newInstance(MemberRole.class);
	
	public MemberRoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<MemberRole> getRolesByEmail(String email){
		Map<String,Object> map = new HashMap<>();
		map.put("email",email);
		
		return jdbc.query(SELECT_ALL_BY_EMAIL, map, rowMapper);
	}
}

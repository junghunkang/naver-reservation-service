package kr.or.connect.reservation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Category;
import static kr.or.connect.reservation.dao.CategoryDaoSqls.*;

@Repository
public class CategoryDao {
	private JdbcTemplate jdbc;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);

	public CategoryDao(DataSource datasource) {
		this.jdbc = new JdbcTemplate(datasource);
	}

	public List<Category> selectAll() {
		return jdbc.query(SELECT_ALL, rowMapper);
	}
}

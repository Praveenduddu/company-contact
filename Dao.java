package de.zeroco.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import de.zeroco.jdbc.QueryBuilder;

public class Dao {
	
	JdbcTemplate jdbcTemplate;
	public static final String SCHEMA = "zerocode";
	public static final String TABLE_NAME = "company";
	public static final String CONDITIONAL_COLUMN = "pk_id";
	public static final String CONDITIONAL_OPERATOR = "=";
	public static final String[] COLUMNS = { "name", "email", "number", "address"};
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional
	public int insert(Company company) {
		try {
			return jdbcTemplate.update(QueryBuilder.getInsertQuery(SCHEMA, TABLE_NAME, Arrays.asList(COLUMNS)), company.getName(), company.getEmail(), company.getNumber(), company.getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Transactional
	public int update(Company company) {
		try {
			return jdbcTemplate.update(QueryBuilder.getUpdateQuery(SCHEMA, TABLE_NAME, Arrays.asList(COLUMNS), CONDITIONAL_COLUMN), company.getName(), company.getEmail(), company.getNumber(), company.getAddress(), company.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Transactional
	public int delete(int id) {
		try {
			return jdbcTemplate.update(QueryBuilder.getDeleteQuery(SCHEMA, TABLE_NAME, CONDITIONAL_COLUMN), id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Map<String, Object> get(int id) {
		try {
			return jdbcTemplate.queryForMap(QueryBuilder.getQuery(SCHEMA, TABLE_NAME, new ArrayList<String>(),CONDITIONAL_COLUMN, CONDITIONAL_OPERATOR), id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Map<String, Object> get(String columnName, Object columnValue) {
		try {
			return jdbcTemplate.queryForMap(QueryBuilder.getQuery(SCHEMA, TABLE_NAME, new ArrayList<String>(), columnName, CONDITIONAL_OPERATOR), columnValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Map<String, Object>> list() {
		try {
			return jdbcTemplate.queryForList(QueryBuilder.getListQuery(SCHEMA, TABLE_NAME, new ArrayList<String>()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

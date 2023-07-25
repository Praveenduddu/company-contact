package de.zeroco.contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import de.zeroco.jdbc.QueryBuilder;

public class ContactDao {

	JdbcTemplate jdbcTemplate;
	public static final String SCHEMA = "zerocode";
	public static final String TABLE_NAME = "company_contact";
	public static final String CONDITIONAL_COLUMN = "pk_id";
	public static final String CONDITIONAL_OPERATOR = "=";
	public static final String[] COLUMNS = { "name", "email", "number", "date_of_birth", "address", "company_id" };

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Contact contact) {
		System.out.println(contact.getCompanyId());
		try {
			return jdbcTemplate.update(QueryBuilder.getInsertQuery(SCHEMA, TABLE_NAME, Arrays.asList(COLUMNS)), contact.getName(), contact.getEmail(), contact.getNumber(), contact.getDateOfBirth(), contact.getAddress(), contact.getCompanyId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int update(Contact contact) {
		try {
			return jdbcTemplate.update(QueryBuilder.getUpdateQuery(SCHEMA, TABLE_NAME, Arrays.asList(COLUMNS), CONDITIONAL_COLUMN), contact.getName(), contact.getEmail(), contact.getNumber(), contact.getDateOfBirth(), contact.getAddress(), contact.getCompanyId(), contact.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

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

	public List<Map<String, Object>> list() {
		try {
			return jdbcTemplate.queryForList(QueryBuilder.getListQuery(SCHEMA, TABLE_NAME, new ArrayList<String>()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Map<String, Object>> get(String columnName, String conditionColumn, Object value) {
		try {
			return jdbcTemplate.queryForList(QueryBuilder.getQuery(SCHEMA, TABLE_NAME, new ArrayList<String>(Arrays.asList(columnName)), conditionColumn, CONDITIONAL_OPERATOR), value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

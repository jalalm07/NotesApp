package com.jalal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.jalal.model.Notes;


@Repository
public class NotesDaoImpl implements NotesDao {
	
	@Autowired 
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<Notes> listAllNotes() {
		String sql ="Select id, title, description, createddate, updateddate from user_notes";
		
		List<Notes> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new NoteMapper());
		return list;
	}

	private SqlParameterSource getSqlParameterByModel(Notes note) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(note!= null) {
			paramSource.addValue("id", note.getId());
			paramSource.addValue("title", note.getTitle());
			paramSource.addValue("description", note.getDescription());
			paramSource.addValue("createddate", new Date());
			paramSource.addValue("updateddate", new Date());
		}
		return paramSource;
	}
	
	private SqlParameterSource getSqlParameterByModelForUpdate(Notes note) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(note!= null) {
			paramSource.addValue("id", note.getId());
			paramSource.addValue("title", note.getTitle());
			paramSource.addValue("description", note.getDescription());
			paramSource.addValue("updateddate", new Date());
		}
		return paramSource;
	}
	
	public static final class NoteMapper implements RowMapper<Notes>{

		public Notes mapRow(ResultSet rs, int rowNum) throws SQLException {
			Notes note = new Notes();
			note.setId(rs.getInt("id"));
			note.setTitle(rs.getString("title"));
			note.setDescription(rs.getString("description"));
			note.setCreatedTime(rs.getTimestamp("createddate"));
			note.setUpdatedTime(rs.getTimestamp("updateddate"));
			return note;
		}
		
	}

	public void addNote(Notes note) {
		String sql ="insert into user_notes(title,description,createddate,updateddate) values (:title, :description, :createddate, :updateddate) ";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(note));
	}

	public void updateNote(Notes note) {
		String sql = "update user_notes set title =:title, description=:description, updateddate=:updateddate where id = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModelForUpdate(note));
	}

	public void deleteNote(int id) {
		String sql = "delete from user_notes where id = :id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Notes(id)));

	}

	public Notes findNoteById(int id) {
		String sql = "select * from user_notes where id = :id";
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Notes(id)), new NoteMapper());
		
	}

}

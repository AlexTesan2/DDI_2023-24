package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.student;
@Repository
public class studentjdbcrepository {
    @Autowired
    JdbcTemplate JdbcTemplate;
    
    public student findById(long id) {
		return JdbcTemplate.queryForObject("select * from estudiante where id=?",
				new BeanPropertyRowMapper<student>(student.class), new Object[] { id });
	}
    
    class studentrowmapper implements RowMapper < student > {
        @Override
        public student maprow(ResultSet rs, int rownum) throws SQLException {
            student student = new student();
            student.setid(rs.getLong("id"));
            student.setname(rs.getString("name"));
            student.setpassportnumber(rs.getString("passport_number"));
            return student;
        }

	}
    public list < student > findall() {
        return jdbctemplate.query("select * from student", new studentrowmapper());
    }
    
}
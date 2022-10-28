package com.example.hello.dao;

import com.example.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(final User user) {
        this.jdbcTemplate.update("INSERT INTO users(id, name, password) values(?,?,?)",
                user.getId(),
                user.getName(),
                user.getPassword()
        );
    }

    public int deleteAll() {
        return this.jdbcTemplate.update("delete from users");
    }

    public User findById(String id) {
        String sql = "select * from users where id = ?";
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
                return user;
            }
        };

        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }


}

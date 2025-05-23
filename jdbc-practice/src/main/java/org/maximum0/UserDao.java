package org.maximum0;

import java.sql.*;

public class UserDao {
    public void create(User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        jdbcTemplate.executeUpdate(sql, pstmt -> {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
        });
    }

    public User findByUserId(String userId) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";
        return jdbcTemplate.executeQuery(sql, pstmt -> {
            pstmt.setString(1, userId);
        }, rs -> new User(
            rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"))
        );
    }
}

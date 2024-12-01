package com.example.demo.repositories;

import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("Name"));
            rowObject.setLastName(r.getString("GroupNAme"));
            return  rowObject;
        };
        return  jdbc.query(sql, userRowMapper);
    }

    public User save (User user){
        String sql = "INSERT INFO userTable VALUES (NULL, ?, ?)";
        jdbc.update(sql, user.getName(), user.getLastName());
        return user;
    }
    // Удаление пользователя
public void deleteById(int id){
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
}


}

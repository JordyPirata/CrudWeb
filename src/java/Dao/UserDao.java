package Dao;
import Models.User;
import Connection.DBConnection;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DBConnection cn = new DBConnection();
    public User getUserById(int id) {
        User user = null;
        try {
            con = cn.getConnection();
            String query = "SELECT * FROM users WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's need
        } finally {
            closeResources();
        }
        return user;
    }
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            con = cn.getConnection();
            String query = "SELECT * FROM users";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            closeResources();
        }
        return users;
    }
    public boolean addUser(User user) {
        try {
            con = cn.getConnection();
            String query = "INSERT INTO users (userName, password) VALUES (?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
            return false;
        } finally {
            closeResources();
        }
    }
    public void updateUser(User user) {
        try {
            con = cn.getConnection();
            String query = "UPDATE users SET userName = ?, password = ? WHERE userId = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            closeResources();
        }
    }
    public void deleteUser(int id) {
        try {
            con = cn.getConnection();
            String query = "DELETE FROM users WHERE userId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            closeResources();
        }
    }
    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }
}
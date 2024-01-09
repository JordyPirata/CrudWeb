package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Connection.DBConnection;
import Models.Report;

import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class ReportsDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DBConnection cn = new DBConnection();

    public Report getReportById(int id) {
        Report report = null;
        try {
            con = cn.getConnection();
            String query = "SELECT * FROM reports WHERE reportId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                report = new Report();
                report.setReportId(rs.getInt("reportId"));
                report.setUserId(rs.getInt("userId"));
                report.setProjectId(rs.getInt("projectId"));
                report.setDate(rs.getObject("date", LocalDateTime.class));
                report.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's need
        } finally {
            closeResources();
        }
        return report;
    }
    public List<Report> getAllReports() {
        List<Report> reports = new ArrayList<>();
        try {
            con = cn.getConnection();
            String query = "SELECT * FROM reports";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Report report = new Report();
                report.setReportId(rs.getInt("reportId"));
                report.setUserId(rs.getInt("userId"));
                report.setProjectId(rs.getInt("projectId"));
                report.setDate(rs.getObject("date", LocalDateTime.class));
                report.setDescription(rs.getString("description"));
                reports.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            closeResources();
        }
        return reports;
    }
    public boolean addReport(Report report) {
        try {
            con = cn.getConnection();
            String query = "INSERT INTO reports (userId, projectId, date, description) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, report.getUserId());
            ps.setInt(2, report.getProjectId());
            ps.setObject(3, report.getDate());
            ps.setString(4, report.getDescription());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            closeResources();
        }
        return false;
    }
    public void updateReport(Report report) {
        try {
            con = cn.getConnection();
            String query = "UPDATE reports SET userId = ?, projectId = ?, date = ?, description = ? WHERE reportId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, report.getUserId());
            ps.setInt(2, report.getProjectId());
            ps.setObject(3, report.getDate());
            ps.setString(4, report.getDescription());
            ps.setInt(5, report.getReportId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            closeResources();
        }
    }
    public void deleteReport(int id) {
        try {
            con = cn.getConnection();
            String query = "DELETE FROM reports WHERE reportId = ?";
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
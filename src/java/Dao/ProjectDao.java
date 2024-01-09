package Dao;
import Models.Project;
import Connection.DBConnection;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DBConnection cn = new DBConnection();

    public Project getProjectById(int id) {
        Project project = null;
        try {
            con = cn.getConnection();
            String query = "SELECT * FROM project WHERE projectId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                project = new Project();
                project.setProjectId(rs.getInt("projectId"));
                project.setProjectDescription(rs.getString("projectDescription"));
                project.setResponsibleName(rs.getString("responsibleName"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's need
        } finally {
            closeResources();
        }
        return project;
    }
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        try {
            con = cn.getConnection();
            String query = "SELECT * FROM project";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setProjectId(rs.getInt("projectId"));
                project.setProjectDescription(rs.getString("projectDescription"));
                project.setResponsibleName(rs.getString("responsibleName"));
                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            closeResources();
        }
        return projects;
    }
    public void addProject(Project project) {
        try {
            con = cn.getConnection();
            String query = "INSERT INTO project (projectDescription, responsibleName) VALUES (?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, project.getProjectDescription());
            ps.setString(2, project.getResponsibleName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            closeResources();
        }
    }
    public void updateProject(Project project) {
        try {
            con = cn.getConnection();
            String query = "UPDATE project SET projectDescription = ?, responsibleName = ? WHERE projectId = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, project.getProjectDescription());
            ps.setString(2, project.getResponsibleName());
            ps.setInt(3, project.getProjectId());
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

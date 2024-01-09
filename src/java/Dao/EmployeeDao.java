package Dao;
import Models.Employee;
import Models.Project;
import Connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;


public class EmployeeDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DBConnection cn = new DBConnection();

    public Employee getEmployeeById(int id){
        Employee employee = null;
        try{
            con = cn.getConnection();
            String query = "SELECT * FROM employee WHERE employeeId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                employee = new Employee();
                employee.setEmployeeId(rs.getInt("employeeId"));
                employee.setAssingmentId(rs.getInt("assingmentId"));
                employee.setName(rs.getString("name"));
                employee.setNomina(rs.getString("nomina"));
            }
        } catch (SQLException e){
            e.printStackTrace(); // Handle the exception according to your application's need
        } finally {
            closeResources();
        }
        return employee;
    }
    public ArrayList<Employee> getAllEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();
        try{
            con = cn.getConnection();
            String query = "SELECT * FROM employee";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employeeId"));
                employee.setAssingmentId(rs.getInt("assingmentId"));
                employee.setName(rs.getString("name"));
                employee.setNomina(rs.getString("nomina"));
                employees.add(employee);
            }
        } catch (SQLException e){
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            closeResources();
        }
        return employees;
    }
    public void addEmployee(Employee employee){
        try{
            con = cn.getConnection();
            String query = "INSERT INTO employee (employeeId, assignmentId, name, nomina) VALUES (?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, employee.getEmployeeId());
            ps.setInt(2, employee.getAssingmentId());
            ps.setString(3, employee.getName());
            ps.setString(4, employee.getNomina());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            closeResources();
        }
    }
    public void updateEmployee(Employee employee){
        try{
            con = cn.getConnection();
            String query = "UPDATE employee SET assignmentId = ?, name = ?, nomina = ? WHERE employeeId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, employee.getAssingmentId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getNomina());
            ps.setInt(4, employee.getEmployeeId());
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace(); // Handle the exception according to your application's needs
        } finally {
            closeResources();
        }
    }
    public void deleteEmployee(int id){
        try{
            con = cn.getConnection();
            String query = "DELETE FROM employee WHERE employeeId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e){
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

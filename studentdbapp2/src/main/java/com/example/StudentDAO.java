package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String URL  = "jdbc:mysql://localhost:3306/cruddb";
    private static final String USER = "root";
    private static final String PASS = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL driver not found", e);
        }
    }

    public void addStudent(String name, int age) {
        String sql = "INSERT INTO oper(name, age) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting student", e);
        }
    }

    public List<Student> listStudents() {
        String sql = "SELECT id, name, age FROM oper ORDER BY id DESC";
        List<Student> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching students", e);
        }
        return list;
    }

     public void delStudent(int id) {
        String sql = "delete from oper where id= ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting student", e);
        }
    }
    public boolean UpdateStudentServlet(int id, String name, int age) {
    String sql = "UPDATE oper SET name = ?, age = ? WHERE id = ?";
    try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
         PreparedStatement ps = conn.prepareStatement(sql)) {
         
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setInt(3, id);

        int rows = ps.executeUpdate();
        return rows > 0; // true if update happened
    } catch (SQLException e) {
        throw new RuntimeException("Error updating student", e);
    }
}

}

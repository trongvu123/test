/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import entity.Employees;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class dao extends DBContext {

    public ArrayList<Employees> getAll() {
        String sql = "select *\n"
                + "from Employees";
        ArrayList<Employees> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Employees employees = new Employees(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(employees);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Employees getOne(int id) {
        String sql = "select Employees.*\n"
                + "from Employees\n"
                + "where Employees.id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Employees(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));

            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean update(Employees e) {
        String sql = "UPDATE [dbo].[Employees]\n"
                + "SET [first] = ?,\n"
                + "    [last] = ?,\n"
                + "    [age] = ?\n"
                + "WHERE [id] = ?";

        int check = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(4, e.getId());
            st.setString(1, e.getFirst());
            st.setString(2, e.getLastString());
            st.setInt(3, e.getAge());
            check = st.executeUpdate();
        } catch (Exception ex) {
        }
        return check > 0;
    }

    public void delete(String id) {
        String sql = "DELETE FROM [dbo].[Employees]\n"
                + "      WHERE Employees.id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<Employees> getListEmployeesesByTextSearch(String textSearch) {
        String sql = "select Employees.*\n"
                + "from Employees\n"
                + "where Employees.first like ?";
        ArrayList<Employees> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + textSearch + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Employees employees = new Employees(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(employees);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public boolean add(Employees employees) {
        String sql = "INSERT INTO [dbo].[Employees]\n"
                + "           ([id]\n"
                + "           ,[first]\n"
                + "           ,[last]\n"
                + "           ,[age])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?)";

        int check = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, employees.getId());
            st.setString(2, employees.getFirst());
            st.setString(3, employees.getLastString());
            st.setInt(4, employees.getAge());
            check = st.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }

    public Account getAccount(String username, String password) {
        String sql = "select [user].*\n"
                + "from [user]\n"
                + "where [user].acc=? and [user].password=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return new Account(rs.getString(1), rs.getString(2));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        dao d = new dao();
        Employees employees = d.getOne(1);
        System.out.println(employees);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.KindOfBook;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;

/**
 *
 * @author Admin
 */
public class KindOfBookDAO extends DBContext {

    public List<KindOfBook> getAll() {
        List<KindOfBook> list = new ArrayList<>();
        String sql = "select * from KindOfBook";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                KindOfBook k = new KindOfBook(rs.getString("bookCode"), rs.getString("category"));
                list.add(k);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void insert(KindOfBook k) {
        String sql = "insert into KindOfBook(BookCode, Category) values (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, k.getBookCode());
            st.setString(2, k.getCategory());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public KindOfBook getID(String code) {
        String sql = "select * from KindOfBook where BookCode=?";
        try {
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, code);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                KindOfBook k = new KindOfBook(rs.getString("bookCode"), rs.getString("category"));
                return k;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void delete(String code) {
        String sql = "DELETE FROM [dbo].[KindOfBook]\n"
                + "      WHERE BookCode=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, code);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(KindOfBook k) {
        String sql = "update KindOfBook set Category=? where BookCode=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, k.getCategory());
            st.setString(2, k.getBookCode());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Account getAcc(String username, String pass) {
        String sql = "select *\n"
                + "from account a\n"
                + "where a.Username=? and a.Password=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        KindOfBookDAO k = new KindOfBookDAO();
        Account acc = k.getAcc("user1", "password1");
        System.out.println(acc);
    }

}

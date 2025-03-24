/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Intility.CRUD_DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author admin
 */
public class DangNhapService {

    public boolean checkLogin(String username, String password) {
        String sql = "select * from Acccount \n"
                + "where userName = ? AND passWord = ?";

        try (Connection conn = CRUD_DAO.getConnect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Nếu có dữ liệu -> Đăng nhập thành công

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Intility.CRUD_DAO;
import Model.Acccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ServiceAccount {

    public int add(Acccount a) {
        ArrayList<Acccount> lists = new ArrayList<>();
        int row = 0;
        try {
            String sql = "INSERT INTO Acccount (userName, password) VALUES\n"
                    + "(?, ?)";
            Connection con = CRUD_DAO.getConnect();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, a.getUsername());
            pstm.setString(2, a.getPassword());
            row = pstm.executeUpdate();
        } catch (Exception e) {
        }
        return row;
    }

    public int add_user(User a) {
        ArrayList<Acccount> lists_account = new ArrayList<>();
        int row = 0;
        try {
            String sql = "INSERT INTO Users(full_name, password)\n"
                    + "VALUES (?, ?)";
            Connection con = CRUD_DAO.getConnect();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, a.getUsername());
            pstm.setString(2, a.getPassword());
            row = pstm.executeUpdate();
        } catch (Exception e) {
        }
        return row;

    }
}

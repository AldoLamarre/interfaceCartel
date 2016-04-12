/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseConnection;

import com.mysql.jdbc.jdbc2.optional.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;
import javax.swing.*;

/**
 *
 * @author
 */
public class MysqlConnection {

    String user = "root";
    String password = "";
    String server = "localhost";
    String dbName = "cartel";
    int dbPort = 3306;
    MysqlDataSource dataCartel;

    // MysqlDataSource dataSource;
    public MysqlConnection() {
        dataCartel = new MysqlDataSource();
        dataCartel.setUser(user);
        dataCartel.setPassword(password);
        dataCartel.setServerName(server);
        dataCartel.setDatabaseName(dbName);
        dataCartel.setPort(dbPort);
    }

    /**
     *
     * @param s request in string
     * @return error
     * @throws java.sql.SQLException
     */
    public ResultSet send_request(String s) throws SQLException {
        Connection c;
        Statement st;
        ResultSet rs;

        c = dataCartel.getConnection();
        st = c.createStatement();
        rs = st.executeQuery(s);
        return rs;

    }

    /**
     *
     * @param s
     * @param jTbl
     * @return
     * @throws SQLException
     */
    public void send_request(String s, JTable jTbl) throws SQLException {

        RunQuery r = new RunQuery() {
            Connection c;
            Statement st;
            ResultSet rs;

            @Override
            public void run() {

                try {
                    c = dataCartel.getConnection();
                    st = c.createStatement();
                    rs = st.executeQuery(s);
                    SwingUtilities.invokeLater(() -> {
                        jTbl.setModel(DbUtils.resultSetToTableModel(rs));
                    });
                    System.out.println(rs.toString());
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public ResultSet getRs() {
                return rs;
            }

        };
        Thread t = new Thread(r);
        t.start();       
    }

    public static void main(String[] args) {
        MysqlConnection msq = new MysqlConnection();
        JTable jTbltest=  new JTable();
        JFrame frm = new JFrame();
        ResultSet rs ;
        
        try {
            msq.send_request("SHOW TABLES",jTbltest);
           // jTbltest = new JTable(DbUtils.resultSetToTableModel(rs));
            frm.getContentPane().add(jTbltest);
            //System.out.println(rs.toString());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        frm.setSize(1280, 720);
        frm.setVisible(true);
    }

    interface RunQuery extends Runnable {

        @Override
        public void run();

        public ResultSet getRs();

    }
}

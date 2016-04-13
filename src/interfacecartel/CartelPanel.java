/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import databaseConnection.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Al
 */
public class CartelPanel extends JPanel {

    JTextField cartelTxt;
    JButton search;
    JLabel cartelLbl;
    JTable compagnie;
    JScrollPane tblContainer;

    public CartelPanel() {
        addcomponent();
    }

    private void addcomponent() {
        //cartelTxt = new JTextField();
        //search = new JButton();

        compagnie = new JTable();
        tblContainer = new JScrollPane(compagnie);
        //cartelLbl = new JLabel();

        MysqlConnection msc = new MysqlConnection();

        /* Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
            
            
            }
            
            
            });*/
        msc.send_request("SELECT * FROM Cartel", compagnie);

        tblContainer.setBorder(BorderFactory.createEmptyBorder());
        tblContainer.setViewportBorder(null);
        //this.add(cartelTxt);
        //this.add(search);
        this.add(tblContainer);
        //this.add(cartelLbl); 
        compagnie.setPreferredSize(new Dimension(1000, 300));;
        tblContainer.setPreferredSize(new Dimension(1000, 300));

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import databaseConnection.*;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Al
 */
public class CartelPanel extends JPanel {
    CustomSQLConnection msq;
    JTextField cartelTxt;
    JButton search;
    JLabel cartelLbl;
    JTable compagnie;
    JScrollPane tblContainer;

    public CartelPanel(CustomSQLConnection msq) {
        this.msq=msq;
        addcomponent();
    }

    private void addcomponent() {
        //cartelTxt = new JTextField();
        //search = new JButton();

        compagnie = new JTable();
        tblContainer = new JScrollPane(compagnie);        //cartelLbl = new JLabel();

       

        /* Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
            
            
            }
            
            
            });*/
        msq.send_request("SELECT nom AS Cartels FROM Cartel", compagnie);

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

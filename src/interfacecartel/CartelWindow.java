/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import databaseConnection.MysqlConnection;
import javax.swing.*;

/**
 *
 * @author Al
 */
public class CartelWindow extends JFrame  {
    
    
    public CartelWindow(MysqlConnection msq){      
        TabPanel tb = new TabPanel(msq);        
        this.setVisible(true);
        this.setSize(1280, 720);
        this.setContentPane(tb);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
     
}

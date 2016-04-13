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
public class TabPanel extends JTabbedPane {
    
    public TabPanel(MysqlConnection msq) {
        createtab(msq);
        
    }
    
    private void createtab(MysqlConnection msq){
        HomePanel homePanel = new HomePanel(MysqlConnection msq); 
        CompagniePanel companiePanel = new CompagniePanel(); 
        GisementPanel gisementPanel = new GisementPanel(); 
        CompagniePanel cartelPanel = new CompagniePanel();
        
        this.add("home",homePanel);
        this.add("compagnie",companiePanel);
        this.add("gisement",gisementPanel);
        this.add("cartel", cartelPanel);
       
    }
    
}

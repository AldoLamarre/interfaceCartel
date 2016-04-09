/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import javax.swing.*;
/**
 *
 * @author Al
 */
public class TabPanel extends JTabbedPane {
    
    public TabPanel() {
        super();
        createtab();
        
    }
    
    private void createtab(){
        HomePanel homePanel = new HomePanel(); 
        CompagniePanel companiePanel = new CompagniePanel(); 
        GisementPanel gisementPanel = new GisementPanel(); 
        
        this.add("home",homePanel);
        this.add("compagnie",companiePanel);
        this.add("gisement",gisementPanel);
       
    }
    
}

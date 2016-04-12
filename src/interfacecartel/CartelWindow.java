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
public class CartelWindow extends JFrame  {
    
    
    public CartelWindow(){      
        TabPanel tb = new TabPanel();
        this.setVisible(true);
        this.setSize(1280, 720);
        this.setContentPane(tb);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void dummy(){
        
    
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //datarequest here
                throw new UnsupportedOperationException("Not supported yet."); 
                //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
}

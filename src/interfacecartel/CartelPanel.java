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
public class CartelPanel extends JPanel {

    JTextField cartelTxt;
    JButton search;
    JLabel cartelLbl;
    JTable compagnie;

    public CartelPanel() {
        addcomponent();
    }

    private void addcomponent() {
        cartelTxt = new JTextField();
        search = new JButton();
        compagnie = new JTable();
        cartelLbl = new JLabel();

        this.add(cartelTxt);
        this.add(search);
        this.add(compagnie);
        this.add(cartelLbl); 
        
          
        
    }
}

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
public class GisementPanel extends JPanel {
    
    private SelectionPanel gisementPanel;
    
    public GisementPanel() {
        addPanel();
    }
    private void addPanel()
    {
        gisementPanel = new SelectionPanel("Gisement");
        this.add(gisementPanel);
    }
}

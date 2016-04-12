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
public class CompagniePanel extends JPanel {
    private SelectionPanel selectionPanel;
    private AffichageCompagniePanel affComPan;

    public CompagniePanel()
    {
        addPanel();
    }
    
    private void addPanel()
    {
        selectionPanel = new SelectionPanel();
        affComPan = new AffichageCompagniePanel();
        this.add(selectionPanel);
        this.add(affComPan);
    }
}

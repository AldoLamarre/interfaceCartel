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
public class HomePanel extends JPanel {

    private HistoriquePrixPanel historiquePrixPanel;
    private CartelPanel cartelPanel;

    public HomePanel() {
        addPanel();
    }

    private void addPanel() {
        historiquePrixPanel = new HistoriquePrixPanel();
        cartelPanel = new CartelPanel();
        this.add(historiquePrixPanel);
        this.add(cartelPanel);
    }
}

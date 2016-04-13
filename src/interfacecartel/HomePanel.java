/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import databaseConnection.CustomSQLConnection;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Al
 */
public class HomePanel extends JPanel {

    private HistoriquePrixPanel historiquePrixPanel;
    private CartelPanel cartelPanel;

    public HomePanel(CustomSQLConnection msq) {
        addPanel(msq);
    }

    private void addPanel(CustomSQLConnection msq) {
        historiquePrixPanel = new HistoriquePrixPanel(msq);
        cartelPanel = new CartelPanel(msq);

        this.setLayout(new GridLayout(2, 1));
        this.add(historiquePrixPanel);
        this.add(cartelPanel);
        this.repaint();
        this.revalidate();
    }

    public HistoriquePrixPanel getHistoriquePrixPanel() {
        return historiquePrixPanel;
    }

}

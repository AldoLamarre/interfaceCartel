/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import databaseConnection.MysqlConnection;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Al
 */
public class HomePanel extends JPanel {

    private HistoriquePrixPanel historiquePrixPanel;
    private CartelPanel cartelPanel;

    public HomePanel(MysqlConnection msq) {
        addPanel(msq);
    }

    private void addPanel(MysqlConnection msq) {
        historiquePrixPanel = new HistoriquePrixPanel( msq);
        cartelPanel = new CartelPanel( msq);
        
        this.setLayout(new GridLayout(2,1));
        this.add(historiquePrixPanel);
        this.add(cartelPanel);
        this.repaint();
        this.revalidate();
    }
}

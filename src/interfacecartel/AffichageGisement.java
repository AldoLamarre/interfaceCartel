/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maxime
 */
public class AffichageGisement extends JPanel {

    private JLabel txtInfos;
    private JLabel txtProduction;
    private JLabel txtCies;
    public JTable tableInfo;
    public JTable tableProd;
    public JTable tableCies;

    public AffichageGisement() {
        super();
        CreateLayout();
    }

    private void CreateLayout() {
        txtInfos = new JLabel("infos");
        txtProduction = new JLabel("production");
        txtCies = new JLabel("compagnies");

        String[] infosColumns = {"ID", "Nom", "Pays", "Description", "Géolocalisation"};
        String[] prodColumns = {"Capacité estimée", "Capacité réelle", "Année"};
        String[] ciesColumns = {"Nom du Cartel", "Nom de la Compagnie", "Date Début", "Date Fin"};

        Object[][] infosData = {{"ID", "Nom", "Pays", "Description", "Géolocalisation"}};
        Object[][] prodData = {{"Capacité estimée", "Capacité réelle", "Année"}};
        Object[][] ciesData = {{"Nom du Cartel", "Nom de la Compagnie", "Date Début", "Date Fin"}};

        tableInfo = new JTable(infosData, infosColumns);
        tableProd = new JTable(prodData, prodColumns);
        tableCies = new JTable(ciesData, ciesColumns);

        JScrollPane infoTable = new JScrollPane(tableInfo);
        JScrollPane prodTable = new JScrollPane(tableProd);
        JScrollPane ciesTable = new JScrollPane(tableCies);

        Box gisementBox = Box.createVerticalBox();
        gisementBox.setPreferredSize(new Dimension(1000, 300));

        gisementBox.add(txtInfos);
        gisementBox.add(infoTable);
        gisementBox.add(txtProduction);
        gisementBox.add(prodTable);
        gisementBox.add(txtCies);
        gisementBox.add(ciesTable);

        gisementBox.setBorder(BorderFactory.createTitledBorder("Gisement"));

        this.add(gisementBox);
    }
}

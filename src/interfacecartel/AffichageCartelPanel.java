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
public class AffichageCartelPanel extends JPanel {

    private JLabel txtInfos;
    private JLabel txtCies;
    private JLabel txtGisements;
    private JLabel txtProd;
    public JTable tableGis;
    public JTable tableInfo;
    public JTable tableProd;
    public JTable tableCies;

    public AffichageCartelPanel() {
        super();
        CreateLayout();
    }

    private void CreateLayout() {
        txtInfos = new JLabel("infos");
        txtProd = new JLabel("production");
        txtCies = new JLabel("compagnies");
        txtGisements = new JLabel("gisements");

        String[] infosColumns = {"nom"};
        String[] prodColumns = {"Capacité estimée", "Capacité réelle", "Année"};
        String[] ciesColumns = {"Nom du Cartel", "Nom de la Compagnie", "Date Début", "Date Fin"};
        String[] gisColumns = {"ID", "Nom", "Pays", "Description", "Géolocalisation"};

        Object[][] infosData = {{"nom"}};
        Object[][] gisData = {{"ID", "Nom", "Pays", "Description", "Géolocalisation"}};
        Object[][] prodData = {{"Capacité estimée", "Capacité réelle", "Année"}};
        Object[][] ciesData = {{"Nom du Cartel", "Nom de la Compagnie", "Date Début", "Date Fin"}};

        tableGis = new JTable(gisData, gisColumns);
        tableInfo = new JTable(infosData, infosColumns);
        tableProd = new JTable(prodData, prodColumns);
        tableCies = new JTable(ciesData, ciesColumns);

        JScrollPane gisTable = new JScrollPane(tableGis);
        JScrollPane infoTable = new JScrollPane(tableInfo);
        JScrollPane prodTable = new JScrollPane(tableProd);
        JScrollPane ciesTable = new JScrollPane(tableCies);

        Box cartelBox = Box.createVerticalBox();
        cartelBox.setPreferredSize(new Dimension(1000, 300));

        cartelBox.add(txtInfos);
        cartelBox.add(infoTable);
        cartelBox.add(txtProd);
        cartelBox.add(prodTable);
        cartelBox.add(txtCies);
        cartelBox.add(ciesTable);
        cartelBox.add(txtGisements);
        cartelBox.add(gisTable);

        cartelBox.setBorder(BorderFactory.createTitledBorder("Cartel"));

        this.add(cartelBox);
    }
}

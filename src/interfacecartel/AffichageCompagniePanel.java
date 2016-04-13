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
public class AffichageCompagniePanel extends JPanel{
    
    private JLabel txtGisements;
    private JLabel txtSous;
    private JLabel txtInfos;
    
    public AffichageCompagniePanel()
    {
        super();
        CreateLayout();
    }
    
    private void CreateLayout()
    {
        txtGisements = new JLabel("gisements");
        txtSous = new JLabel("sous-compagnies");
        txtInfos = new JLabel("infos");
        
        String[] infosColumns = {"Nom", "Adresse", "Maison mere", "Cartel"};
        String[] compColumns = {"ID", "Nom", "Pays",
        "Geolocalisation", "Debut exploitation", "Fin exploitation", "Production journaliere"};
        
        String[] compListe = {"ID", "Nom"};
        
        Object[][] compData = {
            {"TestID", "teeeeest", "QUÉBEC!", "Quelquepart", "Aujourd'hui", "Demain", "190$"
        },
        {"TestID", "teeeeest", "QUÉBEC!", "Quelquepart", "Aujourd'hui", "Demain", "192$"
        }
        };
        
        Object[][] compDataListe = { {"4","Geant Dormant"},{"5","Agnico Eagle"}};
        
        Object[][] compInfos = {{"Nom","Ceci est mon adresse", "ceci est ma maison mere", "Cacartel"}};
        
        final JTable table1 = new JTable(compData, compColumns);
        final JTable table2 = new JTable(compDataListe, compListe);
        final JTable table3 = new JTable (compInfos, infosColumns);
        
        JScrollPane compTable = new JScrollPane(table1);
        JScrollPane gisTable = new JScrollPane(table2);
        JScrollPane infosTable = new JScrollPane(table3);
        
        Box compagnieBox = Box.createVerticalBox();
        compagnieBox.setPreferredSize( new Dimension( 1000, 300) );
       
        compagnieBox.add(txtInfos);
        compagnieBox.add(infosTable);
        compagnieBox.add(txtSous);
        compagnieBox.add(compTable);
        compagnieBox.add(txtGisements);
        compagnieBox.add(gisTable);
  
        compagnieBox.setBorder(BorderFactory.createTitledBorder("Compagnie"));
        
        this.add(compagnieBox);
    }
}

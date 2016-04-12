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
    
    private JLabel adresse;
    private JLabel cartel;
    private JLabel sous_compagnies;
    private JLabel gisements;
    private JLabel dateDeb;
    private JLabel dateFin;
    private JLabel prodJour;
    
    public AffichageCompagniePanel()
    {
        super();
        CreateLayout();
    }
    
    private void CreateLayout()
    {
        JPanel compagnie = new JPanel();
        compagnie.setLayout(new GridBagLayout());
        
        String[] gisColumns = {"ID", "Nom", "Pays",
        "Geolocalisation", "Debut exploitation", "Fin exploitation", "Production journaliere"};
        
        String[] compColumns = {"ID", "Nom"};
        
        Object[][] gisData = {
            {"TestID", "teeeeest", "QUÉBEC!", "Quelquepart", "Aujourd'hui", "Demain", "190$"
        },
        {"TestID", "teeeeest", "QUÉBEC!", "Quelquepart", "Aujourd'hui", "Demain", "192$"
        }
        };
        
        Object[][] compData = { {"4","Geant Dormant"},{"5","Agnico Eagle"}};
        
        final JTable table1 = new JTable(compData, compColumns);
        final JTable table2 = new JTable(gisData, gisColumns);
        
        JScrollPane compTable = new JScrollPane(table1);
        JScrollPane gisTable = new JScrollPane(table2);
        
        Box compagnieBox = Box.createVerticalBox();
        compagnieBox.setPreferredSize( new Dimension( 1000, 300) );
        
        adresse = new JLabel("adresse: ");
        compagnieBox.add(adresse);
        cartel = new JLabel("cartel: ");
        compagnieBox.add(cartel);
        sous_compagnies = new JLabel("sous-compagnies: ");
        compagnieBox.add(sous_compagnies);
        compagnieBox.add(compTable);
        gisements = new JLabel("gisements: ");
        compagnieBox.add(gisements);
        compagnieBox.add(gisTable);
  
        compagnieBox.setBorder(BorderFactory.createTitledBorder("Compagnie"));
        
        this.add(compagnieBox);
    }
}

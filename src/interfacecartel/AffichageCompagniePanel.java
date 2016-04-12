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
        
        Box compagnieBox = Box.createVerticalBox();
        compagnieBox.setPreferredSize( new Dimension( 700, 300) );
        
        adresse = new JLabel("adresse: ");
        compagnieBox.add(adresse);
        cartel = new JLabel("cartel: ");
        compagnieBox.add(cartel);
        sous_compagnies = new JLabel("sous-compagnies: ");
        compagnieBox.add(sous_compagnies);
        gisements = new JLabel("gisements: ");
        compagnieBox.add(gisements);
        dateDeb = new JLabel("date de début d'exploitation: ");
        compagnieBox.add(dateDeb);
        dateFin = new JLabel("date de fin d'exploitation: ");
        compagnieBox.add(dateFin);
        prodJour = new JLabel("production journalière: ");
        compagnieBox.add(prodJour);
  
        compagnieBox.setBorder(BorderFactory.createTitledBorder("Compagnie"));
        
        this.add(compagnieBox);
    }
}

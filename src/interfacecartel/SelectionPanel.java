/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maxime
 */
public class SelectionPanel extends JPanel{

    private JTextField txtSearch;  
    private JButton btnSearch;
    private String cas;
    
    public SelectionPanel(String p_cas)
    {
        super();
        this.cas = p_cas;
        CreateInterface();
    }
    private void CreateInterface()
    {
        ActionListener searchListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String recherche = txtSearch.getText();
                txtSearch.setText("Seach Complete");
                switch (cas) {
                    case "Gisement":
             
                        break;
                    case "Compagnie":
                        SELECT * FROM compagnie WHERE nom LIKE recherche;
                        break;
                    case "Cartel":
                        break;
                    case "default":
                        break;
               } 
            }
        };
        
        JPanel instructions = new JPanel();
        instructions.setLayout(new BorderLayout());
        
        JLabel labelInstruction = new JLabel("Erreur");
        
        switch (cas) {
         case "Gisement":
             labelInstruction.setText("Veuillez entrer le nom du gisement recherché");
             break;
         case "Compagnie":
             labelInstruction.setText("Veuillez entrer le nom de la compagnie recherchée");
             break;
         case "Cartel":
             labelInstruction.setText("Veuillez entrer le nom de la compagnie recherchée");
             break;
         case "default":
             break;
        } 
        instructions.add(labelInstruction, BorderLayout.NORTH);
        
        JPanel research = new JPanel();
        txtSearch = new JTextField();
        txtSearch.setPreferredSize( new Dimension( 200, 24 ) );
        research.add(txtSearch);
        
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(searchListener);
        research.add(btnSearch);
        
        instructions.add(research, BorderLayout.CENTER);
        this.add(instructions);
    }   
}

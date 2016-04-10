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

    private JTextField txtCompany;  
    private JButton btnSearch;
    
    public SelectionPanel()
    {
        super();
        CreateInterface();
    }
    private void CreateInterface()
    {
        ActionListener searchListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                txtCompany.setText("Seach Complete");
            }
        };
        
        JPanel instructions = new JPanel();
        instructions.setLayout(new BorderLayout());
        
        JLabel labelInstruction = new JLabel("Veuillez entrer le nom de la compagnie recherchée, son cartel ou l'un de ses gisements");
        instructions.add(labelInstruction, BorderLayout.NORTH);
        
        JPanel research = new JPanel();
        txtCompany = new JTextField();
        txtCompany.setPreferredSize( new Dimension( 200, 24 ) );
        research.add(txtCompany);
        
        btnSearch = new JButton("Search");
        btnSearch.addActionListener(searchListener);
        research.add(btnSearch);
        
        instructions.add(research, BorderLayout.CENTER);
        this.add(instructions);
    }   
}

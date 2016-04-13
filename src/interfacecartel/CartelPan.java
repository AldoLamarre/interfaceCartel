/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.*;
/**
 *
 * @author Maxime
 */
public class CartelPan extends JPanel{
    
    private SelectionPanel cartelPanel;
    private AffichageCartelPanel affCartelPan;
    
    public CartelPan()
    {
        addPanel();
    }
    
    private void addPanel()
    {
        JPanel cartel = new JPanel();
        cartel.setLayout(new GridBagLayout());
        
        String[] cartelListe = {"Liste des cartels"};
        
        Object[][] gisData = {{"Cartel1"}};
        
        final JTable tableCartel = new JTable(gisData, cartelListe);
        
        JScrollPane cartelTable = new JScrollPane(tableCartel);
        
        cartelTable.setPreferredSize( new Dimension( 300, 200) );
        this.add(cartelTable);
        
        cartelPanel = new SelectionPanel("Cartel");
        affCartelPan = new AffichageCartelPanel();
        this.add(cartelPanel);
        this.add(affCartelPan);
    }
}

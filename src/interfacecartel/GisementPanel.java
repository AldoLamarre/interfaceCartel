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
 * @author Al
 */
public class GisementPanel extends JPanel {
    
    private SelectionPanel gisementPanel;
    private AffichageGisement affGisPan;
    
    public GisementPanel() {
        addPanel();
    }
    private void addPanel()
    {
        JPanel compagnie = new JPanel();
        compagnie.setLayout(new GridBagLayout());
        
        String[] gisListe = {"Liste des gisements"};
        
        Object[][] gisData = {{"pokemonGisement"}, {"ceci"},{"est"},{"un"},{"ensemble"},{"de"},{"gisements"}
        , {"ceci"},{"est"},{"un"},{"ensemble"},{"de"},{"gisements"}
        , {"ceci"},{"est"},{"un"},{"ensemble"},{"de"},{"gisements"}};
        
        final JTable table1 = new JTable(gisData, gisListe);
        
        JScrollPane gisTable = new JScrollPane(table1);
        
        gisTable.setPreferredSize( new Dimension( 300, 200) );
        this.add(gisTable);
        
        gisementPanel = new SelectionPanel("Gisement");
        affGisPan = new AffichageGisement();
        this.add(gisementPanel);
        this.add(affGisPan);
    }
}

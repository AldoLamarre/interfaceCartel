/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import databaseConnection.MysqlConnection;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 *
 * @author Al
 */
public class CompagniePanel extends JPanel {
    private SelectionPanel selectionPanel;
    private AffichageCompagniePanel affComPan;

    public CompagniePanel()
    {
        addPanel( );
    }
    
    private void addPanel()
    {
        JPanel compagnie = new JPanel();
        compagnie.setLayout(new GridBagLayout());
        
        String[] compListe = {"Liste des compagnies"};
        
        Object[][] compData = {{"TTTESSTURHU"}, {"t837yr8t678"}};
        
        final JTable table3 = new JTable(compData, compListe);
        
        JScrollPane compTable = new JScrollPane(table3);
        
        compTable.setPreferredSize( new Dimension( 300, 200) );
        this.add(compTable);
        
        selectionPanel = new SelectionPanel("Compagnie");
        affComPan = new AffichageCompagniePanel();
        this.add(selectionPanel);
        this.add(affComPan);
    }
    
}

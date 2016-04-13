/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import databaseConnection.CustomSQLConnection;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Al
 */
public class TabPanel extends JTabbedPane {
    
    public TabPanel(CustomSQLConnection msq) {
        createtab(msq);
        this.addChangeListener(new DoClickListener());
    }
    
    private void createtab(CustomSQLConnection msq){
        HomePanel homePanel = new HomePanel(msq); 
        CompagniePanel companiePanel = new CompagniePanel(msq); 
        GisementPanel gisementPanel = new GisementPanel(msq); 
        CartelPan cartelPanel = new CartelPan(msq);
        OpenSQLPanel openSQLPanel = new OpenSQLPanel(msq);
        
        this.add("home",homePanel);
        this.add("compagnie",companiePanel);
        this.add("gisement",gisementPanel);
        this.add("cartel", cartelPanel);
        this.add("SQL", openSQLPanel);
       
    }

    private class DoClickListener implements ChangeListener {

        /*private boolean didPane0 = false;  */
        private boolean didPane1 = false;
        private boolean didPane2 = false;
        private boolean didPane3 = false;



        @Override
        public void stateChanged(ChangeEvent e) {

            JTabbedPane jTabbedPane = (JTabbedPane) e.getSource();
            switch (jTabbedPane.getSelectedIndex()){
              /*  case 0:
                    if (!didPane0){
                        HomePanel homePanel = (HomePanel) jTabbedPane.getComponentAt(0);
                        HistoriquePrixPanel historiquePrixPanel = homePanel.getHistoriquePrixPanel();
                        historiquePrixPanel.getDsc().doClick();
                        didPane0 = true;
                    }
                    break;  */
                case 1:
                    if (!didPane1){
                        CompagniePanel compagniePanel = (CompagniePanel) jTabbedPane.getComponentAt(1);
                        compagniePanel.getSelectionPanel().btnSearch.doClick();
                        didPane1 = true;
                    }
                    break;
                case 2:
                    if (!didPane2){
                        GisementPanel gisementPanel = (GisementPanel) jTabbedPane.getComponentAt(2);
                        gisementPanel.getGisementPanel().btnSearch.doClick();
                        didPane2 = true;
                    }
                    break;
                case 3:
                    if (!didPane3){
                        CartelPan cartelPan = (CartelPan) jTabbedPane.getComponentAt(3);
                        cartelPan.getCartelPanel().btnSearch.doClick();
                        didPane3 = true;
                    }
                    break;
                default:
                    break;

            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import databaseConnection.CustomSQLConnection;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Al
 */
public class CompagniePanel extends JPanel {

    private SelectionPanel selectionPanel;
    private AffichageCompagniePanel affComPan;
    CustomSQLConnection msq;
    JTable table3;

    public CompagniePanel(CustomSQLConnection msq) {
        this.msq = msq;
        addPanel();
    }

    private void addPanel() {
        JPanel compagnie = new JPanel();
        compagnie.setLayout(new GridBagLayout());

        String[] compListe = {"Liste des compagnies"};

        //Object[][] compData = {{"TTTESSTURHU"}, {"t837yr8t678"}};
        table3 = new JTable();

        JScrollPane compTable = new JScrollPane(table3);

        compTable.setPreferredSize(new Dimension(300, 200));
        this.add(compTable);

        selectionPanel = new SelectionPanel("Compagnie");
        selectionPanel.btnSearch.addActionListener(new SearchEvent());
        ListSelectionModel lMdl = table3.getSelectionModel();
        lMdl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lMdl.addListSelectionListener(new SelectEvent());
        affComPan = new AffichageCompagniePanel();
        this.add(selectionPanel);
        this.add(affComPan);
        //selectionPanel.btnSearch.doClick();
    }

    private class SearchEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JTextField jtxt = selectionPanel.getJTxt();
            String rq = "SELECT nom FROM compagnie WHERE nom like '%" + jtxt.getText() + "%';";
            table3.clearSelection();

            msq.send_request(rq, table3);

        }

    }

    private class SelectEvent implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            String s = (String) table3.getValueAt(table3.getSelectedRow(), 0);
            String reqInfo = "SELECT * FROM compagnie WHERE nom = \"" + s + "\";";
            String reqGisement = "SELECT t2.* FROM (SELECT idGisement FROM exploitationgisement WHERE nomCompagnie = \"" + s + "\") AS t1 JOIN (SELECT * FROM gisement) AS t2 ON t1.idGisement = t2.id;";
            String reqData = "SELECT * FROM compagnie WHERE maisonMere=\"" + s + "\";";

            msq.send_request(reqData, affComPan.tableCpnyData);

            msq.send_request(reqGisement, affComPan.tableCpnyGisement);

            msq.send_request(reqInfo, affComPan.tableCpnyInfo);

        }

    }

    public SelectionPanel getSelectionPanel() {
        return selectionPanel;
    }
}

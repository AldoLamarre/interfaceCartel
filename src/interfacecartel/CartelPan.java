/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import databaseConnection.MysqlConnection;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Maxime
 */
public class CartelPan extends JPanel {

    MysqlConnection msq;
    private SelectionPanel cartelPanel;
    private AffichageCartelPanel affCartelPan;
    JTable tableCartel;

    public CartelPan(MysqlConnection msq) {
        this.msq = msq;
        addPanel();
    }

    private void addPanel() {
        JPanel cartel = new JPanel();
        cartel.setLayout(new GridBagLayout());

        String[] cartelListe = {"Liste des cartels"};

        Object[][] gisData = new Object[0][0];

        tableCartel = new JTable(gisData, cartelListe);

        JScrollPane cartelTable = new JScrollPane(tableCartel);

        cartelTable.setPreferredSize(new Dimension(300, 200));
        this.add(cartelTable);

        cartelPanel = new SelectionPanel("Cartel");

        cartelPanel.btnSearch.addActionListener(new SearchEvent());
        ListSelectionModel lMdl = tableCartel.getSelectionModel();
        lMdl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lMdl.addListSelectionListener(new SelectEvent());

        affCartelPan = new AffichageCartelPanel();

        this.add(cartelPanel);
        this.add(affCartelPan);
        cartelPanel.btnSearch.doClick();

    }

    public class SearchEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JTextField jtxt = cartelPanel.getJTxt();
            String rq = "SELECT nom FROM cartel WHERE nom like '%" + jtxt.getText() + "%';";
            tableCartel.clearSelection();
            msq.send_request(rq, tableCartel);


        }

    }

    public class SelectEvent implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            String s = (String) tableCartel.getValueAt(tableCartel.getSelectedRow(), 0);
            String reqInfo = "SELECT nom FROM cartel WHERE nom = \"" + s + "\";";
            String reqGis = "SELECT * FROM (SELECT nomCartel, idGisement FROM (SELECT t2.nomCartel, t1.nom FROM compagnie AS t1 JOIN membrecartel  AS t2 ON t1.nom = t2.nomCompagnie) AS t3 JOIN exploitationgisement AS t4 ON t3.nom = t4.nomCompagnie) AS t3 JOIN gisement AS t4 ON t3.idGisement = t4.id WHERE nomCartel = \"" + s + "\"";
            String reqProdGis = "SELECT * FROM (production STRAIGHT_JOIN ("+reqGis+") as t1);";
            String reqCpny = "SELECT * FROM compagnie WHERE nom = ANY(SELECT nomCompagnie FROM membrecartel WHERE nomCartel = \"" + s + "\");";
            String reqProdCpny="SELECT SUM(capacitelimite) AS Total FROM compagnie WHERE nom = ANY(SELECT nomCompagnie FROM membrecartel WHERE nomCartel = \"" + s + "\");";
            
            msq.send_request(reqProdCpny, affCartelPan.tableProd);

            msq.send_request(reqCpny, affCartelPan.tableCies);

            msq.send_request(reqInfo, affCartelPan.tableInfo);
            
            msq.send_request(reqProdGis, affCartelPan.tableGis);

        }

    }
}

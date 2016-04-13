/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import databaseConnection.*;
import java.awt.*;
import java.awt.GridBagLayout;

/**
 *
 * @author Al
 */
public class HistoriquePrixPanel extends JPanel {

    final ButtonGroup groupTime = new ButtonGroup();

    final ButtonGroup groupPrice = new ButtonGroup();
    private JToggleButton year;
    private JToggleButton month;
    private JToggleButton day;
    /* JToggleButton hour = new JToggleButton("Hour");
    JToggleButton min = new JToggleButton("Min");
    JToggleButton sec = new JToggleButton("sec");*/
    private JToggleButton average;
    private JToggleButton last;
    private JToggleButton first;
    private JTable tbl;
    private JScrollPane tblContainer;
    private MysqlConnection msq;

    public HistoriquePrixPanel() {
        super();
        msq = new MysqlConnection();
        createbutton();
    }

    public JTable getTbl() {
        return tbl;
    }

    private void createbutton() {
        year = new JToggleButton("Year");
        month = new JToggleButton("Month");
        day = new JToggleButton("Day");
        /* JToggleButton hour = new JToggleButton("Hour");
    JToggleButton min = new JToggleButton("Min");
    JToggleButton sec = new JToggleButton("sec");*/
        average = new JToggleButton("Average");
        last = new JToggleButton("last");
        first = new JToggleButton("first");
        tbl = new JTable();
        tblContainer = new JScrollPane(tbl);
        tbl.setPreferredSize(new Dimension(1000, 300));
        msq = new MysqlConnection();
      

        grouppriceHandeler priceHandler = new grouppriceHandeler();

        groupTime.add(year);
        groupTime.add(month);
        groupTime.add(day);

        groupPrice.add(average);
        groupPrice.add(last);
        groupPrice.add(first);

        average.addActionListener(priceHandler);
        last.addActionListener(priceHandler);
        first.addActionListener(priceHandler);

        this.setLayout(new BorderLayout());

        JPanel pnlNorth = new JPanel();
        JPanel pnlNorthWest = new JPanel();
        JPanel pnlNorthEast = new JPanel();
        JPanel pnlcenter = new JPanel();

        pnlNorthWest.add(year);
        pnlNorthWest.add(month);
        pnlNorthWest.add(day);

        pnlNorthEast.add(average);
        pnlNorthEast.add(last);
        pnlNorthEast.add(first);

        pnlNorth.setLayout(new BorderLayout());
        pnlNorth.add(pnlNorthWest, BorderLayout.WEST);
        pnlNorth.add(pnlNorthEast, BorderLayout.EAST);
        this.add(pnlNorth, BorderLayout.NORTH);
        this.add(pnlcenter, BorderLayout.CENTER);
        pnlcenter.setLayout(new GridBagLayout());
        Box cartelBox = Box.createVerticalBox();
        cartelBox.setPreferredSize(new Dimension(1000, 300));
        cartelBox.add(tblContainer);
        
        tblContainer.setBorder(BorderFactory.createEmptyBorder());
        tblContainer.setViewportBorder(null);   
        
        this.add(cartelBox);
        average.doClick();

    }

    public class grouptimeHandeler implements ActionListener {
        // patch invoke later

        @Override
        public void actionPerformed(ActionEvent ae) {
            JToggleButton jtb = (JToggleButton) ae.getSource();
            HistoriquePrixPanel hpp = (HistoriquePrixPanel) jtb.getParent().getParent().getParent();

            if (jtb == year) { 
                msq.send_request("SELECT * FROM historiqueprix ", hpp.getTbl());
            } else if (jtb == month) {
                msq.send_request("SELECT * FROM historiqueprix", hpp.getTbl());
            } else if (jtb == day) {
                msq.send_request("SELECT * FROM historiqueprix", hpp.getTbl());
            }

        }

    }

    public class grouppriceHandeler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JToggleButton jtb = (JToggleButton) ae.getSource();
            HistoriquePrixPanel hpp = (HistoriquePrixPanel) jtb.getParent().getParent().getParent();

            if (jtb == average) {
                msq.send_request("SELECT * FROM historiqueprix", hpp.getTbl());
            } else if (jtb == last) {
                msq.send_request("SELECT * FROM historiqueprix", hpp.getTbl());
            } else if (jtb == first) {
                msq.send_request("SELECT * FROM historiqueprix", hpp.getTbl());
            }

        }

    }
}

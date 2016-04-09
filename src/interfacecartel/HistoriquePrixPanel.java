/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

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
    private JTextField txt;

    public HistoriquePrixPanel() {
        super();
        createbutton();
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
        txt = new JTextField();
        txt.setSize(100, 100);
        grouptimeHandeler timeHandler = new grouptimeHandeler();
        
        groupTime.add(year);
        groupTime.add(month);
        groupTime.add(day);

        groupPrice.add(average);
        groupPrice.add(last);
        groupPrice.add(first);
        
        year.addActionListener(timeHandler);
        month.addActionListener(timeHandler);
        day.addActionListener(timeHandler);
        
        
        this.add(year);
        this.add(month);
        this.add(day);
        this.add(average);
        this.add(last);
        this.add(first);
        this.add(txt);

    }

    public void dummy() {

    }

    public class grouptimeHandeler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
           JToggleButton jtb = (JToggleButton) ae.getSource() ;
            SwingUtilities.invokeLater(() -> {
                if (jtb == year) {
                    txt.setText("Year");
                } else if (jtb == month) {                    
                    txt.setText("Month");
                } else if (jtb == day) {
                    txt.setText("Day");
                }              
                JPanel jpn = (JPanel) jtb.getParent(); 
                jpn.revalidate();
           });
        }

    }
}

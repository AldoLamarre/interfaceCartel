/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import databaseConnection.CustomSQLConnection;
import javax.swing.SwingUtilities;

/**
 *
 * @author Al
 */
public class InterfaceCartel {
    public static CustomSQLConnection msq;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0){
            msq = new CustomSQLConnection();
            SwingUtilities.invokeLater(() -> {
                CartelWindow cw = new CartelWindow(msq);
                cw.setVisible(true);
            });
        }else if (args.length == 5){
            msq = new CustomSQLConnection(args[0], args[1], args[2], args[3], Integer.getInteger(args[4]));
            SwingUtilities.invokeLater(() -> {
                CartelWindow cw = new CartelWindow(msq);
                cw.setVisible(true);
            });
        }


    }

}

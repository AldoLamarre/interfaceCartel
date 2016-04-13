/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecartel;

import databaseConnection.MysqlConnection;
import javax.swing.SwingUtilities;

/**
 *
 * @author Al
 */
public class InterfaceCartel {
    public static MysqlConnection msq;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        msq = new MysqlConnection();
        SwingUtilities.invokeLater(() -> {
            CartelWindow cw = new CartelWindow(msq);
            cw.setVisible(true);
        });

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Trejos
 */
public class SizeTablero {
    
    private int sizeGame;

    public int getSizeTablero() {
        return sizeGame;
    }
    
    private void sizeTablero() {
        boolean continu = false;
        while (continu == false) {
            try {
                int size = Integer.parseInt(JOptionPane.showInputDialog("Digite el tamaño del tablero"));
                if (size < 7 || size > 12) {
                    continu = false;
                    JOptionPane.showMessageDialog(null, "Sólo se pueden digitar números entre 7 y 12");
                } else {
                    continu = true;
                    this.sizeGame=size;
                    //new Tablero(size).setVisible(true);
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor digite sólo números");
            }
        }
    }
}

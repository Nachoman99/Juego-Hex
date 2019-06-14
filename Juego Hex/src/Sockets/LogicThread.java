/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import GUI.Tablero;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Kevin Trejos
 */
public class LogicThread extends Thread{
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket connection;
    private final Tablero tablero;
    
    public LogicThread(Socket connection) {
        this.connection = connection;
        this.tablero = new Tablero(this);
        tablero.setVisible(true);
        tablero.setTitle("Jugador 1");
        
    }
}

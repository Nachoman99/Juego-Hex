/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import GUI.VentanaPrincipal;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Kevin Trejos
 */
public class Client {
    
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Socket client;
    private final String HOST = "127.0.0.1";
    private final int PORT = 12345;
    private VentanaPrincipal mainWindow;
    
    public void runClient(){
        
    }
    
    private void connectToServer() throws IOException{
        System.out.println("Attempting connection\n");
        client = new Socket(HOST, PORT);
        System.out.println("Connected to: " + client.getInetAddress().getHostName());
    }
    
    private void getStreams() throws IOException{
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();
        input = new ObjectInputStream(client.getInputStream());
    }
    
    private void processConnection(){
        
    }
    
    private void closeConnection(){
        System.out.println("\nClosing connection");
        try {
            output.close();
            input.close();
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import GUI.Tablero2;
import GUI.VentanaPrincipal;
import Logic.Hexagon;
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
    private Tablero2 tablero;
     private boolean continuar=true;
    
    public void runClient(){
//        this.mainWindow = new VentanaPrincipal();
//            principal.setVisible(true);
//            while(!Ingresar.getIniciarEspera()&&!Registro.getIniciarEspera()){
////                System.out.println("ingresar= "+Ingresar.getIniciarEspera());
////                 System.out.println("registro= "+Registro.getIniciarEspera());
//            }
        try {
            connectToServer();
            getStreams();
            while (continuar) {
                recibir();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    
     public synchronized void enviar(Hexagon hexa)throws IOException, ClassNotFoundException {
        output.writeObject(hexa);
        //output.writeBoolean(continuar);no se cooo mandarlo
    }
    
    private void recibir() throws IOException, ClassNotFoundException {
        Hexagon hexa = (Hexagon) input.readObject();
        tablero.updateButtons(hexa.getPlayer(), hexa.getLocation().getX(), hexa.getLocation().getY());
     
    }
    
    private void connectToServer() throws IOException{
        System.out.println("Attempting connection\n");
        client = new Socket(HOST, PORT);
        System.out.println("Connected to: " + client.getInetAddress().getHostName());
        tablero=new Tablero2(7,this);
        tablero.setVisible(true);
    }
    
    private void getStreams() throws IOException{
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();
        input = new ObjectInputStream(client.getInputStream());
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
    
    public static void main(String[] args) {
        new Client().runClient();
    }
}

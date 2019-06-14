package Sockets;

import GUI.Tablero;
import GUI.VentanaPrincipal;
import Logic.Hexagon;
import java.awt.Point;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin Trejos
 */
public class LogicThread extends Thread {

    private Socket connection;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Tablero tablero;
    private boolean continuar=true;
    
    public LogicThread(Socket connection) {
        this.connection = connection;
        this.tablero = new Tablero(7,this);
        this.tablero.setVisible(true);
    }

    @Override
    public void run() {
        try {
            getStreams();
            while (continuar) {
                recibir();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void getStreams() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
    }
        
    public synchronized void enviar(Hexagon hexa)throws IOException, ClassNotFoundException {
        output.writeObject(hexa);
        //output.writeBoolean(continuar);no se como mandarlo
    }
    
    private void recibir() throws IOException, ClassNotFoundException {
        Hexagon hexa = (Hexagon) input.readObject();
        tablero.updateButtons(hexa.getPlayer(), hexa.getLocation().getX(), hexa.getLocation().getY());
     
    }

    private void closeConnection() {
        System.out.println("\nClosing connection");
        try {
            output.close();
            input.close();
            connection.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

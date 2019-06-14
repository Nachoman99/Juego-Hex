package Sockets;

import GUI.VentanaPrincipal;
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
    private VentanaPrincipal mainWindow;

    public LogicThread(Socket connection) {
        this.connection = connection;
        this.mainWindow = new VentanaPrincipal();
        this.mainWindow.setVisible(true);
    }

    @Override
    public void run() {
        try {
            getStreams();
            while (mainWindow.isVisible()) {
                processConnection();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogicThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    private void getStreams() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
    }

    private void processConnection() throws IOException, ClassNotFoundException {
        Point point = (Point) input.readObject();
        
        Point pont = new Point(2, 2);
        output.writeObject(pont);
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

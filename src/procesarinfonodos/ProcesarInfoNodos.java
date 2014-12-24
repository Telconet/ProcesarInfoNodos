/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesarinfonodos;

/**
 *
 * @author DMedina
 */
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcesarInfoNodos {

    public static final int PUERTO = 5000;
    ServerSocket sc;
    Socket so;
    DataOutputStream salida;
    String mensajeRecibido;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = null;
            boolean listening = true;

            try {
                serverSocket = new ServerSocket(PUERTO);
            } catch (IOException e) {
                System.err.println("Could not listen on port: " + PUERTO);
                System.exit(-1);
            }

            while (listening) {
                new KKMultiServerThread(serverSocket.accept()).start();
            }

            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ProcesarInfoNodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

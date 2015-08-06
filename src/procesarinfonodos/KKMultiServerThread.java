/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesarinfonodos;

import java.io.*;
import java.net.*;

/**
 *
 * @author DMedina
 */
public class KKMultiServerThread extends Thread {

    private Socket socket = null;

    public KKMultiServerThread(Socket socket) {
        super("KKMultiServerThread");
        this.socket = socket;
        System.out.println("Se conecto: " + socket.getInetAddress().getHostName());
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                    socket.getInputStream()));

            String inputLine, outputLine;
            KnockKnockProtocol kkp = new KnockKnockProtocol();
            
            out.println("Inicio");

            int cont=0;
            while ((inputLine = in.readLine()) != null) {
                
                //System.out.println("IP: " + socket.getInetAddress().getHostName() + "datos: " + inputLine);
                
                outputLine = kkp.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("OK")) {
                    break;
                }else{
                    cont++;
                }
                if(cont>3){
                    break;
                }
            }
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

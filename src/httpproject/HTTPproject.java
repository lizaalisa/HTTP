/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Hina
 */
public class HTTPproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //and nobody notices anything.....
        System.out.println("You have come to the wrong club..... " + '\n' + "matety, but oh well here goes");

        try {
            ServerSocket serversocket = new ServerSocket(8888, 1);
            Socket theconnection;


            while (true) {
                
                theconnection = serversocket.accept();
                Runnable handler1 = new Handler(theconnection);
                Thread everything = new Thread(handler1);
                everything.start();
                
                
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
            System.err.println("Socket problem closed" + ex);
        } catch (IOException ex) {
            System.err.println("Connection closed" + ex);
        }

    }
}

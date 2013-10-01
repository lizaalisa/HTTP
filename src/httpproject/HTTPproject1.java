/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Artjom
 */
public class HTTPproject1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       ServerSocket welcomeSocket = new ServerSocket(WebServer.SERVER_PORT);
//       Executor
        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            Runnable threading = new Threading(connectionSocket);
            Thread t2 = new Thread(threading);
            t2.start();
        }
    }
}

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
 * @author Hina
 */
public class HTTPproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        ServerSocket welcomeSocket = new ServerSocket(WebServer.SERVER_PORT);
        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            WebServer wb = new WebServer(connectionSocket);
            Thread thread1 = new Thread(wb);
            thread1.start();
        }
        
    }
    
    
    
    //I can push
    //     - Artjom
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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
        new MyLogger();
        MyLogger.logger.log(Level.FINEST, "Server is started");
        ExecutorService pool = java.util.concurrent.Executors.newCachedThreadPool();
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            Runnable threading = new WebServer(connectionSocket);
            pool.execute(threading);
        }
        
    }
}

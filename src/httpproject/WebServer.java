/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;
import java.lang.String;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artjom
 */
public class WebServer implements Runnable {

    private static final String ROOT_CATALOG = "C:/HTTPproject";
    public static final int SERVER_PORT = 6789;
    private Socket connectionSocket;
//    private Object welcomeSocket;
    String nextline = System.lineSeparator();

    public WebServer(Socket connection) {
        connectionSocket = connection;
    }

    @Override
    public void run() {
        BufferedReader inFromClient = null;
        PrintStream outToClient = null;
        try {
            inFromClient = new BufferedReader(
                    new InputStreamReader(connectionSocket.getInputStream()));
            outToClient = new PrintStream(
                    connectionSocket.getOutputStream());
            String clientSentence = inFromClient.readLine();
            String[] splitResult = clientSentence.split(" ");
            System.out.println(splitResult[1]);


            FileInputStream file = new FileInputStream(new File(ROOT_CATALOG + splitResult[1]));


            outToClient.println("HTTP/1.0 200 OK\r\n"
                    + "\r\n");
            copy(file, outToClient);

            outToClient.flush();
            connectionSocket.close();
        } catch (FileNotFoundException fnf) {
            outToClient.println("HTTP/1.0 404 NOT FOUND" + "\r\n" + "\r\n");
        } catch (IOException ex) {
            Logger.getLogger(WebServer.class.getName()).log(Level.SEVERE, null, ex);
            
           
        }
    }

    private void copy(final FileInputStream input, final OutputStream output) throws IOException {
//        FileInputStream file = new FileInputStream(new File(ROOT_CATALOG + filename ));
        final byte[] buffer = new byte[1024];
        while (true) {
            int bytesRead = input.read(buffer);
            if (bytesRead == -1) {
                break;
            }
            output.write(buffer, 0, bytesRead);
        }
    }
}
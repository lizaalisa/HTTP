/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Appdow
 */
public class Handler implements Runnable {

    Socket connection;
    
    String nextline = System.lineSeparator();

    public Handler(Socket theconnection) {
        connection = theconnection;
    }
    

    public void run() {

        try {
            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            PrintStream outToClient = new PrintStream(
                    connection.getOutputStream());  
            String clientSentence = inFromClient.readLine();
                System.out.println("FROM CLIENT: " + nextline + clientSentence);
                String capitalizedSentence = clientSentence.toUpperCase();
                clientSentence = inFromClient.readLine();
                outToClient.println("HTTP/1.0 200 OK"+"\r\n" +"\r\n"+ );
                outToClient.flush();
                
                //And what am i suppouse to do with this!?
//                private static void copy(final InputStream input, final OutputStream output) throws IOException {
//        final byte[] buffer = new byte[1024];
//        while (true) {
//            int bytesRead = input.read(buffer);
//            if (bytesRead == -1) { break; }
//            output.write(buffer, 0, bytesRead);
//        }
//    }
                //this is just me assuming, but could it be something with making a file/filewriter
            connection.close();

        } //try
        catch (SocketException ex) {
            System.err.println("Connection closed" + ex);
        } catch (IOException ex) {
            System.err.println("Connection closed" + ex);
        }

    }
}

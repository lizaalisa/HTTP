/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;
import java.lang.String;
import java.io.FileInputStream;


/**
 *
 * @author Artjom
 */
public class WebServer {
    
    
    private static final String ROOT_CATALOG = "C:/someDirectory";
    
    private static void copy(final InputStream input, final OutputStream output) throws IOException {
        final byte[] buffer = new byte[1024];
        while (true) {
            int bytesRead = input.read(buffer);
            if (bytesRead == -1) { break; }
            output.write(buffer, 0, bytesRead);
        }
    }
}

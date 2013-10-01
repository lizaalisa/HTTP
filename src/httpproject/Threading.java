/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproject;

import java.net.Socket;

/**
 *
 * @author Artjom
 */
public class Threading implements Runnable{
private Socket connection;
    public Threading(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
       Runnable server = new WebServer(connection);
       Thread t1 = new Thread(server);
       t1.start();
    }
    
    
    
}

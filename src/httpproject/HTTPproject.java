/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproject;

/**
 *
 * @author Hina
 */
public class HTTPproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runnable server1 = new WebServer();
        Thread thread1 = new Thread(server1);
        thread1.start();
    }
}

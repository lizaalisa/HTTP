/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpproject;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Hina
 */
public class MyLogger {
     public static final Logger logger = Logger.getLogger(HTTPproject.class.getName());

    public MyLogger() throws IOException {
        FileHandler handler = new FileHandler("C:/HTTPproject/myLogger.txt");
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);
    }
}

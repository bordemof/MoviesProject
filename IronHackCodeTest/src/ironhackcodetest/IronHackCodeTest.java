/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ironhackcodetest;

import DataManager.XMLInputStream;
import GUI.MovieLibraryInterface;
import Model.Movie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author imanol
 */
public class IronHackCodeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
             MovieLibraryInterface mli = new MovieLibraryInterface();
             mli.setVisible(true);
        
       
    }
}

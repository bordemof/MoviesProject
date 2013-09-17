/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManager;

import GUI.BrowserLauncher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.jdom2.JDOMException;

/**
 *
 * @author imanol
 */
public class IMDBInfoGathering {
    
   //URI of IMD API access
   private String APIUri="http://www.deanclatworthy.com/imdb/";    
   private URL url = null;      
   private String dataurl=null;  
   private String retdata=null;  
   //Browser Launcher
   private BrowserLauncher bl = new BrowserLauncher();
   //Input Stream and Buffer
   private InputStream inStream = null;  
   private BufferedReader buffer = null;
        
	 /**
    * Search in Internet Movie Database the given movie title
    *
    * @param  A String with the movie title
    * @throws IOException if the is an error while opening or reading the
    *         buffer or an error during comunication.
    * @throws MalformedURLException an invalid structure while forming
	*		  the URI
    */
   public void searchInIMDB(String title) throws MalformedURLException{
       try {
           //Remove spaces
           title=title.trim();
           title=title.replace(" ","+"); 
           
           dataurl=APIUri+"?q="+ title + "&type=text";  
           url = new URL(dataurl);
           
           inStream = url.openStream();            
           buffer =new BufferedReader(new InputStreamReader(inStream));
          
           
           String info[];  
           //Reading data from url  
           while((retdata = buffer.readLine())!=null){  
                        
               //Movie not found control
               if(retdata.equals("error|Film not found")){  
                     break;  
                }  
                          
               //Replace of | character with # character  
               retdata=retdata.replace("|","#");  
                          
               //Split up string by # character and storing output in details array  
               info=retdata.split("#");  
                          
               //info[0] contains name of detail.title,genre ...         
               if  (info[0].toUpperCase().equals("IMDBURL")){
            	   //Launches a browser with the imdb movie url
                    bl.openURL(info[1]);
               }
                     
                             
            }    
       } catch (IOException ex) {
           System.out.println("File not found at IMDB");
       }
       
       
   }
   
    
    
}

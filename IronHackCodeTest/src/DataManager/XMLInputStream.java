package DataManager;

import Model.Movie;
import Model.Person;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author imanol
 */
public class XMLInputStream {
	
	
	 /**
     * Reads an specific XML file called movies.xml
     *
     * @return An ArrayList of all the movies readed in xml file
     * @throws IOException if the is an error while opening or reading the
     *         file, it can be caused by wrong routing or corrupted files.
     * @throws JDOMException if there is an error while parsing data.

     */
    
    public ArrayList<Movie> readFile() throws JDOMException, IOException {
        
        //Returned movie List
        ArrayList<Movie> movies = new ArrayList<Movie>();
        
        //SAXBuilder allows file parsing
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File( "src/DataManager/Movies.xml" );
        
        try{
           Document doc = builder.build(xmlFile);
           
           Element docRoot = doc.getRootElement();

           List movieList = docRoot.getChildren();
            
           for(int i = 0; i < movieList.size(); i++){
              
               Element movieElement = (Element) movieList.get(i);
               Movie movie =  new Movie();
               movie.setID(movieElement.getAttributeValue("ID"));
             
               List movieInfo = movieElement.getChildren();

               for ( int j=0; j < movieInfo.size(); j++){
                   
                   Element infoElement = (Element) movieInfo.get(j);

                   String option = String.valueOf(infoElement.getName().toUpperCase());
                   switch (option){
                       case "GENRES": 
                                      List genreList = infoElement.getChildren();

                                      for (int k=0; k< genreList.size(); k++){
                                          Element genreElement = (Element) genreList.get(k);
                                          movie.addGenre(genreElement.getValue());
                                      }
                                   
                                      break;
                       case "TAGS":  
                                      List tagList = infoElement.getChildren();
                                      
                                      for (int k=0; k< tagList.size(); k++){
                                          Element tagElement = (Element) tagList.get(k);                                         
                                          movie.addTag(tagElement.getValue());
                                      }
                                        
                                      break;
                       case "TITLE": 
                                      
                                      movie.setTitle(infoElement.getValue());
                                      break;
                       case "YEAR": 
                                      movie.setYear(infoElement.getValue());
                                      break;
                       case "DIRECTOR":
                                      Person director = new Person(infoElement.getValue());
                                      movie.addDirector(director);
                                      break;
                       case "CAST":
                                      List castList = infoElement.getChildren();
                                      
                                      for (int k=0; k< castList.size(); k++){
                                          Element castElement = (Element) castList.get(k);
                                          Person actor = new Person(castElement.getValue());
                                          movie.addActor(actor);
                                      }
                                      break;
                       case "POPULARITY":
                                      movie.setPopularity(Integer.parseInt(infoElement.getValue()));
                                      break;
                   }
                   
               }
               movies.add(movie);
           }
           
        }
        catch(JDOMException jdomex){
             System.out.println("Error while parsing the file");
        }
        return movies;
    
    }
    
}

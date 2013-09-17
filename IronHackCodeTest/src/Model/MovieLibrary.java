/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DataManager.XMLInputStream;
import GUI.MovieLibraryInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *	The movie library is a collection of movies that provides a 
 *	interface with methods that make easier outside interaction,
 *
 * @author imanol
 */
public class MovieLibrary {
    
    List<Movie> _library;
   
    //Constructor
    public MovieLibrary() {
        
        this._library = new ArrayList<Movie>();

    
    }
    /**
     *  Reads the xml file through JDOM
     *  FileOutput interface
     *  
     */
    public void loadFromXMLFile(){
        
        XMLInputStream input = new XMLInputStream();
        try {
            _library = input.readFile();
        } catch (JDOMException | IOException ex) {
            Logger.getLogger(MovieLibraryInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     *  Search all the movies in the library that have the
     *  genre given by paramater
     *  
     *  @param String with the genre searched
     *  @return A List with movies with the specific genre
     */
    public List<Movie> getMoviesByGenre(String genre){
        
        List<Movie> result = new ArrayList<Movie>();
        for (Movie m : _library){
           if (m.getGenres().toString().contains(genre))
               result.add(m);
        }
        return result;
        
    }

    /**
     *  Search all the movies in the library that have the
     *  tag given by paramater
     *  
     *  @param String with the tag searched
     *  @return A List with movies with the specific tag
     */
    public List<Movie> getMoviesByTag(String tag){
        
        List<Movie> result = new ArrayList<Movie>();
        for (Movie m : _library){
           if (m.getTags().toString().contains(tag))
               result.add(m);
        }
        return result;
        
    }
    /**
     *  Search all the movies in the library that satisfies
     *  all the data given by parameter giving priority to
     *  the tags before the genre
     *  
     *  @param String with movie title
     *  @param String with a movie actors name inside the cast
     *  @param String with a movie director name
     *  @param String with movie genre
     *  @param String with movie tags  
     *  @return A List with movies with the specific input parameters
     */
    public List<Movie> filerByTitleCastDirectorGenreTag(String tit, String act, String dir, String gen, String tag){
        
        
        List<Movie> result = new ArrayList<Movie>(_library);
     
        if(tit!=""){
           for (Movie m : _library){
                 if (!m.getTitle().toString().contains(tit))
                      result.remove(m);
           }
        }
        if(act!=""){
           for (Movie m : _library){
                 if (!m.getCast().toString().contains(act))
                     if (result.contains(m))
                                 result.remove(m);
           }
        }
         if(dir!=""){
         for (Movie m : _library){
                 if (!m.getDirection().toString().contains(dir)){                   
                     if (result.contains(m)){
                          result.remove(m);
                          
                     }
                 }              
           }
        }
         if(!tag.equals("Select a tag")){
         for (Movie m : _library){
                 if (!m.getTags().toString().contains(tag)){                   
                     if (result.contains(m)){
                          result.remove(m);
                          
                     }
                 }              
           }
        }
         if(!gen.equals("Select a Genre")){
         for (Movie m : _library){               
                 if (!m.getGenres().toString().contains(gen)){                   
                     if (result.contains(m)){
                          result.remove(m);
                          
                     }
                 }              
           }
        }
       
         
        
        return result;
    }
    /**
     *  Getter: Gets all the genres of the movie library
     *  @return A List with genres
     */
    public List<String> getGenres(){
        List<String> result = new ArrayList<String>();
        for (Movie m : _library){
            for (String g : m.getGenres())
            {
             if (!result.contains(g))
                  result.add(g);   
            }
           
        }
        return result;
    }
    /**
     *  Getter: Gets a movie with his title
     *  
     *  @param String with movie title
     *  @return The movie with the paramater title
     */
    public Movie getMovie(String title){
        Movie result = new Movie();
        
        for (Movie m : _library){
             if (title.contains(m.getTitle())){
                  result = m; 
                  break;
            }
        }
        return result;
    }
    /**
     *  Getter: Gets all the tags of the movie library
     *  @return A List with tags
     */  
    public List<String> getTags(){
        List<String> result = new ArrayList<String>();
        for (Movie m : _library){
            for (String t : m.getTags())
            {
             if (!result.contains(t))
                  result.add(t);   
            }
           
        }
        return result;
    }
    
    /**
     *  Sorts the movie library by his popularity rating
     *  
     */
    public void sortByPopularity(){
         for(int i=0; i<this._library.size(); i++)
              for(int j=0; j<_library.size()-1; j++)
                   if(_library.get(j+1).getPopularity()>_library.get(j).getPopularity()){
                         Movie aux=_library.get(j+1);
                        _library.set(j+1, _library.get(j));
                        _library.set(j, aux);
                   }
    }

    public List<Movie> getLibrary() {
        return _library;
    }
    
}

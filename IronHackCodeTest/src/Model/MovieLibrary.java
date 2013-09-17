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
 *
 * @author imanol
 */
public class MovieLibrary {
    
    List<Movie> _library;
   

    public MovieLibrary() {
        
        this._library = new ArrayList<Movie>();

    
    }
    public void loadFromXMLFile(){
        
        XMLInputStream input = new XMLInputStream();
        try {
            _library = input.readFile();
        } catch (JDOMException | IOException ex) {
            Logger.getLogger(MovieLibraryInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Movie> getMoviesByGenre(String genre){
        
        List<Movie> result = new ArrayList<Movie>();
        for (Movie m : _library){
           if (m.getGenres().toString().contains(genre))
               result.add(m);
        }
        return result;
        
    }

    
    public List<Movie> getMoviesByTag(String tag){
        
        List<Movie> result = new ArrayList<Movie>();
        for (Movie m : _library){
           if (m.getTags().toString().contains(tag))
               result.add(m);
        }
        return result;
        
    }
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

package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author imanol
 */
public class Movie {
    
    private String ID;
    private List<String> genres;
    private List<String> tags;
    private String title;
    private String year;
    private List<Person> cast;
    private List<Person> direction;
    private int popularity;

    public Movie()
    {   
         this.genres = new ArrayList<String>();
         this.tags = new ArrayList<String>();
         this.cast = new ArrayList<Person>();
         this.direction = new ArrayList<Person>();
    }
    public Movie(Movie mov){
        
        this.genres = mov.getGenres();
        this.tags = mov.getTags();
        this.title = mov.getTitle();
        this.year = mov.getYear();
        this.cast = mov.getCast();
        this.direction = mov.getDirection();
        this.popularity = mov.getPopularity();
        
    }
    
    public Movie(List<String> genres, List<String> tags, String title, String year, ArrayList<Person> cast, ArrayList<Person> direction, int popularity) {
        this.genres = new ArrayList<String>();
        this.tags = tags;
        this.title = title;
        this.year = year;
        this.cast = cast;
        this.direction = direction;
        this.popularity = popularity;
    }
    

    //Getters
    public String getID() {
        return ID;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public List<Person> getCast() {
        return cast;
    }

    public List<Person> getDirection() {
        return direction;
    }

    public int getPopularity() {
        return popularity;
    }

    public List<String> getTags() {
        return tags;
    }
   
    
    //Setters
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setCast(ArrayList<Person> cast) {
        this.cast = cast;
    }

    public void setDirection(ArrayList<Person> direction) {
        this.direction = direction;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    
    //Handlers
    public void addGenre(String genre){
        this.genres.add(genre);
    }
    public void addTag(String tag){
        this.tags.add(tag);
    }
    public void addDirector(Person director){
        this.direction.add(director);
    }
    public void addActor(Person actor){
        this.cast.add(actor);
    }
    
    
}

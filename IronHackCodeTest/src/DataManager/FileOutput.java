package DataManager;

import Model.Movie;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jdom2.JDOMException;

/**
 *
 * @author imanol
 */
public class FileOutput {
    
	 /**
     * Saves the data given by parameter to a text file
     *
     * @param  A List of movies
     * @throws IOException if the is an error while opening closing or writing the
     *         file, it can be caused by wrong routing or corrupted files.
     * 
     */
    public void savePlaylistToFile(List<Movie> movieList){

    try{
        Date date=new Date(); 
        SimpleDateFormat sdf = new SimpleDateFormat("(dd-MM-yyyy)"); 
        FileWriter fstream = new FileWriter("playlist/playlist"+sdf.format(date)+".txt");
        BufferedWriter out = new BufferedWriter(fstream);

        if (!movieList.isEmpty()){
              for (Movie mov : movieList){
                out.write(mov.getID()+":"+mov.getTitle()+"\r\n");
            }
        }
    
        //Close the output stream
        out.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error while saving the playlist file");
        }
     }
    
}

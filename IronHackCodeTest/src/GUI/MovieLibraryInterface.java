
package GUI;

import DataManager.FileOutput;
import DataManager.IMDBInfoGathering;
import Model.Movie;
import Model.MovieLibrary;
import Model.Person;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author imanol
 */
public class MovieLibraryInterface extends javax.swing.JFrame {

  
     private MovieLibrary ml = new MovieLibrary();
     private MovieLibrary _playList = new MovieLibrary();
     private DefaultTableModel tbm = new DefaultTableModel(); 
     private IMDBInfoGathering imdb = new IMDBInfoGathering();
     private FileOutput fo = new FileOutput();
     
	 /**
      *  Constructor of JFrameForm interface
      *
      */
    public MovieLibraryInterface() {
        initComponents();
        this.hideInfo();
        String data[][]={};
        String columns[] = {"Title"};
        tbm = new DefaultTableModel(data, columns);
     
        this.playlistTable.setModel(tbm);

        ml.loadFromXMLFile();       
        this.loadGenreComboBox(ml.getGenres());
        this.loadTagComboBox(ml.getTags());
        this.loadJList(ml.getLibrary());
        
        if(this._playList.getLibrary().isEmpty()){
            this.playlistTable.setVisible(false);
        }
     
    }
    /**
     *  Inserts a Movie in the frame Table
     *  
     *  @param The movie that is going to be added.
     */
    public void insertMovieInPlaylistTable(Movie mov){
        
        tbm.insertRow(this.playlistTable.getRowCount(), new Object[]{});     
        tbm.setValueAt(mov.getTitle(), this.playlistTable.getRowCount()-1, 0);
    }
    /**
     *  Fills the genres comboBox with all the data options
     *  
     *  @param The list of genres to add
     */
    public void loadGenreComboBox(List<String> genres){
        
        for (String s : genres){
      
            this.genreComboBox.addItem(s);
        }
      
    }
    /**
     *  Fills the tags comboBox with all the data options
     *  
     *  @param The list of tags to add
     */
    public void loadTagComboBox(List<String> tags){
           
        for (String t : tags){
      
            this.tagComboBox.addItem(t);
        }
    }
    /**
     *  Fills the movie JList with all the movies
     *  
     *  @param The list of movies to add
     */
    public void loadJList(List<Movie> movies){
        String[] titleList;
        titleList = new String[movies.size()];
 
        for (int i = 0; i<movies.size(); i++){
          
            titleList[i] = movies.get(i).getTitle()+" ("+movies.get(i).getYear()+")";
        }
       this.resultJList.setListData(titleList);
    }
    /**
     *  Hides the movie info labels of the Form
     *  
     */
    public void hideInfo(){
        
        this.titleInfoLabel.setVisible(false);
        this.titleInfoLabel.setVisible(false);
        this.yearInfoLabel.setVisible(false);
        this.genreInfoLabel.setVisible(false);
        this.castInfoLabel.setVisible(false);
        this.directorInfoLabel.setVisible(false);
        this.tagInfoLabel.setVisible(false);
    }
    /**
     *  Shows the movie info labels of the Form
     *  
     */
    public void showInfo(Movie mov){
        
    	//Sets the label with the movie title
        this.titleInfoLabel.setText("Title : "+mov.getTitle());
        //Sets the label with the movie year
        this.yearInfoLabel.setText(("Year : "+mov.getYear()));
        
        //Sets the label with the movie genres
        String genres = "Genres : ";
        for (String s : mov.getGenres()){
            genres += s+", ";
        }
        genres = genres.substring(0, genres.length()-2);
        genres +=".";
        this.genreInfoLabel.setText(genres);
        
        //Sets the label with direction info
        String direction = "Direction : ";
        for (Person p : mov.getDirection()){
            direction += p.getName()+", ";
        }
        direction = direction.substring(0, direction.length()-2);
        direction +=".";
        this.directorInfoLabel.setText(direction);
        
        //Sets the label with the movie cast
        String cast = "<html>Cast : <br> ";
        for (Person p : mov.getCast()){
            cast += "<p>";
            for (int i=0;i<12;i++){
                cast+="&nbsp;";
            }
            cast+=p.getName()+"</p> ";
        }
        cast = cast.substring(0, cast.length()-2);
        cast +="</html>";
        this.castInfoLabel.setText(cast);
        
        //Sets the label with the movie tags
        String tags = "Tags : ";
        for (String s : mov.getTags()){
            tags += s+", ";
        }
        tags = tags.substring(0, tags.length()-2);
        tags +=".";
        this.tagInfoLabel.setText(tags);  
        
        //Change the labels visibility
        this.titleInfoLabel.setVisible(true);
        this.yearInfoLabel.setVisible(true);
        this.genreInfoLabel.setVisible(true);
        this.castInfoLabel.setVisible(true);
        this.directorInfoLabel.setVisible(true);
        this.tagInfoLabel.setVisible(true);
    }
    /**
     *  Constructor of all the JframeForm elements and its
     *  configuration style parameters
     */
    @SuppressWarnings("all") 
    private void initComponents() {

    	//Components construction
        jScrollPane1 = new javax.swing.JScrollPane();
        resultJList = new javax.swing.JList();
        genreComboBox = new javax.swing.JComboBox();
        actorTextField = new javax.swing.JTextField();
        directorTextField = new javax.swing.JTextField();
        titleTextField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        directorLabel = new javax.swing.JLabel();
        castLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        genresLabel = new javax.swing.JLabel();
        orderByPopularityLabel = new javax.swing.JLabel();
        tagComboBox = new javax.swing.JComboBox();
        tagLabel = new javax.swing.JLabel();
        viewAllMoviesButton = new javax.swing.JButton();
        addAllToPlaylistButton = new javax.swing.JButton();
        addToPlayList = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        playlistTable = new javax.swing.JTable();
        clearPlayListButton = new javax.swing.JButton();
        titleInfoLabel = new javax.swing.JLabel();
        yearInfoLabel = new javax.swing.JLabel();
        directorInfoLabel = new javax.swing.JLabel();
        castInfoLabel = new javax.swing.JLabel();
        genreInfoLabel = new javax.swing.JLabel();
        tagInfoLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        savePlaylistButton = new javax.swing.JButton();

        //Event of System exit when window closing
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //Sets the window title
        setTitle("Iron Hack Movies Code Test");

        //Loads the Jlist with items
        resultJList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        //Adds the Jlist listener for mouse events
        resultJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultJListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(resultJList);

        genreComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a Genre" }));
        genreComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreComboBoxActionPerformed(evt);
            }
        });
        
        //Sets the text to he labels
        titleLabel.setText("Title :");

        directorLabel.setText("Director :");

        castLabel.setText("Cast :");

        searchButton.setText("Search");
        //Adds an action listener to the search Button
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        //Sets the text to he label
        genresLabel.setText("Genres :");

        orderByPopularityLabel.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        orderByPopularityLabel.setText("Order by popularity ");
        orderByPopularityLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderByPopularityLabelMouseClicked(evt);
            }
        });

        tagComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a tag" }));
        tagComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagComboBoxActionPerformed(evt);
            }
        });

        tagLabel.setText("Tags:");

        viewAllMoviesButton.setText("View all Movies");
        viewAllMoviesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllMoviesButtonActionPerformed(evt);
            }
        });

        addAllToPlaylistButton.setText("Add all to Playlist");
        addAllToPlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAllToPlaylistButtonActionPerformed(evt);
            }
        });

        addToPlayList.setText("Add to Playlist");
        addToPlayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToPlayListActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("PlayList");

        playlistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        playlistTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playlistTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(playlistTable);

        clearPlayListButton.setText("Clear PlayList");
        clearPlayListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearPlayListButtonActionPerformed(evt);
            }
        });

        titleInfoLabel.setText("Title");

        yearInfoLabel.setText("Year");

        directorInfoLabel.setText("Director");

        castInfoLabel.setText("Cast");

        genreInfoLabel.setText("Genres");

        tagInfoLabel.setText("Tags");

        jButton1.setText("Up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Down");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("IMDB");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        savePlaylistButton.setText("Save");
        savePlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePlaylistButtonActionPerformed(evt);
            }
        });

        //Configuration settings of teh layaout (Position,font,etc...)
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleLabel)
                                    .addComponent(directorLabel)
                                    .addComponent(castLabel)
                                    .addComponent(genresLabel)
                                    .addComponent(tagLabel))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tagComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(titleTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(directorTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(actorTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(viewAllMoviesButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addToPlayList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addAllToPlaylistButton, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(orderByPopularityLabel)))
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clearPlayListButton)
                        .addGap(32, 32, 32)
                        .addComponent(savePlaylistButton)
                        .addGap(199, 199, 199))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleInfoLabel)
                                    .addComponent(yearInfoLabel)
                                    .addComponent(genreInfoLabel)
                                    .addComponent(directorInfoLabel)
                                    .addComponent(castInfoLabel)
                                    .addComponent(tagInfoLabel))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(61, 61, 61))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(clearPlayListButton)
                                    .addComponent(savePlaylistButton))
                                .addGap(19, 19, 19))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(titleLabel)
                                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(directorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(directorLabel))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(actorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(castLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(genresLabel)
                                            .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tagLabel)
                                    .addComponent(tagComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(orderByPopularityLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(titleInfoLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yearInfoLabel)
                                        .addGap(10, 10, 10)
                                        .addComponent(genreInfoLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addToPlayList)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addAllToPlaylistButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(directorInfoLabel)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(castInfoLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewAllMoviesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tagInfoLabel)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }


     
    /**
     *  Sorts the Jlist movies by popularity
     *  
     *  @param Event of clicking the label
     */
    private void orderByPopularityLabelMouseClicked(java.awt.event.MouseEvent evt) {
       
        ml.sortByPopularity();
        this.loadJList(ml.getLibrary());
    }
    /**
     *  The button search, reads all the fields and comboxs parameters
     *  and search them all in the movie libary, then show the results 
     *  in the JList
     *  
     *  @param Event of clicking the button
     */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
       String filterTitle = this.titleTextField.getText();
       String filterActor = this.actorTextField.getText();
       String filterDirector = this.directorTextField.getText();
       String filterGenre = this.genreComboBox.getSelectedItem().toString();
       String filterTag = this.tagComboBox.getSelectedItem().toString();
     
       this.loadJList(ml.filerByTitleCastDirectorGenreTag(filterTitle,filterActor,filterDirector,filterGenre, filterTag ));
    }

    /**
     *  The genre ComboBox, reads all the fields and comboxs parameters
     *  and search them all in the movie libary, then show the results 
     *  in the JList
     *  
     *  @param Event when changing its selected value
     */
    private void genreComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        
      String filterTitle = this.titleTextField.getText();
      String filterActor = this.actorTextField.getText();
      String filterDirector = this.directorTextField.getText();
      String filterGenre = this.genreComboBox.getSelectedItem().toString();
      String filterTag = this.tagComboBox.getSelectedItem().toString();

      this.loadJList(ml.filerByTitleCastDirectorGenreTag(filterTitle,filterActor,filterDirector,filterGenre, filterTag ));
    }
    /**
     *  The tag ComboBox, reads all the fields and comboxs parameters
     *  and search them all in the movie libary, then show the results 
     *  in the JList
     *  
     *  @param Event when changing its selected value
     */
    private void tagComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
       
        
      String filterTitle = this.titleTextField.getText();
      String filterActor = this.actorTextField.getText();
      String filterDirector = this.directorTextField.getText();
      String filterGenre = this.genreComboBox.getSelectedItem().toString();
      String filterTag = this.tagComboBox.getSelectedItem().toString();

      this.loadJList(ml.filerByTitleCastDirectorGenreTag(filterTitle,filterActor,filterDirector,filterGenre, filterTag ));
    }

    /**
     *  The addPlayListButton, reads the selected value of the Jlist
     *  and puts it in the playlist JTable.
     *  
     *  @param Event when clicking button
     */
    private void addToPlayListActionPerformed(java.awt.event.ActionEvent evt) {
        
       if (this.resultJList.getSelectedValue()!=null){
              String selectTitle = (String) this.resultJList.getSelectedValue();
              this.playlistTable.setVisible(true);
              Movie m = new Movie(ml.getMovie(selectTitle));

              this.insertMovieInPlaylistTable(m);
       }
    
    }
    /**
     *  Loads all the movies in the library in the Jlist
     *  
     *  @param Event when clicking button
     */
    private void viewAllMoviesButtonActionPerformed(java.awt.event.ActionEvent evt) {
      
       this.loadJList(ml.getLibrary());
    }

    /**
     *  Clears all the playlist of the JTable
     *  
     *  @param Event when clicking button
     */
    private void clearPlayListButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        DefaultTableModel tbm = (DefaultTableModel)this.playlistTable.getModel();
            while(tbm.getRowCount() > 0)
            {
                tbm.removeRow(0);
            }
            this.hideInfo();
    }

    /**
     *  The addAllPlayListButton, reads all the values of the Jlist
     *  and puts them in the playlist JTable.
     *  
     *  @param Event when clicking button
     */
    private void addAllToPlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
         this.playlistTable.setVisible(true);
        for(int i =0; i<this.resultJList.getModel().getSize(); i++)
        {
            String selectTitle = this.resultJList.getModel().getElementAt(i).toString();
            Movie m = new Movie(ml.getMovie(selectTitle));
            this.insertMovieInPlaylistTable(m);
        }
    }
    /**
     *  When clicking a component of the table it shows
     *  its movie information in the labels
     *  
     *  @param Event when clicking Component
     */
    private void playlistTableMouseClicked(java.awt.event.MouseEvent evt) {
        
        int row = this.playlistTable.getSelectedRow();
        String selectTitle = this.playlistTable.getValueAt(row, 0).toString();
        Movie m = ml.getMovie(selectTitle);
        this.showInfo(m);
      
    }
    /**
     *  The up button advances the selected element
     *  one position in the table
     *  
     *  @param Event when clicking the up Button
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        
        int row = this.playlistTable.getSelectedRow();
        int size = tbm.getRowCount();
        if (row != 0 && size!=0){
            Object aux = this.playlistTable.getValueAt(row, 0);
            this.playlistTable.getModel().setValueAt(this.playlistTable.getValueAt(row-1, 0), row, 0);
            this.playlistTable.getModel().setValueAt(aux, row-1, 0);
        
        }
       
        
    }
    /**
     *  The down button postpones the selected element
     *  one position in the table
     *  
     *  @param Event when clicking the down Button
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        
        int row = this.playlistTable.getSelectedRow();
        int size = tbm.getRowCount();
        if (row != this.playlistTable.getModel().getRowCount()-1 && size != 0 ){
            Object aux = this.playlistTable.getValueAt(row, 0);
            this.playlistTable.getModel().setValueAt(this.playlistTable.getValueAt(row+1, 0), row, 0);
            this.playlistTable.getModel().setValueAt(aux, row+1, 0);
        
        }
    }
    /**
     *  When clicking one element in the JList it shows
     *  the element information in the labels.
     *  
     *  @param Event when clicking a element of the list
     */
    private void resultJListMouseClicked(java.awt.event.MouseEvent evt) {
       
         if (this.resultJList.getSelectedValue()!=null){
              String selectTitle = (String) this.resultJList.getSelectedValue();
              this.playlistTable.setVisible(true);
              Movie m = new Movie(ml.getMovie(selectTitle));
              this.showInfo(m);
          
              
       }
    }
    /**
     *  The IMDB button reads the title of the selected
     *  element of the JList and it searches it in the 
     *  InternetMovieDatabae through IMDBInfoGathering
     *  interface, if the movie is found it launches a
     *  internet web browser to the URL,in case of unrecognized
     *  title it takes a message in console.
     *  
     *  @param Event when clicking the IMDB Button
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        
          if (this.resultJList.getSelectedValue()!=null){
              String selectTitle = (String) this.resultJList.getSelectedValue();
              this.playlistTable.setVisible(true);
              Movie m = new Movie(ml.getMovie(selectTitle));
              this.showInfo(m);
              
             try {
                 this.imdb.searchInIMDB(selectTitle);
             } catch (MalformedURLException ex) {
                 Logger.getLogger(MovieLibraryInterface.class.getName()).log(Level.SEVERE, null, ex);
             }
              
       }
        
    }
    /**
     *  Saves the Jtable´s playlist values to file throuh the
     *  FileOutput interface
     *  
     *  @param Event when clicking the Save Button
     */
    private void savePlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	
        List<Movie> result = new ArrayList<Movie>();
        int rows = this.playlistTable.getModel().getRowCount();
        if (rows>0){
             for (int i = rows; i>0; i--){
                String selectTitle = (String) tbm.getValueAt(i-1, 0);
                Movie m = ml.getMovie(selectTitle);
                result.add(m);
             } 
        }
       
        
        this.fo.savePlaylistToFile(result);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch ( ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieLibraryInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovieLibraryInterface().setVisible(true);
            }
        });
    }
    //Component declaration
    private javax.swing.JTextField actorTextField;
    private javax.swing.JButton addAllToPlaylistButton;
    private javax.swing.JButton addToPlayList;
    private javax.swing.JLabel castInfoLabel;
    private javax.swing.JLabel castLabel;
    private javax.swing.JButton clearPlayListButton;
    private javax.swing.JLabel directorInfoLabel;
    private javax.swing.JLabel directorLabel;
    private javax.swing.JTextField directorTextField;
    private javax.swing.JComboBox genreComboBox;
    private javax.swing.JLabel genreInfoLabel;
    private javax.swing.JLabel genresLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel orderByPopularityLabel;
    private javax.swing.JTable playlistTable;
    private javax.swing.JList resultJList;
    private javax.swing.JButton savePlaylistButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox tagComboBox;
    private javax.swing.JLabel tagInfoLabel;
    private javax.swing.JLabel tagLabel;
    private javax.swing.JLabel titleInfoLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JButton viewAllMoviesButton;
    private javax.swing.JLabel yearInfoLabel;
    
}

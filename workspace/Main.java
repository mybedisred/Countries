/*
 * Author: Spencer Gilcrest
 * Date created: 1/6/25
 * This program creates a game to test your knowledge on 10 different countries
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main 
{

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextField input;
  
  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }

  /* loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data. You need to add the loop that reads in the country data into the array. */
  /*
   * Pre-condition: countries-data.csv has proper data for each country
   * Post-condition: reads in the data from the countries-data.csv file and fills in the countryArray with data
   */
  public void loadCountries() 
  {
    // Open the data file - do not change
    File file = new File("/workspaces/Countries/workspace/countries-data.csv");
    Scanner scan = null;
    try {
      scan = new Scanner(file);
    } catch(FileNotFoundException e) { 
        System.out.println("File not found");     
    }
    
    // Write a for loop that goes through the countryArray.
    // for(int i ....) {
    // Do the following inside the loop
    for (int i = 0; i<10; i++){
      String input = scan.nextLine();
      String[] data = input.split(",");
      System.out.println("Read in " + data[0]);
      // inside the loop, create a new Country using your constructor with 4 arguments and pass in data[0], data[1], data[2], data[3] as arguments.
     // inside the loop, set countryArray[i] to the created Country object
     Country placeholder = new Country(data[0], data[1], data[2], data[3]);
     countryArray[i] = placeholder;
    }
  }

  /* showCountry() will show the image associated with the current country. It should get the country at index from the countryArray. It should use its get method to get its image file name and use the code below to put the image in the GUI.
  * Pre-condition: countryArray has been filled in and country constructor works
  * Post-condition: Shows the image associated with the current country
  */
  public void showCountry() {
    // Get the country at index from countryArray
    Country c = countryArray[index];
    // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
    String imagefile = c.getImageFile();
    // Use the following code to create an new Image Icon and put it into the GUI
    img = new ImageIcon("/workspaces/Countries/workspace/"+imagefile);
    imageLabel.setIcon(img);
  }
  
  /* nextButton should increment index. If the index is greater than 9, reset it back to 0. Clear the outputLabel to empty string using setText, and call showCountry();*/
  /* 
   * Pre-condition: index instance variable has been created and showCountry() method functions.
   * Post-condition: Makes the next button function, which makes the next country appear on screen
   */
  public void nextButtonClick()
  {
    index++;
    if (index > 9){
      index = 0;
    }
    outputLabel.setText("");
    showCountry();
    outputLabel.setText("What is the name of this country");
  }
  
  /* reviewButton should get the country at index from the countryArray, call its toString() method and save the result, print it out with System.out.println and as an argument to outputLabel.setText( text to print out ); */
  /*
   * Pre-condition: countryArray has been filled in and the country constructor works
   * Post-condition: makes the review button function, giving you information about each country that appears.
   */
  public void reviewButtonClick()
  {
    Country c = countryArray[index];
    String rev = c.toString();
    System.out.println(rev);
    outputLabel.setText(rev); 
  }

  /* quizButton should clear the outputLabel (outputLabel.setText to empty string), get the country at index from countryArray, print out a question about it like What country is this? and/or What's this country's capital?. Get the user's answer using scan.nextLine() and check if it is equal to the country's data using its get methods and print out correct or incorrect.
  * Pre-Condition: the countryArray has been filled in and the country constructor works.
  * Post-Condition: Makes the quiz button function, allowing you to test your knowledge on info about the countries
  */ 
  public void quizButtonClick()
  {

    outputLabel.setText("");

    Country c = countryArray[index];

   
    String answer = input.getText();

    if (answer.equalsIgnoreCase(c.getName())){
      outputLabel.setText("Correct! This country is: " + c.getName());
      System.out.println("Correct! This country is: " + c.getName());
    }

    else{
      outputLabel.setText("Incorrect! This country is: " + c.getName());
      System.out.println("Incorrect! This country is: " + c.getName());
    }
    }
    
    
  




  /* Do NOT change anything below here */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        
        // create a new image icon
        img = new ImageIcon("worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);

        input = new JTextField(20);
        jFrame.add(input);


        jFrame.setVisible(true);
        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
}
  

}

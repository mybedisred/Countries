/*
 * Author: Spencer Gilcrest
 * Date Created: 1/6/25
 * This program defines the country class, allowing you to construct and retrieve information about each country object
 */
public class Country
{
  // add private instance variables for the name, capital, language, and image file.
  private String name = "";
  private String capital = "";
  private String language = "";
  private String imageFile = "";
  // add constructors
  public Country (String initName, String initCapital, String initLanguage, String initImageFile){
    name = initName;
    capital = initCapital;
    language = initLanguage;
    imageFile = initImageFile;
  }

  public Country (){
    name = "";
    capital = "";
    language = "";
    imageFile = "";
  }
  // Write accessor/get methods for each instance variable that returns it.

  public String getName(){
    return name;
  }

  public String getCapital(){
    return capital;
  }

  public String getLanguage(){
    return language;
  }

  public String getImageFile(){
    return imageFile;
  }

  // Write a toString() method that returns a concatenated String of 3 of the instance variables in a sentence like "..'s capital is .. and its primary language is ..."
  /* 
   * Pre condition: instance variables are not null
   * Post condition: returns information about country in string format
   */
 public String toString(){
  return name + "'s capital is " + capital + " and its primary language is " + language;
 }


  
}
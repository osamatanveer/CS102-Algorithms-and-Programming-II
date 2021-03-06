/**
 * This class is a subclass of the HTMLFilteredReader class and it adds new methods.
 * @author Osama Tanveer
 * @version 1.0, 5 March 2019
 */
package Lab02d;
import Lab02c.HTMLFilteredReader;
import java.util.ArrayList;

public class XHTMLFilteredReader extends HTMLFilteredReader{
  
  //properties
  private String url; //to store the URL of the website
  
  //constructor
  /**
   * Constructor for class XHTMLFilteredReader. Sets the URL name to the name input by the user and passes url parameter
   * to the parent class.
   * @param url, which is a String that is the name of the URL.
   */
  public XHTMLFilteredReader (String url) {
    super(url); //passes the parameter to the parent class
    this.url = url;
  }
  
  //methods
  /**
   * This method returns the percentage increase between the HTML file and the file without HTML codes.
   * @param no input parameters.
   * @return percentageIncrease, which is a double and is the percentage of increase.
   */
  public double calculateOverhead() {
    
    double percentageIncrease; //a variable to store the percentage increase from non html to html file
    int lengthWithoutHTML = super.getPageContents().length(); //the length of the string that contains the non-html file
    int lengthWithHTML = super.getUnfilteredPageContents().length(); //the length of the string that contains the html file
    
    percentageIncrease = ((double) (lengthWithHTML - lengthWithoutHTML) / lengthWithHTML)*100; //formula to calculate increase
    return 100 - percentageIncrease;
  }

  /**
   * This method returns the links in the HTML code.
   * @param no input parameters.
   * @return links, which is an ArrayList of String that contains all the links in the HTML code.
   */
  public ArrayList<String> getLinks() {
    
    String withHTML = super.getUnfilteredPageContents(); //to get the code with the html code
    String link = ""; //variable to store link character by character
    ArrayList<String> links = new ArrayList<String>(); //creating an arraylist to store links
    
    for (int i = 0 ; i < withHTML.length()-4 ; i++) {
      //checking if "href" occurs in the html code, as it means that the link lies after that
      if (withHTML.substring(i,i+4).equals("href")) {
        i = i + 6;
        char currentChar = withHTML.charAt(i);
        //storing the link in a variable character by character until the end of the link
        while(currentChar != '\"') {
          link += currentChar + "";
          i++;
          currentChar = withHTML.charAt(i);
        }        
        links.add(link); //adding the link to the collection
        link = ""; //for the next link        
      }
    }
    return links;
  }
}
package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.nio.*;

public class Generator
{
  public static List<String> stringToArrayList(String word)
  {
    //  Create an ArrayList with each element containing a character of the word
    List<String> wordChars = new ArrayList<String>();
    for(int i = 0; i < word.length(); i++)
    {
      wordChars.add(word.substring(i, i + 1));
    }
    return wordChars;
  }

  public static List<String> traverseDictionary(List<String> wordChars, String searchType)
  {
    List<String> foundWords = new ArrayList<String>();

    Scanner x;

    try
    {
      x = new Scanner(new File("file.txt"));

      while(x.hasNext())
      {
        System.out.println(x.next());
      }
    }
    catch(Exception e)
    {
      System.out.println("Could not find file");
    }


    /*
    // Try to get the dictionary text file
    Scanner x = null;
    try
    {
      x = new Scanner"(dictionary.txt");

      while(x.hasNext())
      {
        // Save the dictionary word on each line to a variable
        String lineWord = x.next();

        // Convert each dictionary word into an array of characters
        List<String> lineWordChars = stringToArrayList(lineWord);

        System.out.println(lineWord);
      }
    }
    catch(Exception e)
    {
      System.out.println("Could not find the dictionary file. Error code 3.");
    }
    */
    return foundWords;
  }

  private static void checkRelationship(List<String> wordChars, List<String>lineWordChars, String searchType)
  {
    List<String> mutLineWordChars = lineWordChars;

    // Check the relationship of the word differently depending on what option the user selects
    if(searchType.equalsIgnoreCase("less"))
    {

    }
    else if(searchType.equalsIgnoreCase("equal"))
    {

    }
    else if(searchType.equalsIgnoreCase("greater"))
    {

    }
    else
    {
      System.out.println("This should not occur error code 4.");
    }
  }
}

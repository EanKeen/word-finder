package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.nio.*;

public class Generator
{
  public static List<String> stringToArrayList(String query)
  {
    //  Create an ArrayList with each element containing a character of the word
    List<String> queryChars = new ArrayList<String>();
    for(int i = 0; i < query.length(); i++)
    {
      queryChars.add(query.substring(i, i + 1));
    }
    return queryChars;
  }

  public static List<String> traverseDictionary(List<String> queryChars, String searchType)
  {
    List<String> foundWords = new ArrayList<String>();

    System.out.println("this is a test");
    Scanner x = null;
    try
    {
      x = new Scanner(new File("src/dictionary.txt"));
    }
    catch(Exception e)
    {
      System.out.println("Could not find the file. Get the text file, then restart program.");
    }
    while(x.hasNext())
    {
      // For every single word, check relationship
	    checkRelationship(queryChars, stringToArrayList(x.next()), searchType);
    }
    x.close();

    return foundWords;
  }

  private static void checkRelationship(List<String> queryChars, List<String> dictChars, String searchType)
  {
    List<String> mutDictChars = dictChars;

    for(int i = 0; i < queryChars.size(); i++)
    {
      for(int j = 0; j < mutDictChars.size(); j++)
      {
        // Match every single letter of the word with every single character of every single word in the dictionary
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
  }
}

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
    // Create an ArrayList with each element containing a character of the word
    List<String> queryChars = new ArrayList<String>();
    for(int i = 0; i < query.length(); i++)
    {
      queryChars.add(query.substring(i, i + 1));
    }
    return queryChars;
  }

  public static List<String> traverseDictionary(List<String> queryChars, String searchType)
  {
    // ArrayList of all the found words that match
    List<String> foundWords = new ArrayList<String>();

    Scanner x = null;
    // Try to scan the file, if scanning was not successfull, tell the user
    try
    {
      x = new Scanner(new File("src/dictionary.txt"));

      while(x.hasNext())
      {
        // For every single word, check relationship
  	    String foundWord = checkRelationship(queryChars, x.next(), searchType);

        if(!foundWord.equalsIgnoreCase("|"))
        {
          foundWords.add(foundWord);
        }
      }
    }
    catch(Exception e)
    {
      System.out.println("Could not find the file. Get the text file, then restart program.");
    }
    x.close();

    return foundWords;
  }

  private static String checkRelationship(List<String> queryChars, String dictWord, String searchType)
  {
    // Make a copy of array of characters of each dictionary word (this is the one that will be modified)
    List<String> mutDictChars = stringToArrayList(dictWord);

    // By default, the query chars will match the dict chars
    Boolean queryCharsEqualsDictChars = true;

    // For every char in the user query
    for(int i = 0; i < queryChars.size(); i++)
    {
      // Only continue if the query char has the posibility of being, or is, equal to the dict chars
      if(queryCharsEqualsDictChars == true)
      {
        // By default, a diven query char will not be in the dictionary
        Boolean queryCharInDictChars = false;

        // Get the current char of the user query
        String queryChar = queryChars.get(i);

        // For every char in dictionary word
        for(int j = 0; j < mutDictChars.size(); j++)
        {
          // Only continue if we think that a query char will not be in the dictionary char
          if(queryCharInDictChars == false)
          {
            // Get the current char of the dict word
            String mutDictChar = mutDictChars.get(j);

            // If user query is not the same as dict char, its ok, check the next letter of dict char
            if(!queryChar.equalsIgnoreCase(mutDictChar))
            {
              //Do nothing, move onto next letter and see if its equal
              queryCharInDictChars = false;
            }
            // If user char is the same as the dictionary chat, it's a match! Remove the char from dictionary chars
            // since we don't want to count duplicates if there is more than one character of the same type
            // Make sure to set queryCharInDictChars, because the query char WAS found in the dict word (query chars)
            if(queryChar.equalsIgnoreCase(mutDictChar))
            {
              mutDictChars.remove(j);
              queryCharInDictChars = true;
              j--;
            }
          }
        }

        // What is the query char is NOT in the dict word AT ALL? What to do?
        if (queryCharInDictChars == false)
        {
          // If one query char is not in the dict chars, then query chars
          // is NOT equal to dict chars
          queryCharsEqualsDictChars = false;

          if(searchType.equalsIgnoreCase("less"))
          {
            // However, if 'less' option is true, then not each query char may be in dict chars
            queryCharsEqualsDictChars = true;
          }
        }
      }
    }

    String foundWord = "|";

    if(queryCharsEqualsDictChars == true)
    {
      if(searchType.equalsIgnoreCase("greater"))
      {
        foundWord = dictWord;
      }
      else if (searchType.equalsIgnoreCase("equal") && queryChars.size() == dictWord.length())
      {
        foundWord = dictWord;
      }
      else if (searchType.equalsIgnoreCase("less") && mutDictChars.size() == 0)
      {
        // If mutDictChars size is 0, it means that the dict word found is smaller than the user query
        // (which is what we want)
        foundWord = dictWord;
      }
    }
    return foundWord;
  }
}

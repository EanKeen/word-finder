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
	    checkRelationship(queryChars, x.next(), stringToArrayList(x.next()), searchType);
    }
    x.close();

    return foundWords;
  }

  private static void checkRelationship(List<String> queryChars, String dictWord, List<String> dictChars, String searchType)
  {
    List<String> foundWords = doThis(queryChars, dictWord, dictChars, searchType);
  }

  private static List<String> doThis(List<String> queryChars, String dictWord, List<String> dictChars, String searchType)
  {
    List<String> foundWords = new ArrayList<String>();

    //Every single character of dictionary word
    for(int i = 0; i < dictWord.length(); i++)
    {
      dictChars.add(dictWord.substring(i, i+1));
    }

    // Make a copy of dictChars that can be manipulated (and reset) for every word of the dictionary
    List<String> mutDictChars = stringToArrayList(dictWord);

    Boolean userCharsEqualsdictChars = true;
    List<String> userChars = queryChars;

    for(int i = 0; i < userChars.size(); i++) //For each character in userChars
    {
      if(userCharsEqualsdictChars == true)
      {
        Boolean userCharIndictChars = false;

        String userChar = userChars.get(i); //For each character in mutDictChars
        for(int j = 0; j < mutDictChars.size(); j++)
        {
          /*
          If the userChar is in the dictionaryChar at least once, then don't do
          anything more to dictionarChar2 elements
          */
          if(userCharIndictChars == false)
          {
            String dictionaryChar2 = mutDictChars.get(j);
            if(!userChar.equalsIgnoreCase(dictionaryChar2))
            {
              //Do nothing, move onto next letter and see if its equal
              userCharIndictChars = false;
            }
            if(userChar.equalsIgnoreCase(dictionaryChar2))
            {
              mutDictChars.remove(j);
              userCharIndictChars = true;
              j--;
            }
          }
        }


        if (userCharIndictChars == false)
        {
          /* If we cycled through all of dictionaryChar2 and one of our userChar
          is not in there, then we want to stop searching the userChars arrayList,
          then move on to the next dictionaryWord */
          userCharsEqualsdictChars = false;

          if(searchType.equalsIgnoreCase("less"))
          /*
          If 3 is selected, it doesn't matter if a character in
          userChars is not in dictChars. dictChars may only
          include some parts of userChars. (if dictChars is "apps" and
          userChars is "apples", its ok)
          */
          {
            userCharsEqualsdictChars = true;
          }
        }
      }
    }

    if(userCharsEqualsdictChars == true)
    {
      if(searchType.equalsIgnoreCase("greater"))
      {
        System.out.print(dictWord + ", ");
        foundWords.add(dictWord);
      }
      if (searchType.equalsIgnoreCase("equal"))
      {
        System.out.print(dictWord + ", ");
        foundWords.add(dictWord);
      }
      if (searchType.equalsIgnoreCase("less"))
      {
        if(mutDictChars.size() == 0)
        {
          System.out.print(dictWord + ", ");
          foundWords.add(dictWord);
        }
      }
    }
    return foundWords;
  }
}

package src;
import java.util.ArrayList;
import java.util.List;

public class Manipulate
{
  public static List<String> manipulateArray(List<String> matchingWords)
  {
    Boolean continueAsking = true;
    while(continueAsking)
    {
      String sortType = Interact.promptReply("\nHow would you like to manipulate the array of words?"
      + "\n[wordKeep]: Keep only words that exactly contain a user-inputed string"
      + "\n[wordRemove]: Remove all words that exactly contain a user-inputed string"
      + "\n[skip]: Stop modifying array"
      /*+ "[charsKeep]: Keep all words that contain all of user-inputed characters"*/
      /*+ "[charsRemove]: Remove all words that contain all of user-inputed characters"*/
      , new String[]{"wordKeep", "wordRemove", "skip"});

      if(sortType.equalsIgnoreCase("wordKeep"))
      {
        // sortQuery is words entered in by user that causes changes in array
        String sortQuery = Interact.promptReply("\nEnter in string or chars per rule chosen above.");

        matchingWords = wordKeep(matchingWords, sortQuery);
        System.out.println("\nThe following is the modified array");
        Interact.outputArrayEnglish(new String[]{}, matchingWords);
      }
      else if(sortType.equalsIgnoreCase("wordRemove"))
      {
        // sortQuery is words entered in by user that causes changes in array
        String sortQuery = Interact.promptReply("\nEnter in string or chars per rule chosen above.");

        matchingWords = wordRemove(matchingWords, sortQuery);
        System.out.println("\nThe following is the modified array");
        Interact.outputArrayEnglish(new String[]{}, matchingWords);
      }
      // Uninplemented code
      /* else if(sortType.equalsIgnoreCase("charsKeep"))
      {
        matchingWords = charsKeep(matchingWords, sortQuery);
      }
      else if(sortType.equalsIgnoreCase("charsRemove"))
      {
        matchingWords = charsRemove(matchingWords, sortQuery);
      } */
      else if(sortType.equalsIgnoreCase("skip"))
      {
        continueAsking = false;
      }
    }
    return matchingWords;
  }

  // Keep a word if it contains sortQuery word
  public static List<String> wordKeep(List<String> matchingWords, String sortQuery)
  {
    // If word does not contain sortQuery, remove it
    for(int i = 0; i < matchingWords.size(); i++)
    {
      //
      if(matchingWords.get(i).indexOf(sortQuery) == -1 )
      {
        matchingWords.remove(i);
        i--;
      }
    }
    return matchingWords;
  }
  public static List<String> wordRemove(List<String> matchingWords, String sortQuery)
  {
    // If word does contain sortQuery, remove it
    for(int i = 0; i < matchingWords.size(); i++)
    {
      //
      if(matchingWords.get(i).indexOf(sortQuery) != -1 )
      {
        matchingWords.remove(i);
        i--;
      }
    }
    return matchingWords;
  }
  /* Unimplemented Functions
  public static List<String> charsKeep(List<String> matchingWords, String sortQuery, String searchType)
  {
    List<String> newMatchingWords = new ArrayList<String>();
    for(int i = 0; i < matchingWords.size(); i++)
    {
      // Converts current word to arrayList
      List<String> = Generator.stringToArrayList(matchingWords.get(i));

      //
      String foundWord = checkRelationship(queryChars, matchingWords.get(i), searchType)
      {

      }
    }
  }
  public static List<String> charsRemove(List<String> matchingWords, String sortQuery, String searchType)
  {

  }
  */
  public static Boolean arrayListEqualSize(List<String> arrayList1, List<String> arrayList2)
  {
    if(arrayList1.size() == arrayList2.size())
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}

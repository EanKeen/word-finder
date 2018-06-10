package src;
import java.util.ArrayList;
import java.util.List;

public class Sort
{
  public static int loadingValue = 0;

  public static List<String> sortArray(List<String> matchingWords, String sortType)
  {
    // Really cool loading effect; does nothing but waste time
    System.out.print("Working");
    pause(300);
    System.out.print(".");
    pause(400);
    System.out.print(".");
    pause(500);
    System.out.println(".");
    pause(300);

    // Steps in is the length of the array if completely sorted
    int stepsIn = 0;
    Boolean isSorted = false;
    if(sortType.equalsIgnoreCase("length"))
    {
      while(!isSorted)
      {
        // For each element of array, swap two elements if not sorted by length
        for(int i = 0; i < matchingWords.size() - 1; i++)
        {
          // Of two elements, if left element length is greater than right element length, switch them
          if(matchingWords.get(i).length() > matchingWords.get(i + 1).length())
          {
            swapElements(matchingWords, i);
          }
        }

        // Test: is the array sorted by length?
        isSorted = isLengthSorted(matchingWords);

        stepsIn = lengthStepsIn(matchingWords);
        System.out.println(stepsIn + " of " + matchingWords.size() + " steps.");
      }

    }
    else if(sortType.equalsIgnoreCase("wwfLetterScore"))
    {
      while(!isSorted)
      {
        // For each element of array, swap two elements if not sorted by word with friends letter score
        for(int i = 0; i < matchingWords.size() - 1; i++)
        {
          // Of two elements, if left element has greater words with friends value than right element, then swap them
          if(wordWordsFriendsValue(matchingWords.get(i)) > wordWordsFriendsValue(matchingWords.get(i + 1)))
          {
            swapElements(matchingWords, i);
          }
        }

        // Test: is the array sorted by length?
        isSorted = isWordsFriendsValueSorted(matchingWords);

        stepsIn = wffValueStepsIn(matchingWords);
        System.out.println(stepsIn + " of " + matchingWords.size() + " steps.");

      }
    }
    else if(sortType.equalsIgnoreCase("scrabbleScore"))
    {
      while(!isSorted)
      {
        // For each element of array, swap two elements if not sorted by scrabble letter score
        for(int i = 0; i < matchingWords.size() - 1; i++)
        {
          // Of two elements, if left element has greater scrabble value than right element, then swap them
          if(wordScrabbleValue(matchingWords.get(i)) > wordScrabbleValue(matchingWords.get(i + 1)))
          {
            swapElements(matchingWords, i);
          }
        }

        // Test: is the array sorted by length?
        isSorted = isScrabbleValueSorted(matchingWords);

        stepsIn = scrabbleValueStepsIn(matchingWords);
        System.out.println(stepsIn + " of " + matchingWords.size() + " steps.");
      }
    }

    // After sorting is complete, return the sorted array
    return matchingWords;
  }

  public static int wordScrabbleValue(String word)
  {
    int total = 0;
    for(int i = 0; i < word.length(); i++)
    {
      String wordChar = word.substring(i, i + 1);
      total += letterScrabbleValue(wordChar);
    }
    return total;
  }

  public static int wordWordsFriendsValue(String word)
  {
    int total = 0;
    for(int i = 0; i < word.length(); i++)
    {
      String wordChar = word.substring(i, i + 1);
      total += letterWordsFriendsValue(wordChar);
    }
    return total;
  }

  public static int letterScrabbleValue(String letter)
  {
    if(
    letter.equalsIgnoreCase("e") ||
    letter.equalsIgnoreCase("a") ||
    letter.equalsIgnoreCase("i") ||
    letter.equalsIgnoreCase("o") ||
    letter.equalsIgnoreCase("n") ||
    letter.equalsIgnoreCase("r") ||
    letter.equalsIgnoreCase("t") ||
    letter.equalsIgnoreCase("l") ||
    letter.equalsIgnoreCase("s") ||
    letter.equalsIgnoreCase("u")
    )
    {
      return 1;
    }
    else if(
    letter.equalsIgnoreCase("d") ||
    letter.equalsIgnoreCase("g"))
    {
      return 2;
    }
    else if(
    letter.equalsIgnoreCase("b") ||
    letter.equalsIgnoreCase("c") ||
    letter.equalsIgnoreCase("m") ||
    letter.equalsIgnoreCase("p")
    )
    {
      return 3;
    }
    else if(
    letter.equalsIgnoreCase("f") ||
    letter.equalsIgnoreCase("h") ||
    letter.equalsIgnoreCase("v") ||
    letter.equalsIgnoreCase("w") ||
    letter.equalsIgnoreCase("y")
    )
    {
      return 4;
    }
    else if (
    letter.equalsIgnoreCase("k")
    )
    {
      return 5;
    }
    else if (
    letter.equalsIgnoreCase("j") ||
    letter.equalsIgnoreCase("x")
    )
    {
      return 8;
    }
    else if (
    letter.equalsIgnoreCase("q") ||
    letter.equalsIgnoreCase("z")
    )
    {
      return 10;
    }
    else
    {
      return 0;
    }
  }

  // Below two functions get the job done!
  public static int letterWordsFriendsValue(String letter)
  {
    if(
    letter.equalsIgnoreCase("e") ||
    letter.equalsIgnoreCase("a") ||
    letter.equalsIgnoreCase("i") ||
    letter.equalsIgnoreCase("o") ||
    letter.equalsIgnoreCase("t") ||
    letter.equalsIgnoreCase("r") ||
    letter.equalsIgnoreCase("s")
    )
    {
      return 1;
    }
    else if(
    letter.equalsIgnoreCase("n") ||
    letter.equalsIgnoreCase("d") ||
    letter.equalsIgnoreCase("l") ||
    letter.equalsIgnoreCase("u")
    )
    {
      return 2;
    }
    else if(
    letter.equalsIgnoreCase("h") ||
    letter.equalsIgnoreCase("g") ||
    letter.equalsIgnoreCase("y")
    )
    {
      return 3;
    }
    else if(
    letter.equalsIgnoreCase("w") ||
    letter.equalsIgnoreCase("p") ||
    letter.equalsIgnoreCase("m") ||
    letter.equalsIgnoreCase("f") ||
    letter.equalsIgnoreCase("c") ||
    letter.equalsIgnoreCase("b")
    )
    {
      return 4;
    }
    else if (
    letter.equalsIgnoreCase("v") ||
    letter.equalsIgnoreCase("k")
    )
    {
      return 5;
    }
    else if (
    letter.equalsIgnoreCase("x")
    )
    {
      return 8;
    }
    else if (
    letter.equalsIgnoreCase("z") ||
    letter.equalsIgnoreCase("q") ||
    letter.equalsIgnoreCase("j")
    )
    {
      return 10;
    }
    else
    {
      return 0;
    }
  }

// Int i is the current element that the for loop is on (this method will always be in a for loop)
  public static List<String> swapElements(List<String> arrayList, int i)
  {
    // Simple bubble 'sort' of two elements
    String temp = arrayList.get(i + 1);
    arrayList.set(i + 1, arrayList.get(i));
    arrayList.set(i, temp);

    return arrayList;
  }

  // The larger values of length must be near the right side of the array
  // Returns the length of the arrayList if sorted completely
  public static Boolean isLengthSorted(List<String> arrayList)
  {
    Boolean isSorted = true;

    for(int i = 0; i < arrayList.size() - 1; i++)
    {
      if(arrayList.get(i).length() > arrayList.get(i + 1).length())
      {
        isSorted = false;
      }
    }
    return isSorted;
  }

  public static int lengthStepsIn(List<String> arrayList)
  {
    int stepsIn = 1;
    Boolean isSorted = true;

    for(int i = 0; i < arrayList.size() - 1; i++)
    {
      if(arrayList.get(i).length() > arrayList.get(i + 1).length())
      {
        isSorted = false;
      }
      else
      {
        stepsIn++;
      }
    }
    return stepsIn;
  }

  // Returns the length of the arrayList if sorted completely
  public static Boolean isWordsFriendsValueSorted(List<String> arrayList)
  {
    Boolean isSorted = true;

    for(int i = 0; i < arrayList.size() - 1; i++)
    {
      if(wordWordsFriendsValue(arrayList.get(i)) > wordWordsFriendsValue(arrayList.get(i + 1)))
      {
        isSorted = false;
      }
    }
    return isSorted;
  }

  public static int wffValueStepsIn(List<String> arrayList)
  {
    int stepsIn = 1;
    Boolean isSorted = true;

    for(int i = 0; i < arrayList.size() - 1; i++)
    {
      if(wordWordsFriendsValue(arrayList.get(i)) > wordWordsFriendsValue(arrayList.get(i + 1)))
      {
        isSorted = false;
      }
      else
      {
        stepsIn++;
      }
    }
    return stepsIn;
  }

  // Returns the length of the arrayList if sorted completely
  public static Boolean isScrabbleValueSorted(List<String> arrayList)
  {
    Boolean isSorted = true;

    for(int i = 0; i < arrayList.size() - 1; i++)
    {
      if(wordScrabbleValue(arrayList.get(i)) > wordScrabbleValue(arrayList.get(i + 1)))
      {
        isSorted = false;
      }
    }
    return isSorted;
  }

  public static int scrabbleValueStepsIn(List<String> arrayList)
  {
    int stepsIn = 1;
    Boolean isSorted = true;

    for(int i = 0; i < arrayList.size() - 1; i++)
    {
      if(wordScrabbleValue(arrayList.get(i)) > wordScrabbleValue(arrayList.get(i + 1)))
      {
        isSorted = false;
      }
      else
      {
        stepsIn++;
      }
    }
    return stepsIn;
  }

  // Don't know how this works, but it does (convert the amount of steps used to sort array into a yes or no value: is the array sorted) The array is sorted if the steps reaches the length of the array
  public static Boolean stepsToBoolean(List<String> matchingWords, int stepsIn)
  {
    Boolean isSorted = false;

    if(stepsIn < matchingWords.size())
    {
      isSorted = true;
    }
    else if(stepsIn == matchingWords.size())
    {
      isSorted = false;
    }
    return isSorted;
  }

  public static Boolean wordFoundInArray(List<String> arrayList, String word)
  {
    Boolean isWordInside = false;
    for(int i = 0; i < arrayList.size(); i++)
    {
      if(arrayList.get(i).equalsIgnoreCase(word))
      {
        isWordInside = true;
      }
    }
    return isWordInside;
  }

  public static List<String> removeElementFromArray(List<String> arrayList, String wordToRemove)
  {
    for(int i = 0; i < arrayList.size(); i++)
    {
      if(arrayList.get(i).equalsIgnoreCase(wordToRemove))
      {
        arrayList.remove(i);
        i--;
      }
    }
    return arrayList;
  }

  // Time is in milliseconds
  public static void pause(int totalTime)
  {
    try
    {
      Thread.sleep(totalTime);
    }
    catch (InterruptedException e)
    {

    }
  }
}

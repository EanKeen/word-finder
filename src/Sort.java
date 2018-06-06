package src;
import java.util.ArrayList;
import java.util.List;

public class Sort
{
  public static int loadingValue = 0;

  public static List<String> sortArray(List<String> matchingWords, String sortType)
  {
    System.out.print("Working");

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
        artifialLoading();

        // Test: is the array sorted by length?
        // isLengthSorted actually returns an int, how much the array is sorted
        stepsIn = isLengthSorted(matchingWords);
        isSorted = stepsToBoolean(matchingWords, stepsIn);
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
          if(wordWordsFriendsValue(matchingWords.get(i)) > wordWordsFriendsValue(matchingWords.get(i)))
          {
            swapElements(matchingWords, i);
          }
        }
        artifialLoading();

        // Test: is the array sorted by length?
        // isWordsFriendsValueSorted actually returns an int, how much the array is sorted
        stepsIn = isWordsFriendsValueSorted(matchingWords);
        isSorted = stepsToBoolean(matchingWords, stepsIn);
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
          if(wordScrabbleValue(matchingWords.get(i)) > wordScrabbleValue(matchingWords.get(i)))
          {
            swapElements(matchingWords, i);
          }
        }
        artifialLoading();

        // Test: is the array sorted by length?
        // isScrabbleValueSorted actually returns an int, how much the array is sorted
        stepsIn = isScrabbleValueSorted(matchingWords);
        isSorted = stepsToBoolean(matchingWords, stepsIn);
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
  public static int isLengthSorted(List<String> arrayList)
  {
    Boolean isSorted = true;
    int stepsIn = 0;

    for(int i = 0; i < arrayList.size() - 1; i++)
    {
      if(arrayList.get(i).length() > arrayList.get(i + 1).length())
      {
        // When is sorted is true, update stepsIn with the current i value. Right before when isSorted is false, it will update stepsIn; now isSorted will no longer be true, an the list will no longer be updated once the list is not sorted
        if(isSorted = true)
        {
          stepsIn = i;
        }

        isSorted = false;
      }
    }
    return stepsIn;

  }

  // Returns the length of the arrayList if sorted completely
  public static int isWordsFriendsValueSorted(List<String> arrayList)
  {
    Boolean isSorted = true;
    int stepsIn = 0;

    for(int i = 0; i < arrayList.size() - 1; i++)
    {
      if(wordWordsFriendsValue(arrayList.get(i)) > wordWordsFriendsValue(arrayList.get(i)))
      {
        // When is sorted is true, update stepsIn with the current i value. Right before when isSorted is false, it will update stepsIn; now isSorted will no longer be true, an the list will no longer be updated once the list is not sorted
        if(isSorted = true)
        {
          stepsIn = i;
        }

        isSorted = false;
      }
    }
    return stepsIn;
  }

  // Returns the length of the arrayList if sorted completely
  public static int isScrabbleValueSorted(List<String> arrayList)
  {
    Boolean isSorted = true;
    int stepsIn = 0;

    for(int i = 0; i < arrayList.size() - 1; i++)
    {
      if(wordScrabbleValue(arrayList.get(i)) > wordScrabbleValue(arrayList.get(i)))
      {
        // When is sorted is true, update stepsIn with the current i value. Right before when isSorted is false, it will update stepsIn; once this occurs isSorted will no longer be true, and the list will no longer be updated once the list is not sorted
        if(isSorted = true)
        {
          stepsIn = i;
        }

        isSorted = false;
      }
    }
    return stepsIn;
  }

  public static void artifialLoading()
  {
    loadingValue++;

    // If the loading value is every divisible by 750, print out a .
    if(loadingValue % 750 == 0)
    {
      //System.out.print(".");
    }
  }

  // Don't know how this works, but it does
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

  /*public static void getSteps(List<String> arrayList, stepsIn)
  {
    System.out.println( " of " + arrayList.size() + " steps.");
  }*/
  public static List<String> removeStringFromArray(List<String> arrayList, String elementToFind)
  {
    for(int i = 0; i < arrayList.size(); i++)
    {
      if(arrayList.get(i).equalsIgnoreCase(elementToFind))
      {
        arrayList.remove(i);
        i--;
      }
    }
    return arrayList;
  }
}

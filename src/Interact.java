package src;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Interact
{
  // Creating key variables
  static String[] notAlphabetCharacters = new String[] {"`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "~", "!", "@",
  "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "{", "}", "[", "]", ";", ":",
  "\'", "\"", ",", ".", "<", ">", "?", "/", "\\", "|", " "};

  static String[] notAlphabetCharactersForGame = new String[] {"`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "=", "~", "!", "@",
  "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "{", "}", "[", "]", ";", ":",
  "\'", "\"", ",", ".", "<", ">", "?", "/", "\\", "|", " "};

  /* Declaring a list with predetermined elements
  static List<String> notAlphabetCharacters2 = asList("`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "~", "!", "@",
  "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "{", "}", "[", "]", ";", ":",
  "\'", "\"", ",", ".", "<", ">", "?", "/", "\\", "|", " ");
  */

  // User chooses a pre-selected option
  public static String promptReply(String message, String[] options)
  {
    // Declare variables to be used
    String input = "";
    Boolean isValid;

    // Format option (use when returning all options to user)
    String[] mutOptions = new String[options.length];
    for(int i = 0; i < options.length; i++)
    {
      mutOptions[i] = "[" + options[i] + "]";
    }

    // Ouput prompt for the input
    System.out.println(message);

    // Is the input valid?
    isValid = false;
    while (!isValid)
    {
      // Setting up scanner
      Scanner scan = new Scanner(System.in);
      input = scan.nextLine();

      // Is the input an option?
      for(int i = 0 ; i < options.length; i++)
      {
        // If input equals at least one of the options, then it is a valid input. If not, then must prompt user again (stay in while loop)
        if(input.equalsIgnoreCase(options[i]))
        {
          isValid = true;
        }
      }

      // If input not valid, tell user
      if(isValid == false)
      {
        System.out.println("\nInput not valid. Choose one of the following: ");
        Interact.outputArrayEnglish(mutOptions, new ArrayList<String>());
      }
    }
    //scan.close();
    System.out.println("You chose [" + input + "]");
    return input;
  }

  // User inputs any option / parameter that is made of words in alphabet
  public static String promptReply(String message, int arrayType)
  {
    String[] invalidArrayCharacters = {};

    if(arrayType == 0)
    {
      invalidArrayCharacters = notAlphabetCharacters;
    }
    else if(arrayType == 1)
    {
      invalidArrayCharacters = notAlphabetCharactersForGame;
    }

    // Create variables
    Scanner scan;
    String input = "";
    Boolean isValid;

    System.out.println(message);

    // Is the input valid? (to be valid, must include alphabet characters, and not be a length of zero)
    isValid = false;
    while(!isValid)
    {
      // Getting the input
      scan = new Scanner(System.in);
      input = scan.nextLine();

      // Creates array of all invalidLiterals that exist in the user-inputed string (invalid characters determined by third paramter of function at the top of this method)
      List<String> symbolsDetected = Interact.detectInvalidLiteral(input, invalidArrayCharacters);

      // Formats array that holds all of the invalid literals that exist in the user-inputed string
      for(int i = 0; i < symbolsDetected.size(); i++)
      {
        symbolsDetected.set(i, "'" + symbolsDetected.get(i) + "'");
      }
      // If input does not include invalid characters, then it is valid
      if(symbolsDetected.size() == 0 && input.length() != 0)
      {
        isValid = true;
        System.out.println("You entered [" + input + "]");
      }
      else if(symbolsDetected.size() != 0)
      {
        System.out.println("\nInput not valid. Remove the following characters:");
        outputArrayEnglish(new String[]{}, symbolsDetected);

        // String is not valid, must prompt for input again
      }
      else if(input.length() == 0)
      {
        // Since input has no length, do not need an extra line space on console output
        System.out.println("Input not valid. Input must include some characters.");
      }
    }
    return input;
  }

  // Tests if input contains any number of invalid characters. If so, return the array of all invalid characters included. Invalid characters could be invalid string literals
  private static List<String> detectInvalidLiteral(String input, String[] pInvalidLiterals)
  {
    List<String> symbolsDetected = new ArrayList<String>();
    // Return array of all symbols that is inside of String input. If no symbols exist, return an empty array
    for(String symbol : pInvalidLiterals)
    {
      if(input.indexOf(symbol) != - 1)
      {
        // Symbol is in input string
        symbolsDetected.add(symbol);
      }
    }
    return symbolsDetected;
  }

  // Print out each of the options that are available to the user (print differently depending on the number of options)
  // Either print an array or an ArrayList
  public static void outputArrayEnglish(String[] array, List<String> arrayList)
  {
    if(array.length != 0)
    {
    // Having one option to choose from is rare, but may occur later
      if(array.length == 1)
      {
        System.out.println(array[0]);
      }
      // Having two options, include no commas, only an "and" statement
      else if(array.length == 2)
      {
        System.out.println(array[0] + " and " + array[1]);
      }
      // Having anything else than 1 or two options, add commas until the last element. On second to last element, add a comma with an "and"
      else
      {
        for(int i = 0; i < array.length; i++)
        {
          // If element is not last or second to last then ouput option and comma
          if(i + 1 < array.length - 1)
          {
            System.out.print(array[i] + ", ");
          }
          else if(i + 1 == array.length - 1)
          {
            System.out.print(array[i] + ", and ");
          }
          else if(i + 1 == array.length)
          {
            System.out.println(array[i]);
          }
        }
      }
    }
    else if(array.length == 0)
    {
      // Having one option to choose from is rare, but may occur later
      if(arrayList.size() == 1)
      {
        System.out.println(arrayList.get(0));
      }
      // Having two options, include no commas, only an "and" statement
      else if(arrayList.size() == 2)
      {
        System.out.println(arrayList.get(0) + " and " + arrayList.get(1));
      }
      // Having anything else than 1 or two options, add commas until the last element. On second to last element, add a comma with an "and"
      else
      {
        for(int i = 0; i < arrayList.size(); i++)
        {
          // If element is not last or second to last then ouput option and comma
          if(i + 1 < arrayList.size() - 1)
          {
            System.out.print(arrayList.get(i) + ", ");
          }
          else if(i + 1 == arrayList.size() - 1)
          {
            System.out.print(arrayList.get(i) + ", and ");
          }
          else if(i + 1 == arrayList.size())
          {
            System.out.println(arrayList.get(i));
          }
        }
      }
    }
  }

  public static List<String> addToArraySide(List<String> arrayList, String leftElement, String rightElement)
  {
    for(int i = 0; i < arrayList.size(); i++)
    {
      arrayList.set(i, leftElement + arrayList.get(i) + rightElement);
    }

    return arrayList;
  }

  public static void playSound(String file)

  {
    // startOrStop is 1 if want to start file, 0 if want to stop play

    File sound = new File("assets/" + file + ".wav");

    try
    {
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(sound));
      clip.start();
    }
    catch(Exception e)
    {

    }
  }
}

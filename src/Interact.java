package src;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Interact
{
  // Creating key variables
  static String[] notAlphabetCharacters = new String[] {"`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "~", "!", "@",
                                                 "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "{", "}", "[", "]", ";", ":",
                                                 "\'", "\"", ",", ".", "<", ">", "?", "/", "\\", "|", " "};

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
  public static String promptReply(String message)
  {
    // Create variables
    Scanner scan;
    String input = "";
    Boolean isValid;

    System.out.println(message);

    // Is the input valid? (to be valid, must include alphabet characters)
    isValid = false;
    while(!isValid)
    {
      // Is the input valid?
      scan = new Scanner(System.in);
      input = scan.nextLine();

      // Creates array of all invalidLiterals that exist in the user-inputed string (invalid characters determined by notAlphabetCharacters array at the top of this class)
      ArrayList<String> symbolsDetected = Interact.detectInvalidLiteral(input, notAlphabetCharacters);

      for(int i = 0; i < symbolsDetected.size(); i++)
      {
        symbolsDetected.set(i, "'" + symbolsDetected.get(i) + "'");
      }
      // If input does not include invalid characters, then it is valid
      if(symbolsDetected.size() == 0)
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
    }
    return input;
  }

  // Tests if input contains any number of invalid characters. If so, return the array of all invalid characters included. Invalid characters could be invalid string literals
  private static ArrayList<String> detectInvalidLiteral(String input, String[] pInvalidLiterals)
  {
    ArrayList<String> symbolsDetected = new ArrayList<String>();
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
  private static void outputArrayEnglish(String[] array, ArrayList<String> arrayList)
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
}

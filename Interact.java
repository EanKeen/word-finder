import java.util.Scanner;

public class Interact
{
  // Interact class interacts with the user
  public static String promptString(String message, String[] options)
  {
    // Declare variables to be used
    Boolean isValid;
    String input;
    Scanner scan;

    // Format option (use when returning all options to user)
    String[] mutOptions = new String[options.length];
    for(int i = 0; i < options.length; i++)
    {
      mutOptions[i] = "(" + options[i] + ")";
    }

    // Ouput prompt for the input
    System.out.println(message);

    // Is the input valid?
    isValid = false;
    while (!isValid)
    {
      // Setting up scanner
      scan = new Scanner(System.in);
      input = scan.nextLine;

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
        System.out.println("Input not valid. Choose one of the following: ");

        // Print out each of the options that are available to the user (print differently depending on the number of options)

        // Having one option to choose from is rare, but may occur later
        if(mutOptions.length == 1)
        {
          System.out.println(mutOptions[0]);
        }
        // Having two options, include no commas, only an "and" statement
        else if(mutOptions.length == 2)
        {
          System.out.println(mutOptions[0] + " and " + mutOptions[1]);
        }
        // Having anything else than 1 or two options, add commas until the last element. On second to last element, add a comma with an "and"
        else
        {
          for(int i = 0; i < mutOptions.length; i++)
          {
            // If element is not last or second to last then ouput option and comma
            if(i + 1 < mutOptions.length - 1)
            {
              System.out.print(mutOptions[i] + ", ");
            }
            else if(i + 1 == mutOptions.length - 1)
            {
              System.out.println(mutOptions[i] + ", and ");
            }
            else if(i + 1 == mutOptions.length)
            {
              System.out.println(mutOptions[i]);
            }
          }
        }
      }
    }
    scan.close();
    return input;
  }
}

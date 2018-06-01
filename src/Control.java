package src;
public class Control {
  public static void main(String[] args) {
    System.out.print("\n\n");
    System.out.println("Welcome to the word-finder Java program! This program serves two purposes. It returns an array of words related to an inputed word or string. Also, users can enter in a word, and guess the possible relationships to that word. The specific relationship is defined by the user on launch of the program. The former serves the utility function. the latter serves the game function.");
    // Ask if the user wants to play the game or utilize the utility

    String mainFunctionInput = "";
    mainFunctionInput = Interact.promptReply("Would you like to launch the utility function or the game function? This option can only be choosen on program startup. (utility / game)", new String[]{"utility", "game"});

    // Tell the user the chosen option
    System.out.println("You chose [" + mainFunctionInput + "]");

    if(mainFunctionInput.equalsIgnoreCase("utility"))
    {
      // Filtertype returns the
      String primaryFilterInput = "";
      primaryFilterInput = Interact.promptReply("\nWhich word search tool would you like to utilitze? This can only be chosen once per run of the program. (less / equal / greater) \n"
      + "[Less]: Find words that contain only the characters of the inputed string (similar to finding words from tiles in a multiplayer crossword game)\n"
      + "Ex. 'apple' -> ['app', 'pal'] (NOT 'pans' because no 's' in 'apple')\n \n"

      + "[Equal]: Find words that contain the exact same characters as the inputed string\n"
      + "Ex. 'apple' -> ['appel'] \n \n"

      + "[Greater]: Find words longer than the inputed string that contain all the characters of the inputed string\n"
      + "Ex. 'apple' -> ['applesause', 'apples']"
      , new String[]{"less", "equal", "greater"});

      if(primaryFilterInput.equalsIgnoreCase("less"))
      {
        System.out.println("You chose less");
      }
      else if(primaryFilterInput.equalsIgnoreCase("equal"))
      {
        System.out.println("You chose equal");
      }
      else if(primaryFilterInput.equalsIgnoreCase("greater"))
      {
        System.out.println("You chose greater");
      }
      else
      {
        System.out.println("Something went wrong. Error code 2.");
      }

    }
    else if(mainFunctionInput.equalsIgnoreCase("game"))
    {
      // This is the main game to be played
    }
    else
    {
      System.out.println("Something went wrong. Error code 1.");
    }
  }
}

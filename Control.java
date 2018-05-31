public class Control {
  public static void main(String[] args) {
    System.out.println("Welcome to the word-finder Java program! This program serves two purposes. It returns an array of words related to an inputed word or string. Also, users can enter in a word, and guess the possible relationships to that word. The specific relationship is defined by the user on launch of the program. The former serves the utility function. the latter serves the game function.");
    // Ask if the user wants to play the game or utilize the utility

    String input = "";
    input = Interact.promptString("Would you like to launch the utility function or the game function? This option can only be choosen on program startup. (utility / game)", new String[]{"utility", "game"});

    // Tell the user the chosen option
    System.out.println("You chose [" + input + "]");

    if(input.equalsIgnoreCase("utility"))
    {
      String filterType = "";
      filterType = Interact.promptString("Which word search tool would you like to utilitze? This can only be chosen once per run of the program. (less // equal // greater) \n"
      + "Less: Find words that contain contain some of the characters (and number of each character) of the inputed string \n "
      + "Ex. I: /'apple/' -> O: [/'app/', /'pal/'] (NOT /'pans/' because no /'s/' in /'apple/')\n \n"

      + "Equal: Find words that contain exactly the characters (and the number of each character) of the inputed string \n"
      + "Ex. I: /'apple/' -> O: [/'appel/'] \n \n"

      + "Greater: Find words that contain all the characters (and number of each character) of the inputed string \n"
      + "Ex. I: /'apple/' -> O: [/'applesause/', /'apples/'] \n \n "
      , new String[]{"less, equal, greater"});

      String inputedString = Interact.filterString(inputedString);
      if(filterType.equalsIgnoreCase("less"))
      {
        Generator.less();
      }
      else if(filterType.equalsIgnoreCase("equal"))
      {

      }
      else if(filterType.equalsIgnoreCase("greater"))
      {

      }
      else
      {
        System.out.println("Something went wrong. Error code 2.");
      }

    }
    else if(input.equalsIgnoreCase("game"))
    {
      // This is the main game to be played
    }
    else
    {
      System.out.println("Something went wrong. Error code 1.");
    }
  }
}

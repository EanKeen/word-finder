public class Control {
  public static void main(String[] args) {
    System.out.println("Welcome to the word-finder Java program! This program serves two purposes. It returns an array of words related to an inputed word or string. Also, users can enter in a word, and guess the possible relationships to that word. The specific relationship is defined by the user on launch of the program. The former serves the utility function. the latter serves the game function.");
    // Ask if the user wants to play the game or utilize the utility
    Interact.promptString("Would you like to launch the utility function or the game function? This option can only be choosen on program startup. (utility / game)", new String[]{"utility", "game"});
  }
}

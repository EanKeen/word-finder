package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.nio.*;

public class Control
{
  public static void main(String[] args)
  {
    System.out.println("\n\nWelcome to the word-finder Java program! This program serves two purposes. It returns an array of words related to an inputed word or string. Also, users can enter in a word, and guess the possible relationships to that word. The specific relationship is defined by the user on launch of the program. The former serves the utility function. the latter serves the game function.");

    // Ask if the user wants to play the game or utilize the utility
    String mainFunctionInput = Interact.promptReply("Would you like to launch the utility function or the game function? This option can only be choosen on program startup. (utility / game)", new String[]{"utility", "game"});

    // Both utility and game function will prompt which search tool to use
    String searchType = Interact.promptReply("\nWhich word search tool would you like to utilitze? This can only be chosen once per run of the program. (less / equal / greater) \n"
    + "[Less]: Find words that contain only the characters of the inputed string (similar to finding words from tiles in a multiplayer crossword game)\n"
    + "Ex. 'apple' -> ['app', 'pal'] (NOT 'pans' because no 's' in 'apple').\n \n"

    + "[Equal]: Find words that contain the exact same characters as the inputed string.\n"
    + "Ex. 'apple' -> ['appel'] \n \n"

    + "[Greater]: Find words longer than the inputed string that contain all the characters of the inputed string.\n"
    + "Ex. 'apple' -> ['applesause', 'apples']"
    , new String[]{"less", "equal", "greater"});

    if(mainFunctionInput.equalsIgnoreCase("utility"))
    {

      String word = Interact.promptReply("\nPlease enter an alphanumeric string you want to analyze");

      List<String> matchingWords = Generator.traverseDictionary(Generator.stringToArrayList(word), searchType);

    }
    else if(mainFunctionInput.equalsIgnoreCase("game"))
    {
      String word = Interact.promptReply("\nPlease enter an alphanumeric string you want to analyze");


      // This is the main game to be played
      List<String> matchingWords = Generator.traverseDictionary(Generator.stringToArrayList(word), searchType);

    }
    else
    {
      System.out.println("Something went wrong. Error code 1.");
    }
  }
}

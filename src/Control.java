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
    + "Ex. 'apple' -> ['app', 'pal'] (NOT 'pans' because no 's' in 'apple').\n"

    + "[Equal]: Find words that contain the exact same characters as the inputed string.\n"
    + "Ex. 'apple' -> ['appel'] \n"

    + "[Greater]: Find words longer than the inputed string that contain all the characters of the inputed string.\n"
    + "Ex. 'apple' -> ['applesause', 'apples']"
    , new String[]{"less", "equal", "greater"});

    // Ask the user which dictionary to use (less words or more words)
    String dictionaryType = Interact.promptReply("\nWhat size dictionary do you want to use? (small / medium / large)", new String[]{"small", "medium", "large"});

    // Obtain the search query by user. Variable 'word' will convert to arrayList, and be defined as queryChars in Generator class
    String word = Interact.promptReply("\nPlease enter a string you want to analyze", 0);

    if(mainFunctionInput.equalsIgnoreCase("utility"))
    {
      // Gets the dictionary words the user wants
      List<String> matchingWords = Generator.traverseDictionary(Generator.stringToArrayList(word), searchType, dictionaryType, true);

      // Outputs the dictionary words the user chose
      System.out.println("\nThe following are words that match your query");

      // Prints array (not real time, prints after generation, disabled for now)
      //Interact.outputArrayEnglish(new String[]{}, matchingWords);

      // Manipulates the array by deleting or only allowing certain strings from array elements
      matchingWords = Manipulate.manipulateArray(matchingWords);

      String sortType = Interact.promptReply("\nHow would you like to sort the array? (length, wwfLetterScore, scrabbleScore)", new String[]{"length", "wwfLetterScore", "scrabbleScore"});

      matchingWords = Sort.sortArray(matchingWords, sortType);

      System.out.println("\n\nThe following is the sorted array");
      Interact.outputArrayEnglish(new String[]{}, matchingWords);


    }
    else if(mainFunctionInput.equalsIgnoreCase("game"))
    {
      Boolean gameOver = false;

      // totalPlayers is a string denoting the total players
      String totalPlayers = Interact.promptReply("\nHow many players are there?", new String[]{"1", "2", "3", "4"});

      // Continue to ask for player names until there are no duplicates

      List<Player> players = new ArrayList<Player>();
      Boolean areDuplicates = true;
      while(areDuplicates)
      {
        // Gets the total playernames with '-'; returns an empty array if one player is playing
        players = Game.getPlayers(totalPlayers);

        // Test if there are any duplicate initials in 'players' array
        areDuplicates = Game.arePlayerNameDuplicates(players);
      }

      // Gets the dictionary words the user wants

      List<String> wordChars = Generator.stringToArrayList(word);
      
      List<String> matchingWords = Generator.traverseDictionary(wordChars, searchType, dictionaryType, false);


      int totalMatches = 0;
      // Now want to guess the dictionary words, each one of them, while the game is not over
      while(!gameOver)
      {
        // Guess a word in array
        String guessWithHyphen = Interact.promptReply("\nGuess a word that matches the search tool you selected.", 1);

        // Test if guess includes a playername; if so, will remove word from array and add a point to the player
        Game.analyzeGuess(matchingWords, guessWithHyphen, players);

        /*if( Manipulate.arrayListEqualSize(mutMatchingWords, matchingWords) )
        {
          // Arrays are equal, word not found
          Game.wordNotFound();
        }
        else
        {
          // Arrays are not equal, word found
          Game.wordFound();
        }

        if(mutMatchingWords.size() == 0)
        {
          // All words found; game over
          Game.gameOver();
          gameOver = true;
        }*/
      }
    }
  }
}

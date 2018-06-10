package src;
import java.util.ArrayList;
import java.util.List;

public class Game
{
  public static List<Player> getPlayers(String totalPlayers)
  {
    List<Player> players = new ArrayList<Player>();

    // Warning

    if(totalPlayers.equalsIgnoreCase("2") || totalPlayers.equalsIgnoreCase("3") || totalPlayers.equalsIgnoreCase("4"))
    {
      System.out.println("\nWhen inputing player initials, use a maximum of two. Ex. For name 'Joe Biden', enter 'j'; enter word guess as 'word-j'");
    }

    // If there are more than 1 players, give each player a name
    // Recall that promptReply(String stringName) returns the string that was entered in, if it does not include sylabls
    if(totalPlayers.equalsIgnoreCase("1"))
    {
      Player p1 = new Player("P1");

      players.add(p1);
    }
    if(totalPlayers.equalsIgnoreCase("2"))
    {
      String playerName1 = Interact.promptReply("\nFirst Player Initials?", 0);
      String playerName2 = Interact.promptReply("\nSecond Player Initials?", 0);

      Player p1 = new Player(playerName1);
      Player p2 = new Player(playerName2);

      players.add(p1);
      players.add(p2);
    }
    else if(totalPlayers.equalsIgnoreCase("3"))
    {
      String playerName1 = Interact.promptReply("\nFirst Player Initials?", 0);
      String playerName2 = Interact.promptReply("\nSecond Player Initials?", 0);
      String playerName3 = Interact.promptReply("\nThird Player Initials?", 0);

      Player p1 = new Player(playerName1);
      Player p2 = new Player(playerName2);
      Player p3 = new Player(playerName3);

      players.add(p1);
      players.add(p2);
      players.add(p3);
    }
    else if(totalPlayers.equalsIgnoreCase("4"))
    {
      String playerName1 = Interact.promptReply("\nFirst Player Initials?", 0);
      String playerName2 = Interact.promptReply("\nSecond Player Initials?", 0);
      String playerName3 = Interact.promptReply("\nThird Player Initials?", 0);
      String playerName4 = Interact.promptReply("\nFourth Player Initials?", 0);

      Player p1 = new Player(playerName1);
      Player p2 = new Player(playerName2);
      Player p3 = new Player(playerName3);
      Player p4 = new Player(playerName4);

      players.add(p1);
      players.add(p2);
      players.add(p3);
      players.add(p4);
    }

    return players;
  }

  public static void analyzeGuess(List<String> matchingWords, List<String> matchingWordsOriginal, String guessWithHyphen, List<Player> players, String word)
  {
    if(guessWithHyphen.equals("--"))
    {
      displayScore(players);
    }
    else if(guessWithHyphen.equals("-"))
    {
      System.out.println("Inputed string: '" + word + "'.");
    }
    else
    {
      // If the guess contains a player name, assign the player name to the Player 'player'
      // If the guess syntax was not entered properly, output to consle an error (player is an object with empty parameters)
      Player player = getPlayerThatGuessed(guessWithHyphen, players);

      // Only continue to analyze guessWithHyphen if an actual player guessed it
      if(player.getPlayerInitial().length() != 0)
      {
        // Actual word the player guessed (without the hyphen)
        String guess = getPlayerGuess(guessWithHyphen);

        // If the input is formated correctly, test if the word exists in the array
        doesWordExist(matchingWords, matchingWordsOriginal, guess, player);

      }
    }
  }

  public static void doesWordExist(List<String> matchingWords, List<String> matchingWordsOriginal, String guess, Player player)
  {
    // Remove value from array; if element was not in array; there is no difference in lengths of the arrays
    Boolean wordFoundInOriginal = Sort.wordFoundInArray(matchingWordsOriginal, guess);
    Boolean wordFoundInModified = Sort.wordFoundInArray(matchingWords, guess);

    matchingWords = Sort.removeElementFromArray(matchingWords, guess);

    if(wordFoundInOriginal == false && wordFoundInModified == false)
    {
      // Word not found at all
      wordNotFound(player.getPlayerInitial(), guess, player);
    }
    else if(wordFoundInOriginal == true && wordFoundInModified == false)
    {
      // Word found in original, but not the modified one (because word was already found)
      wordAlreadyFound(player.getPlayerInitial(), guess, player);
    }
    else if(wordFoundInOriginal == true && wordFoundInModified == true)
    {
      // Word found in both, which means it exists and has not been already chosen
      wordFound(player.getPlayerInitial(), guess, player);
    }
  }
  public static void analyzeGuessSingle(List<String> matchingWords, List<String> matchingWordsOriginal, String guessWithHyphen, List<Player> players, String word)
  {
    if(guessWithHyphen.equals("--"))
    {
      displayScore(players);
    }
    else if(guessWithHyphen.equals("-"))
    {
      System.out.println("Inputed string: '" + word + "'.");
    }
    // If guess contains a hyphen and is not "--" or "-", is is an invelid query"
    else if(guessWithHyphen.indexOf("-") != -1)
    {
      System.out.println("Do not use a hyphen in your answer unless you are checking score or inputed string");
    }
    else
    {
      // Word should only contain characters by this point (which is why we can use guessWithHyphen); players.get(0) works because with one player, there is one element of players list.
      doesWordExist(matchingWords, matchingWordsOriginal, guessWithHyphen, players.get(0));
    }
  }

  public static Player getPlayerThatGuessed(String guessWithHyphen, List<Player> players)
  {
    int hyphenIndex = guessWithHyphen.indexOf("-");

    // Only continue if a hyphen was found in the guess
    if(hyphenIndex != -1)
    {
      String initialThatGuessed = guessWithHyphen.substring(hyphenIndex + 1);

      // Only continue if the initial (defined as all characters after the hyphen) has a length of greater than 0
      if(initialThatGuessed.length() != 0)
      {
        // Returns player that entered input; if player was not found, returns player (with no initialized values, including the initial)
        Player playerEntered = isInitialAPlayer(players, initialThatGuessed);

        // Only continue if the entered initial matches an actual player initial in the 'players' Player array
        if(playerEntered.getPlayerInitial().length() != 0)
        {
          return playerEntered;
        }
        else if(playerEntered.getPlayerInitial().length() == 0)
        {
          return invalidInput(1);
        }
      }
      else if(initialThatGuessed.length() == 0)
      {
        // There is nothing after the hyphin, no initial
        System.out.println("\nInitial not found");
        return invalidInput(2);
      }
    }
    // If hyphen was not found in array
    else if(hyphenIndex == -1)
    {
      System.out.println("\nHyphen not found.\nAssuming 'j' is a valid initial and 'lorem' is the word to be guessed, enter input as such: 'lorem-j'.");
      return invalidInput(3);
    }

    // Return an empty object is above code does not execute well
    return invalidInput(4);
  }

  public static Player isInitialAPlayer(List<Player> players, String initialThatGuessed)
  {
    Boolean isAPlayerInitial = false;
    int indexOfMatchingPlayer = -1;

    for(int i = 0; i < players.size(); i++)
    {
      if(players.get(i).getPlayerInitial().equalsIgnoreCase(initialThatGuessed))
      {
          indexOfMatchingPlayer = i;
          isAPlayerInitial = true;
      }
    }

    if(indexOfMatchingPlayer != -1)
    {
      return players.get(indexOfMatchingPlayer);
    }
    else if(indexOfMatchingPlayer == -1)
    {
      System.out.println("\nInitial '" + initialThatGuessed + "' not recognized as a player.");
      return invalidInput(5);
    }

    // Return an empty object is above code does not execute well
    System.out.println("\nIf you see this, then something has gone terribly wrong.");
    return invalidInput(6);
  }

  public static String getPlayerGuess(String guessWithHyphen)
  {
    int hyphenIndex = guessWithHyphen.indexOf("-");
    return guessWithHyphen.substring(0, hyphenIndex);
  }

  private static Player invalidInput(int errorNumber)
  {
    //System.out.println("\nSomething went wrong when processing your input. Please try again. Error " + errorNumber + ".");

    // If there is an invalid input witih the word press, this method gets activated, and this return feeds into the return of the 'AnalyzeGuess' method
    return new Player();
  }
  private static void wordNotFound(String playerInitial, String guess, Player player)
  {
    System.out.println("\nSorry, " + playerInitial + ". '" + guess + "' was not found.");
    player.addGuess();
    Interact.playSound("incorrect");
  }

  private static void wordAlreadyFound(String playerInitial, String guess, Player player)
  {
    System.out.println("\nNice try, " + playerInitial + ". '" + guess + "' was already found.");
    player.addGuess();
    Interact.playSound("incorrect");
  }

  private static void wordFound(String playerInitial, String guess, Player player)
  {
    System.out.println("\nCongrats, " + playerInitial + "! '" + guess + "' was found!");
    player.addGuess();
    player.addRightGuess();
    Interact.playSound("correct");
  }

  private static void displayScore(List<Player> players)
  {
    System.out.println("");
    // Want to display each person and his or her scores
    for(Player player : players)
    {
      System.out.println(player.getPlayerInitial() + ": " + player.getPlayerRightGuesses() + " pts. of " + player.getPlayerTotalGuesses() + " total tries.");
    }
  }

  public static Boolean arePlayerNameDuplicates(List<Player> players)
  {
    Boolean areDuplicates = false;
    // For each element of array
    for(int i = 0; i < players.size(); i++)
    {
      // Find if there are any duplicates in the array
      for(int j = 0; j < players.size(); j++)
      {
        // Find duplicates as long as we aren't checking the current element with the currentelement
        if(i != j)
        {
          String playerInitialI = players.get(i).getPlayerInitial();
          String playerInitialJ = players.get(j).getPlayerInitial();

          // if(players.get(i).getPlayerInitial().equalsIgnoreCase(players.get(j).getPlayerInitial())){} would be insane!
          if(playerInitialI.equalsIgnoreCase(playerInitialJ))
          {
            areDuplicates = true;
          }
        }
      }
    }
    if (areDuplicates == true)
    {
      System.out.println("\nSome initials are used twice. Please do not repeat player initials.");
    }
    return areDuplicates;
  }
}

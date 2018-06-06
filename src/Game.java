package src;
import java.util.ArrayList;
import java.util.List;

public class Game
{
  public static List<String> getPlayerNames(String totalPlayers)
  {
    ArrayList<String> playerNames = new ArrayList<String>();

    // Warning
    System.out.println("When inputing player initials, use a maximum of two. Ex. For name 'Joe Biden', enter 'j'; enter actual words as 'word-j'");
    // If there are more than 1 players, give each player a name
    // Recal that promptReply(String stringName) returns the string that was entered in, if it does not include sylabls
    if(totalPlayers.equalsIgnoreCase("2"))
    {
      String player1 = Interact.promptReply("First Player Initials?");
      String player2 = Interact.promptReply("Second Player Initials?");

      playerNames.add("-" + player1);
      playerNames.add("-" + player2);
    }
    else if(totalPlayers.equalsIgnoreCase("3"))
    {
      String player1 = Interact.promptReply("First Player Initials?");
      String player2 = Interact.promptReply("Second Player Initials?");
      String player3 = Interact.promptReply("Third Player Initials?");

      playerNames.add("-" + player1);
      playerNames.add("-" + player2);
      playerNames.add("-" + player3);
    }
    else if(totalPlayers.equalsIgnoreCase("4"))
    {
      String player1 = Interact.promptReply("First Player Initials?");
      String player2 = Interact.promptReply("Second Player Initials?");
      String player3 = Interact.promptReply("Third Player Initials?");
      String player4 = Interact.promptReply("Fourth Player Initials?");

      playerNames.add("-" + player1);
      playerNames.add("-" + player2);
      playerNames.add("-" + player3);
      playerNames.add("-" + player4);
    }

    return playerNames;
  }

  public static void wordNotFound()
  {

  }

  public static void wordFound()
  {

  }

  public static void gameOver()
  {

  }
}

package src;

public class Player
{
  public static int allPlayerGuesses = 0;
  public int totalGuesses = 0;
  public int rightGuesses = 0;
  public String initialWithDash;
  public String initial;

  public Player()
  {
    this.initial = "";
    this.initialWithDash = "";
  }

  public Player(String initial)
  {
    this.initial = initial;
    this.initialWithDash = "-" + initial;
  }

  public void addGuess()
  {
    totalGuesses += 1;
    allPlayerGuesses += 1;
  }

  public void addRightGuess()
  {
    rightGuesses += 1;
    allPlayerGuesses += 1;
  }

  public String getPlayerInitial()
  {
    return initial;
  }

  public int getPlayerRightGuesses()
  {
   return rightGuesses;
  }

  public int getPlayerTotalGuesses()
  {
   return totalGuesses;
  }
}

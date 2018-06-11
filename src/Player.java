package src;

public class Player
{
  public static int allPlayerGuesses = 0;
  private int totalGuesses = 0;
  private int rightGuesses = 0;

  public static int allPoints = 0;
  private int points;

  private String initialWithDash;
  private String initial;

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

  public void addPoints(String guess)
  {
    points += guess.length();
    allPoints += guess.length();
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

  public int getPoints()
  {
    return points;
  }

  public int getAllPoints()
  {
    return allPoints;
  }

  public void changePoints(int value)
  {
    points += value;
  }
}

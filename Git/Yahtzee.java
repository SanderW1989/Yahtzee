package yahtzee;

import java.util.*;

public class Yahtzee {

      public static void main(String[] args) {
        int play = 1, scorea = 0, sum = 0;
        int[] wins = new int[15];
        while ((play == 1) && (sum < 15)) {
          sum = 0;
          int[] aDice = new int[] { 0, 0, 0, 0, 0 }; 
          int roll = 0;
          int x, y, w, z;
          int rerolla = 0, rerollb = 03;
          Die die = new Die();
          for (x = 0; x < 5; x++) {
            die.roll();
            aDice[x] = die.get();// sets dobbelsteenwaardes
          }
     
          System.out.println("Dobbelsteen 1: " + aDice[0]);
          System.out.println("Dobbelsteen 2: " + aDice[1]);
          System.out.println("Dobbelsteen 3: " + aDice[2]);
          System.out.println("Dobbelsteen 4: " + aDice[3]);
          System.out.println("Dobbelsteen 5: " + aDice[4]);
     
          do {
            rerolla = inputInt("Hoeveel dobbelstenen wil je opnieuw rollen? (0-5)");
            if (rerolla > 0) {
              int[] reroll = new int[rerolla];
              for (y = 0; y < rerolla; y++) {
                rerollb = inputInt("Welke");
                reroll[y] = rerollb;
              }
              for (w = 0; w < rerolla; w++) {
                if (reroll[w] == 1) {
                  die.roll();
                  aDice[0] = die.get();
                }
                if (reroll[w] == 2) {
                  die.roll();
                  aDice[1] = die.get();
                }
                if (reroll[w] == 3) {
                  die.roll();
                  aDice[2] = die.get();
                }
                if (reroll[w] == 4) {
                  die.roll();
                  aDice[3] = die.get();
                }
                if (reroll[w] == 5) {
                  die.roll();
                  aDice[4] = die.get();
                }
              }
              roll++;
              System.out.println("Dobbelsteen 1: " + aDice[0]);
              System.out.println("Dobbelsteen 2: " + aDice[1]);
              System.out.println("Dobbelsteen 3: " + aDice[2]);
              System.out.println("Dobbelsteen 4: " + aDice[3]);
              System.out.println("Dobbelsteen 5: " + aDice[4]);
     
            }
          } while ((roll < 2) && (rerolla > 0));
          Winnings prize = new Winnings();
          prize.checkWinnings(aDice, wins);
          wins[prize.choice() - 1] = 1;
          for (z = 0; z < 15; z++) {
            sum += wins[z];
          }
          scorea += prize.score();
          System.out.println("Je totale score is: " + scorea);
          if (sum < 15) {
            play = inputInt("wil je opnieuw spelen?(1=ja, 2=nee)");
          } else {
            System.out.println("Quit");
          }
        }
      }
     
      static int inputInt(String Prompt) {
        int result = 0;
        try {
          result = Integer.parseInt(input(Prompt).trim());
        } catch (Exception e) {
          result = 0;
        }
        return result;
      }
     
      static String input(String prompt) {
        String inputLine = "";
        System.out.print(prompt);
        try {
          java.io.InputStreamReader sys = new java.io.InputStreamReader(
              System.in);
          java.io.BufferedReader inBuffer = new java.io.BufferedReader(sys);
          inputLine = inBuffer.readLine();
        } catch (Exception e) {
          String err = e.toString();
          System.out.println(err);
        }
        return inputLine;
      }
    }
     
    // dobbelsteen klasse
    class Die {
      private int value;
      private Random rand;
     
      public Die() {
        value = 0;
        rand = new Random();
      }
     
      public void roll() {
        value = 1 + rand.nextInt(6);
      }
     
      public int get() {
        return (value);
      }
    }
     
    //klasse voor type win
    class Winnings {
      private int score;
      private int choice;
     
      public Winnings() {
        score = 0;
      }
     
      public void checkWinnings(int[] aDice, int[] wins) {
        System.out.println("Which do you want to see if you have?");
        if (wins[0] == 0) {
          System.out.println("1 - yahtzee");
        }
        if (wins[1] == 0) {
          System.out.println("2 - full house");
        }
        if (wins[2] == 0) {
          System.out.println("3 - large straigt");
        }
        if (wins[3] == 0) {
          System.out.println("4 - small straigt");
        }
        if (wins[4] == 0) {
          System.out.println("5 - four of a kind");
        }
        if (wins[5] == 0) {
          System.out.println("6 - three of a kind");
        }
        if (wins[6] == 0) {
          System.out.println("7 - pair");
        }
        if (wins[7] == 0) {
          System.out.println("8 - two pair");
        }
        if (wins[8] == 0) {
          System.out.println("9 - number of 1's");
        }
        if (wins[9] == 0) {
          System.out.println("10 - number of 2's");
        }
        if (wins[10] == 0) {
          System.out.println("11 - number of 3's");
        }
        if (wins[11] == 0) {
          System.out.println("12 - number of 4's");
        }
        if (wins[12] == 0) {
          System.out.println("13 - number of 5's");
        }
        if (wins[13] == 0) {
          System.out.println("14 - number of 6's");
        }
        if (wins[14] == 0) {
          System.out.println("15 - chance");
        }
        choice = MiniYahtzee.inputInt(""); //NB!!!
     
        int x = 0, y = 0, winings = 0, winingsa = 0;
        int ones = 0, twos = 0, threes = 0, fours = 0, fives = 0, sixes = 0;
        Arrays.sort(aDice);
     
        //Numbers
        for (y = 0; y < 5; y++) {
          if (aDice[y] == 1) {
            ones++;
          }
          if (aDice[y] == 2) {
            twos++;
          }
          if (aDice[y] == 3) {
            threes++;
          }
          if (aDice[y] == 4) {
            fours++;
          }
          if (aDice[y] == 5) {
            fives++;
          }
          if (aDice[y] == 6) {
            sixes++;
          }
        }
     
        //Straights
        if ((aDice[0] == aDice[1] - 1) && (aDice[1] == aDice[2] - 1)
            && (aDice[2] == aDice[3] - 1) && (aDice[3] == aDice[4] - 1)
            && (choice == 3)) {
          winingsa = 1;
        } else if ((ones > 0) && (twos > 0) && (threes > 0) && (fours > 0)) {
          winingsa = 2;
        } else if ((threes > 0) && (fours > 0) && (fives > 0) && (sixes > 0)) {
          winingsa = 2;
        } else if ((twos > 0) && (threes > 0) && (fours > 0) && (fives > 0)) {
          winingsa = 2;
        }
     
        //Pairs
        for (x = 0; x < 5; x++) {
          if (x != 0) {
            if ((aDice[0] == aDice[x])) {
              winings++;
            }
          }
          if ((x != 0) && (x != 1)) {
            if ((aDice[1] == aDice[x])) {
              winings++;
            }
          }
          if ((x != 0) && (x != 1) && (x != 2)) {
            if ((aDice[2] == aDice[x])) {
              winings++;
            }
          }
          if ((x != 0) && (x != 1) && (x != 2) && (x != 3)) {
            if ((aDice[3] == aDice[x])) {
              winings++;
            }
          }
        }
     
        //Winnings
        if ((winingsa == 1) && (choice == 3)) {
          System.out.println("You have a straight.");
          score = 40;
        } else if ((winingsa == 2) && (choice == 4)) {
          System.out.println("You have a small straight.");
          score = 30;
        } else if ((winings == 10) && (choice == 1)) {
          System.out.println("Yatzee!");
          score = 50;
        } else if ((choice == 6) && (winings >= 3)) {
          System.out.println("You have three of a kind.");
          score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
        } else if ((choice == 7) && (winings > 0)) {
          System.out.println("You have a pair.");
          score = 5;
        } else if ((winings == 2) && (choice == 8)) {
          System.out.println("You have two pairs.");
          score = 10;
        } else if ((winings == 4) && (choice == 2)) {
          System.out.println("You have a full house.");
          score = 25;
        } else if ((winings >= 6) && (choice == 5)) {
          System.out.println("You have four of a kind.");
          score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
        } else if (choice == 9) {
          System.out.println("You have " + ones + " ones.");
          score = ones;
        } else if (choice == 10) {
          System.out.println("You have " + twos + " twos.");
          score = twos * 2;
        } else if (choice == 11) {
          System.out.println("You have " + threes + " threes.");
          score = threes * 3;
        } else if (choice == 12) {
          System.out.println("You have " + fours + " fours.");
          score = fours * 4;
        } else if (choice == 13) {
          System.out.println("You have " + fives + " fives.");
          score = fives * 5;
        } else if (choice == 14) {
          System.out.println("You have " + sixes + " sixes.");
          score = sixes * 6;
        } else if (choice == 15) {
          score = aDice[0] + aDice[1] + aDice[2] + aDice[3] + aDice[4];
          System.out.println("Your get " + score + " points.");
        } else {
          System.out.println("Je hebt niets.");
          score = 0;
        }
      }
     
      public int score() {
        return (score);
      }
     
      public int choice() {
        return (choice);
      }
    }
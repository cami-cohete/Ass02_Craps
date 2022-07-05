import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        int die1 = rnd.nextInt(6) + 1;
        int die2 = rnd.nextInt(6) + 1;
        int crapsRoll = die1 + die2;

        boolean pointSumDone = false;
        int pointSum = 0;

        boolean done = false;
        boolean validAnswer = false;
        String playAgain = "";

        do {

            System.out.println("Let's play Craps!!!");
            System.out.print("Press any key to roll the dice: ");
            in.nextLine();

            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            crapsRoll = die1 + die2;
            System.out.println("You rolled a " + die1 + " and a " + die2 + ".");

            if ((crapsRoll == 2) || (crapsRoll == 3) || (crapsRoll == 12))
            {
                System.out.println("Oh no you crapped out! You rolled a: " + crapsRoll);
                System.out.println("Better luck next time!");
            }

            else if ((crapsRoll == 7) || (crapsRoll == 11))
            {
                System.out.println("Winner winner chicken dinner!");
                System.out.println("You rolled a natural: " + crapsRoll);
            }

            else
            {
                pointSum = crapsRoll;
                System.out.println("Wow almost got it! Your craps roll is now the point sum: " + pointSum);
                System.out.println("Roll again and try to get the point sum but roll 7 and you lose!");
                System.out.print("Press any key to roll again: ");
                in.nextLine();

                do {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    crapsRoll = die1 + die2;
                    System.out.println("You rolled " + die1 + " and " + die2 + ".");
                    System.out.println("Your craps roll is: " + crapsRoll);

                    if (crapsRoll == 7)
                    {
                        System.out.println("Oh no you lost! Better luck next time.");
                        pointSumDone = true;
                    }
                    else if (crapsRoll == pointSum)
                    {
                        System.out.println("Winner Winner Chicken Dinner! You made point and won!");
                        pointSumDone = true;
                    }
                    else
                    {
                        System.out.print("Not quite the point sum. Roll again [press any key]: ");
                        in.nextLine();
                    }
                } while (!pointSumDone);
            }

            do {
                System.out.print("Would you like to play again [Y/N]? ");
                playAgain = in.nextLine();
                if (playAgain.equalsIgnoreCase("Y"))
                {
                    validAnswer = true;
                    done = false;
                }
                else if (playAgain.equalsIgnoreCase("N"))
                {
                    validAnswer = true;
                    done = true;
                }
                else
                {
                    System.out.println("Invalid Input: " + playAgain);
                }
            } while (!validAnswer);

            validAnswer = false; // to reset game
            pointSumDone = false; // to reset game

        } while (!done);
        System.out.println("Thanks for playing (:");
    }
}

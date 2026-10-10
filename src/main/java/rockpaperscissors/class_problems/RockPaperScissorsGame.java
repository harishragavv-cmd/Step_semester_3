package rockpaperscissors.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if (playerMove.equals("Rock") && computerMove.equals("Scissors")
                || playerMove.equals("Paper") && computerMove.equals("Rock")
                || playerMove.equals("Scissors") && computerMove.equals("Paper")) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];
        Random random = new Random();
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Round " + (i + 1) + " - Enter Rock, Paper, or Scissors: ");
            playerMoves[i] = sc.nextLine().trim();

            while (!playerMoves[i].equalsIgnoreCase("Rock")
                    && !playerMoves[i].equalsIgnoreCase("Paper")
                    && !playerMoves[i].equalsIgnoreCase("Scissors")) {
                System.out.print("Invalid move. Enter Rock, Paper, or Scissors: ");
                playerMoves[i] = sc.nextLine().trim();
            }

            playerMoves[i] = playerMoves[i].substring(0, 1).toUpperCase()
                    + playerMoves[i].substring(1).toLowerCase();
            computerMoves[i] = moves[random.nextInt(3)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) wins++;
            else if (results[i].equals("Computer Wins")) losses++;
            else draws++;

            System.out.println(results[i]);
        }

        System.out.println("\nRound | Player Move | Computer Move | Result");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + " | " + playerMoves[i] + " | "
                    + computerMoves[i] + " | " + results[i]);
        }

        System.out.println("Wins: " + wins + " | Losses: " + losses
                + " | Draws: " + draws + " | Win % = " + (wins * 100.0 / 5) + "%");
        sc.close();
    }
}

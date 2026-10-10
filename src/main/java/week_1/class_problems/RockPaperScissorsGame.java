package week_1.class_problems;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if (playerMove.equals("Rock") && computerMove.equals("Scissors")
                || playerMove.equals("Paper") && computerMove.equals("Rock")
                || playerMove.equals("Scissors") && computerMove.equals("Paper"))
            return "Player Wins";
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] players = new String[5], computers = new String[5], results = new String[5];
        Random random = new Random();
        int wins = 0, losses = 0, draws = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print("Round " + (i + 1) + " - Enter Rock, Paper, or Scissors: ");
            String move = sc.nextLine().trim();
            while (!move.equalsIgnoreCase("Rock") && !move.equalsIgnoreCase("Paper")
                    && !move.equalsIgnoreCase("Scissors")) {
                System.out.print("Invalid move. Try again: ");
                move = sc.nextLine().trim();
            }
            players[i] = move.substring(0, 1).toUpperCase() + move.substring(1).toLowerCase();
            computers[i] = moves[random.nextInt(3)];
            results[i] = playRound(players[i], computers[i]);
            if (results[i].equals("Player Wins")) wins++;
            else if (results[i].equals("Computer Wins")) losses++;
            else draws++;
            System.out.println(results[i]);
        }
        System.out.println("\nRound | Player Move | Computer Move | Result");
        for (int i = 0; i < 5; i++)
            System.out.println((i + 1) + " | " + players[i] + " | " + computers[i] + " | " + results[i]);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, wins * 100.0 / 5);
        sc.close();
    }
}
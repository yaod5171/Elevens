package Elevens2;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * This is a class that simulates the Elevens game. See
 * accompanying documents for a description of how Elevens is played.
 */
public class ElevensSimulation {
    
    /**
     * Checks the board for an 11-pair.
     * 
     * @param gameBoard is a <code>Board</code> subclass.
     * 
     * @return an array of length 2, containing indexes of the 11-pair, if a 
     * pair is found. Otherwise, returns null.
     */
    public static int[] findPairSum11(Board gameBoard) {
        List<Integer> pointValues = new ArrayList();
        for (Integer i: gameBoard.cardIndexes())  {
            Card c = gameBoard.cardAt(i);
            if (c != null) { //in case of a screw up
                 pointValues.add(c.pointValue());
            }
        }
        for (int i = 0; i < pointValues.size(); i++) {
            int j = pointValues.indexOf(11 - pointValues.get(i));
            if (j != -1) return new int[]{i,j};
        }
        return null;
    }
    
    /**
     * Checks the board for a JQK set.
     *
     * @param gameBoard is a <code>Board</code> subclass.
     * 
     * @return an array of length 3, containing indexes of the JQK set, if a 
     * set is found. Otherwise, returns null.
     */
    public static int[] findJQK(Board gameBoard) {
        int[] jqk = {-1, -1, -1};
        String[] JQK_ranks = {"jack", "queen", "king"};
        
        for (Integer i: gameBoard.cardIndexes()) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard.cardAt(i).rank().equals(JQK_ranks[j])) jqk[j] = i;
            }
        }
        
        if (jqk[0] != -1 && jqk[1] != -1 && jqk[2] != -1) return jqk;
        return null;
    }
    
    /**
     * Runs the simulation for multiple games of Elevens.
     *
     * @param args is not used.
     */
    public static void main(String[] args) {
        Board board = new ElevensBoard();
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Games to play: ");
        int gamesToPlay = scan.nextInt();
        scan.nextLine();
        
        int wins = 0;
        for (int i = 0; i < gamesToPlay; i++) {
            board.newGame();
            while (board.anotherPlayIsPossible()) {
                List<Integer> move = new ArrayList(); 
                
                //will prioritize JQK over pairSum11
                if (findJQK(board) != null) {
                    for (int m: findJQK(board)) {
                        move.add(m); //convert array to List for isLegal, etc.
                    }
                } else {
                    for (int m: findPairSum11(board)) {
                        move.add(m);
                    }
                }
                
                if (board.isLegal(move)) {
                    board.replaceSelectedCards(move);
                }
            }
            if (board.gameIsWon()) {
                wins++;
            }
        }
        System.out.println((gamesToPlay + " games, " + wins + " wins"));
    }
}

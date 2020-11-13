/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quad;

/**
 *
 * @author user
 */
public class staticMethods {
    
    public static int checkWin(int[][] board) {         //Checks  the whole board for 4
        final int HEIGHT = board.length;                // I could check these instead | - / \ for less iterations but leave that for later
        final int WIDTH = board[0].length;              //(I mean the whole lines for 4 adjacent colors)
        final int EMPTY_SLOT = 0; 
        
        /* 
        * ***When filling the Board note that :***
        * 0 = Empty Slot
        * 1 = Player_1
        * 2 = Player_2
        */
        
        for (int r = 0; r < HEIGHT; r++) { // iterate rows, bottom to top
            for (int c = 0; c < WIDTH; c++) { // iterate columns, left to right
                int player = board[r][c];
                if (player == EMPTY_SLOT)
                    continue; // don't check empty slots

                if (c + 3 < WIDTH &&
                    player == board[r][c+1] && // look right
                    player == board[r][c+2] &&
                    player == board[r][c+3])
                    return player;
                if (r + 3 < HEIGHT) {
                    if (player == board[r+1][c] && // look up
                        player == board[r+2][c] &&
                        player == board[r+3][c])
                        return player;
                    if (c + 3 < WIDTH &&
                        player == board[r+1][c+1] && // look up & right
                        player == board[r+2][c+2] &&
                        player == board[r+3][c+3])
                        return player;
                    if (c - 3 >= 0 &&
                        player == board[r+1][c-1] && // look up & left
                        player == board[r+2][c-2] &&
                        player == board[r+3][c-3])
                        return player;
                }
            }
        }
        return EMPTY_SLOT; // no winner found
    }
    
}

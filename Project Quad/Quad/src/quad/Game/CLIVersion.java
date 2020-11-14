/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quad.Game;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import quad.staticMethods;

/**
 *
 * @author user
 */
public class CLIVersion {
        
    private static final char[] PLAYERS = {'1', '2'};
    private final int DimX, DimY;
    private final char[][] grid; //My Board     //Height x Width
    private final char EMPTY_SLOT='_';
    
    private int lastCol = -1, lastRow = -1; //Last move "tuple"

    public CLIVersion(int DimX, int DimY) {
        this.DimX = DimX;
        this.DimY = DimY;
        grid = new char[DimY][];        //Height x Width
        
        for (int i = 0; i < DimY; i++) {
            Arrays.fill(grid[i] = new char[DimX], EMPTY_SLOT);
        }
    }

    @Override
    public String toString() {
        return IntStream.range(0, DimX).mapToObj(Integer::toString).collect(Collectors.joining()) + "" // Creates the Row numbering
                + "\n" + Arrays.stream(grid).map(String::new).collect(Collectors.joining("\n"));       // Creates the board
    }
    
    public String horizontal() {                        //The row containing the last play as a String
        return new String(grid[lastRow]);
    }
    
    public String vertical() {
        StringBuilder sb = new StringBuilder(DimY);     // The column containing the last play as a String
        for (int y = 0; y < DimY; y++) {
          sb.append(grid[y][lastCol]);
        }
        return sb.toString();
    }
    public String slashDiagonal() {                     // The // diagonial containing the last play as a String
        StringBuilder sb = new StringBuilder(DimY);
        for (int h = 0; h < DimY; h++) {
          int w = lastCol + lastRow - h;
          if (0 <= w && w < DimX) {
            sb.append(grid[h][w]);
          }
        }
        return sb.toString();
    }
    
    public String backslashDiagonal() {                 // The \\ diagonial containing the last play as a String
        StringBuilder sb = new StringBuilder(DimY);
        for (int h = 0; h < DimY; h++) {
          int w = lastCol - lastRow + h;
          if (0 <= w && w < DimX) {
            sb.append(grid[h][w]);
          }
        }
        return sb.toString();
    }
    
    public boolean isWinningPlay(){
        if ((lastCol == -1) || (lastRow==-1)) {
            System.err.println("No move has been made yet");
            return false;
        }
        
        if (staticMethods.checkWin(grid)!='_'){         // if returned cell isn't '_' then player has won
            return true;
        }
        return false;
    }
    
    public void chooseAndDrop(char symbol, Scanner input) {
        do {
            System.out.println("\nPlayer " + symbol + " turn: ");
            int col = input.nextInt();
            if (!(0 <= col && col < DimX)) {            //check col num
                System.out.println("Column must be between 0 and " + (DimX - 1));
                continue;
            }
            for (int h = DimY - 1; h >= 0; h--) {       //place it in the first available row
                if (grid[h][col] == EMPTY_SLOT) {
                  grid[lastRow = h][lastCol = col] = symbol;
                  return;           //by the time it find a place, it stops there
                }
            }
            System.out.println("Column " + col + " is full."); //otherwise it asks for a second input
        }while(true);
    }

    public static char getPLAYER(int i) {
        return PLAYERS[i];
    }
    
    
}

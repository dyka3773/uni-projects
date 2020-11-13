/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quad.Game;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author user
 */
public class CLIVersion {
        
    private static final char[] PLAYERS = {'1', '2'};
    private final int DimX, DimY;
    private final char[][] grid; //My Board     //Height x Width
    
    private int lastCol = -1, lastRow = -1; //Last move "tuple"

    public CLIVersion(int DimX, int DimY) {
        this.DimX = DimX;
        this.DimY = DimY;
        grid = new char[DimY][];        //Height x Width
        
        for (int i = 0; i < DimY; i++) {
            Arrays.fill(grid[i] = new char[DimX], '_');
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
    
    public String backslashDiagonal() {
        StringBuilder sb = new StringBuilder(DimY);
        for (int h = 0; h < DimY; h++) {
          int w = lastCol - lastRow + h;

          if (0 <= w && w < DimX) {
            sb.append(grid[h][w]);
          }
        }
        return sb.toString();
    }
    
}

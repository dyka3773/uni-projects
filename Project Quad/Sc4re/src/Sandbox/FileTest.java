/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandbox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Sakis
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        File config = new File("src/Sandbox/config.txt");
        String vars[] = new String[2];
        try {
            Scanner configScanner = new Scanner(config);
            int i = 0;
            while(configScanner.hasNextLine()){
                String data = configScanner.nextLine();
                vars[i] = data;
                i++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        for (String var : vars) {
            System.out.println(var);
        }
        
        String splitted[] = vars;
        String player1color[];
        String player2color[];
        
        player1color = splitted[0].split("_");
        player2color = splitted[1].split("_");
        
        player1color = player1color[1].split(".jpg");
        player2color = player2color[1].split(".jpg");
        
        System.out.println(player1color[0]+" "+player2color[0]);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandbox;

import java.util.Scanner;

/**
 *
 * @author Sakis
 */
public class PlayerSelection {
    public static void main(String[] args) {
        String colorArray[] =  new String[6];
        
        colorArray[0] = "red";
        colorArray[1] = "blue";
        colorArray[2] = "green";
        colorArray[3] = "pink";
        colorArray[4] = "orange";
        colorArray[5] = "yellow";
        
        int player1Index = 0;
        int player2Index = 1;
        Scanner input = new Scanner(System.in);
        String direction;
        String direction2;
        do{
            direction = input.nextLine();
            if(direction.equals("a")){
               player1Index--;
               if(player1Index==player2Index){
                    player1Index--;
                }
            }else if(direction.equals("d")){
                player1Index++;
                if(player1Index==player2Index){
                    player1Index++;
                }
            }
            direction = input.nextLine();
            if(direction.equals("a")){
               player2Index--;
               if(player1Index==player2Index){
                    player2Index--;
                }
            }else if(direction.equals("d")){
                player2Index++;
                if(player1Index==player2Index){
                    player2Index++;
                }
            }
            
            if(player1Index>5){
                player1Index=0;
            }
            else if(player1Index<0){
                player1Index=5;
            }
            System.out.println(colorArray[player1Index]+" "+colorArray[player2Index]);
        }while(!direction.equals("q"));
    }
}

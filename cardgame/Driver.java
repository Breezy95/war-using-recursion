/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Fabrice Benoit
 */
public class Driver {
    
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Pick a card game");
        String gameType = input.nextLine();
        System.out.println("How many will be playing");
        int numPlayers = input.nextInt();
        Game cardGame = new War();
        if(gameType.contentEquals("War")){
            System.out.println("How many points to win?");
            int points = input.nextInt();
            //numplayers, pointsneeded
            cardGame = new War(numPlayers,points);
        }
        cardGame.gameStart();
        while(!cardGame.gameEnd()){
            cardGame.drawCard();
            cardGame.turnStart();
            cardGame.turnEnd();
            cardGame.gameEnd();
        }
        
    }
}

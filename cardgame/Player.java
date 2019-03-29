/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.util.ArrayList;

/**
 *
 * @author Fabrice Benoit
 */
public class Player {
    boolean isCpu;
    String name;
    hand cardHand;
    deck playerDeck, playerGraveyard;
    
    public Player(){
        
    }
    
    

    public Player(String name, hand cardHand, deck playerDeck) {
        this.name = name;
        this.cardHand = cardHand;
        this.playerDeck = playerDeck;
    }

    public Player(String name, hand cardHand, deck playerDeck, deck playerGraveyard) {
        this.name = name;
        this.cardHand = cardHand;
        this.playerDeck = playerDeck;
        this.playerGraveyard = playerGraveyard;
    }

    
    
    public Player(boolean isCpu, String name, hand cardHand, deck playerDeck) {
        this.isCpu = isCpu;
        this.name = name;
        this.cardHand = cardHand;
        this.playerDeck = playerDeck;
    }

    public Player(String name) {
        this.name = name;
    }
    
    
    
    public Player(boolean needsDeck, String name, hand cardHand, deck playerDeck, deck playeerGraveyard) {
        this.isCpu = isCpu;
        this.name = name;
        this.cardHand = cardHand;
        this.playerDeck = playerDeck;
        this.playerGraveyard = playeerGraveyard;
    }
    
    

   
    
    
}

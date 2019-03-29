/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabrice Benoit
 */
public class hand {
    Card[] cardHand;
    int numCards; //how many cards are in hand
    
    public hand(){
        cardHand = new Card[5];
        numCards = 0;
    }
    
    public hand(Card[] hand){
        cardHand = hand;
    }
    
    public hand(int numOfCards){
        cardHand = new Card[numOfCards];
        numCards = 0;
    }
    
    public void fillHand(deck usedDeck) throws FullHandException, EmptyDeckException{
        while(numCards <cardHand.length){
            if(numCards == cardHand.length)
                throw new FullHandException();
            if(usedDeck.size() ==0)
                throw new EmptyDeckException();
            cardHand[numCards++] = usedDeck.removeTop();
        }
    }
    
    public void fillHand(Card[] hand){
        if(hand.length == 5)
            cardHand = hand;
        else{
            for(int i = 0; i<cardHand.length;i++)
                cardHand[i] = hand[i];
        }
    }
    
    public void addCard(Card card) throws FullHandException{
        if(numCards>= cardHand.length)
            throw new FullHandException();
        cardHand[numCards++] = card;
    }
    
    public Card[] removeHand(){
        Card[] temp = cardHand;
        Arrays.fill(cardHand,null);
        numCards=0;
        return temp;
    }
    //removes first card in array
    public Card removefirstCard() throws EmptyHandException{
        if(numCards ==0)
            throw new EmptyHandException();
        Card temp = cardHand[0];
        for(int i = 0; i<cardHand.length-1;i++)
            cardHand[i] = cardHand[i+1];
        cardHand[cardHand.length-1]= null;
        numCards--;
        return temp;
    }
    public Card removeCard(int num) throws EmptyHandException{
        if(numCards == 0)
            throw new EmptyHandException();
        Card temp;
        temp = cardHand[num];
        cardHand[num] = null;
        for(int i = num; i<cardHand.length-1;i++)
            cardHand[i] = cardHand[i+1];
        numCards--;
        return temp;
    }
    
    public static void main(String[] args){
        deck d = deck.deckCreator("war");
        hand h = new hand(1);
        try {
            h.fillHand(d);
        } catch (FullHandException ex) {ex.printStackTrace();} 
        catch (EmptyDeckException ex) {}
        
       
        System.out.println(h.cardHand[0] + "| size:" + h.numCards);

    }
    
}

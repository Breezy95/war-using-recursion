/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author Fabrice Benoit
 */
public class deck {
    ArrayList<Card> deck = new ArrayList<>(); //Arraylist 
    //acting as a stack
    
    public deck(){
    }
 
    public void ShuffleDeck(){
        Collections.shuffle(deck, new Random());
    }
    
    public void addToDeck(ArrayList<Card> cards){
        deck.addAll(cards);
        
    }
    
    public static deck deckCreator(String gameName){
        deck neoDeck = null;
        if(gameName.toLowerCase().contentEquals("war"))
            neoDeck = warDeck();
        return neoDeck;
    }
    
    
    private static deck warDeck(){
        deck neoDeck = new deck();
    ArrayList<Card> deck = new ArrayList<>();
    String value = "";
    int j = 2;
    for(int i = 0; i<52;i++){
        if(j>14)
            j =2;
        if(i<13){
            if(j == 14)
                value = "Ace";
            if(j==13)
                value = "King";
            if(j == 12)
                value = "Queen";
            if(j == 11)
                value = "Jack";
            if(j<11)
                value = Integer.toString((i%13) +2);
            deck.add(new Card(value,"Spade",(i%13) + 1));
        }
        if(i<26 && i>=13){
            if(j == 14)
                value = "Ace";
         if(j==13)
                value = "King";
            if(j == 12)
                value = "Queen";
            if(j == 11)
                value = "Jack";
            if(j<11)
                value = Integer.toString((i%13) + 2);
            deck.add(new Card(value,"Hearts",(i%13) + 1)); 
        }
        if(i<39 && i>=26){
            if(j == 14)
                value = "Ace";
            if(j==13)
                value = "King";
            if(j == 12)
                value = "Queen";
            if(j == 11)
                value = "Jack";
            if(j<11)
                value = Integer.toString((i%13) + 2);
            deck.add(new Card(value,"Diamonds",(i%13) + 1));
        }
      
        if(i<52 && i>=39){
            if(j == 14)
                value = "Ace";
            if(j==13)
                value = "King";
            if(j == 12)
                value = "Queen";
            if(j == 11)
                value = "Jack";
            if(j<11)
                value = Integer.toString((i%13) + 2);
            deck.add(new Card(value,"Clubs",(i%13) + 1));
        }
        j++;
            }
        neoDeck.deck = deck;
        Collections.shuffle(neoDeck.deck, new Random());
    return neoDeck;    
    } 
    
    //deck of cards is a stack
    public void addCard(Card cd){
        deck.add(cd);
    }
    
    public Card peek(){
        return deck.get(deck.size()-1);
    }
    
    public Card removeTop(){
        if(deck.size() ==0)
            throw new EmptyStackException();
        return deck.remove(deck.size()-1);
    }
    
    public int size(){
        return deck.size();
    }
    
    public void shuffle(){
        Collections.shuffle(deck);
    }
    
    public void printDeck(){
        for (Card crd : deck){
            System.out.println(crd);        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Fabrice Benoit
 */

//war only needs three of the implemented methods
//one to draw card and one to place card
//and one in case cards of equal value are placed - this might be a provate method
public class War implements Game {
    int numPlayers,p1points,p2points,pointsNeeded;
    Player[] playerSet;
    String gameName = "War";
    private boolean gameEnd = false;
    private deck Wardeck = deck.deckCreator("War");
    
    private void imgAdder
    
    public War(){
        
    }
    public War(int numPlayers){
        this.numPlayers = numPlayers;
        playerSet = new Player[numPlayers];
        }

    public War(int numPlayers, int pointsNeeded) {
        this.numPlayers = numPlayers;
        this.pointsNeeded = pointsNeeded;
        playerSet = new Player[numPlayers];
    }
    
    //if player is cpu
    public void AIchoice(){
        
    }

    //use Game start to set decks, hands, and set players and cpus
    public void gameStart() {
        //turn this into method create players
        for(int i =0;i<numPlayers;i++){
            
            playerSet[i] = new Player("Player" + (i+1),new hand(1),new deck(),new deck());
            int numInDeck =0;
            
            while(numInDeck<52/numPlayers){
                playerSet[i].playerDeck.addCard(Wardeck.removeTop());
                numInDeck++;
            }
        }
    }

    // turn cycles through array of players and sets cards out
    public void turnStart() {
        for( int i = 0; i<playerSet.length;i++){
            if(playerSet[i] == null)
                continue;
            if (playerSet[i].playerDeck.size() ==0 && 
                    playerSet[i].cardHand.numCards == 0)
                playerSet[i] = null;
        }
    }

    //everybody draws cards
    public void drawCard() {
    for(int i=0;i<playerSet.length;i++){
        try {
            playerSet[i].cardHand.fillHand(playerSet[i].playerDeck);
        } catch (FullHandException ex) {} 
        catch (EmptyDeckException ex) { }
    }
        System.out.println("draw card finished");
    }

    //places card on battlefield
    //compares value
    public void turnEnd() {
    //needs to check all combinations of players cards.
    //location on array should correspond to players
    //next person thats used should be player 2
    //loc in array corresponds to player num
    Card[] battleField = new Card[numPlayers];
    Card[] war = new Card[numPlayers];
    Player[] parts = new Player[numPlayers];
    placeCards(battleField);
    
//finds the largest value
    int largest = -1;
    battleField[0].num = 1;
    battleField[1].num= 1;
    for(int i =0;i<battleField.length;i++){
            if(battleField[i].num > largest)
                largest = battleField[i].num;
    }
    //takes ones with the largest value and puts it in war array
    for(int i = 0; i<battleField.length;i++){
        if(battleField[i].num == largest){
            war[i] = battleField[i];
            parts[i] = playerSet[i];
        }
    }
    //recursive method for war
    Player winnerOfWar = cardWar(war,parts);
    System.out.println(winnerOfWar.name + " is the winner \n these are the contents");
    winnerOfWar.playerGraveyard.printDeck();
    }
    //recursive call deposits all of the winners cards into the winners
    //graveyard
    public Player cardWar(Card[] soldiers, Player[] factions){
       
        Player winner = helperCardWar(soldiers,factions,new ArrayList<Card>(),new Card());
        return winner;
    }
    private Player helperCardWar(Card[] soldiers,Player[] factions, ArrayList<Card> pawns,Card winner){
        //base case check if only one card is there
        
        int num =0,loc = -1;
        for(int i =0; i<factions.length;i++){
            if (soldiers[i] != null){
                pawns.add(soldiers[i]);
            }
            if(factions[i] != null){
                num++;
                loc = i;
            }
        }
        if (num ==1){
            System.out.println(winner.toString() +  " is the winner");
            factions[loc].playerGraveyard.addToDeck(pawns);
            return factions[loc];
        }
        else{
        //recursion
       // places cards from each person into battlefield
       Card[] bf = new Card[factions.length];
       Arrays.fill(bf,new Card(-1));
       winner = placeCardsWar(bf, factions,pawns);
       for(int i =0;i<bf.length;i++){
           if(bf[i] == null)
               continue;
           if(bf[i].num < winner.num){
               factions[i] = null;
               //pawns.add(bf[i]);
           }
           
       }
       
       return helperCardWar(soldiers, factions, pawns,winner);
       //compares cards and if one card is greater than other
       //puts all the cards into the winning players graveyard and sets
       //other players to null
       //this is returned so the main thing can get player info
     
       //if its found that more than one card share highest value
       //set the other card positions and player positions equal to null
       //and perform  recursive call with new battlefield and factions var
       
       //this is where we have make it so that it adds all the cards that
       //were drawn the question is if I add it all here will I have multiple
       //instances of the same type of card?
        }   
    }
    
    private Card placeCardsWar(Card[] bf,Player[] factions, ArrayList<Card> pawns){
        Card max = new Card();
        max.num = -1;
        for(int i=0; i<factions.length;i++){
        if(factions[i] ==null)
            continue;
        //put card onto new battlefield after check if null
        //
        try{
            Card warCard = factions[i].playerDeck.removeTop();
            factions[i].cardHand.addCard(warCard);
            bf[i] = factions[i].cardHand.removefirstCard();
            pawns.add(bf[i]);
            System.out.println(factions[i].name + " placed " + bf[i].toString());
        }
        catch(EmptyHandException ex){}
        catch(FullHandException ex1) {
            try {
            bf[i] = factions[i].cardHand.removefirstCard();
            pawns.add(bf[i]);
            } catch (EmptyHandException ex) {}
        }
       if(bf[i].num>max.num)
            max = bf[i];
       
        
    }
        return max;
    }
    
    private void placeCards(Card[] bf){
        //this method will place cards in a space that corresponds 
        // to the index of player object
        for(int i=0; i<playerSet.length;i++){
        if(playerSet[i] ==null)
            continue;
        try {
            bf[i] = playerSet[i].cardHand.removefirstCard();
            System.out.println("Placed " + bf[i]);
        } catch (EmptyHandException ex) {}
        
    }
}


    /**
     * checks if players deck size is 0 
     * if it is theyre taken out of game
     * 
     * @return 
     */
    public boolean gameEnd() {
        
        for(int i =0;i<playerSet.length;i++){
            if(playerSet[i] ==null)
                continue;
            if(playerSet[i].playerDeck.size() == 0)
                playerSet[i] = null; 
        }
        if(numPlayers == 0)
            gameEnd = true;
        return gameEnd;
    }
    
    /**
     * occurs if players place cards of equivalent val
     * @param parts
     * @return 
     * player that wins 
     */
    
   
    
    
    public static void main(String args[]){
        Game gm = new War(2);
        //deck is created two players are added in array but not created
        gm.gameStart();
        //creates instances of players, puts cards in their decks
        gm.drawCard();
        //fills hand, which is defaulted to 5, can
        //be set to any number in constructor
        gm.turnEnd();
        //places card into field, rn set to first card in hand array(index 0)
        // no need for enum class, the index of the card is set to the value
        //and should reset for each suit so 2 of hearts should be lowest for
        //hearts with val of 2 but king of spade will be at 12
    }
    
    }
    

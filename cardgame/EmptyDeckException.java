/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

/**
 *
 * @author Fabrice Benoit
 */
class EmptyDeckException extends Exception {
    
    public EmptyDeckException(){
        super("Deck is empty");
    }
    public EmptyDeckException(String mess){
        super(mess);
    }
}

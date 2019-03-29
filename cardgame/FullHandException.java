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
class FullHandException extends Exception {

    public FullHandException() {
        super("Hand is full");
    }

    public FullHandException(String message) {
        super(message);
    }
    
}

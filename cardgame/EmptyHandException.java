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
class EmptyHandException extends Exception {

    public EmptyHandException() {
    super("Hand is empty");
    }

    public EmptyHandException(String message) {
        super(message);
    }
    
}

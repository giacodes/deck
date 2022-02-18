
package aedTrabalho_n2;

import static java.lang.Integer.toBinaryString;
import java.util.Scanner;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int n;
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("Insert number of cards in the deck (only even numbers accepted)_");
        n = input.nextInt();
        while( n < 2 || n > 52 || n % 2 != 0 ){
        
            System.out.println("Insert number of cards in the deck (only even numbers accepted)_");
            n = input.nextInt();
        
        }
        
        Deck deque = new Deck(n);
        Deck originalDeck = new Deck(n);
        
        System.out.println("---Testing In-Shuffle---");
        deque.inShuffle();
        System.out.print("Original deck: ");
        deque.printContents(originalDeck.getContents());
        System.out.print("Top half: ");
        deque.printContents(deque.getTopHalf());
        System.out.print("Bottom half: ");
        deque.printContents(deque.getBottomHalf());
        System.out.print("Shuffled: ");
        deque.printContents(deque.getContents());
        
        deque = new Deck(n);
        System.out.println("---Testing Out-Shuffle---");
        deque.outShuffle();
        System.out.print("Original deck: ");
        deque.printContents(originalDeck.getContents());
        System.out.print("Top half: ");
        deque.printContents(deque.getTopHalf());
        System.out.print("Bottom half: ");
        deque.printContents(deque.getBottomHalf());
        System.out.print("Shuffled: ");
        deque.printContents(deque.getContents());
        
        deque = new Deck(n);
        System.out.println("---Testing number of In-Shuffles to return to original order---");
        int i = 0;
        do{
            System.out.println("---Shuffle #" + ++i + "---");
            System.out.print("Original deck: ");
            deque.printContents(deque.getContents());
            deque.inShuffle();
            System.out.print("Top half: ");
            deque.printContents(deque.getTopHalf());
            System.out.print("Bottom half: ");
            deque.printContents(deque.getBottomHalf());
            System.out.print("Shuffled: ");
            deque.printContents(deque.getContents());
            
        }
        while(!deque.equals(originalDeck));
        System.out.print("It takes "+i+" in-shuffles to return a deck of "+n+" cards to its original deck\n");
        
        deque = new Deck(n);
        System.out.println("---Testing number of Out-Shuffles to return to original order---");
        i = 0;
        do{
            System.out.println("---Shuffle #" + ++i + "---");
            System.out.print("Original deck: ");
            deque.printContents(deque.getContents());
            deque.outShuffle();
            System.out.print("Top half: ");
            deque.printContents(deque.getTopHalf());
            System.out.print("Bottom half: ");
            deque.printContents(deque.getBottomHalf());
            System.out.print("Shuffled: ");
            deque.printContents(deque.getContents());
            
        }
        while(!deque.equals(originalDeck));
        System.out.print("It takes "+i+" out-shuffles to return a deck of "+n+" cards to its original deck\n");
        
        do{
            
            System.out.println("Insert position_ ");
            n = input.nextByte();
            
        }
        while(!( n > 0 && n < deque.getContents().size() ));
        
        System.out.println("---Testing shifting top card---");
        System.out.print("Original deck: ");
        deque.printContents(deque.getContents());
        System.out.println(n+" is equivalent to "+toBinaryString(n)+" in binary\n");
        deque.moveTop(n, true);
        
    }
    
}

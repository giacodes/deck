package aedTrabalho_n2;

import static java.lang.Integer.toBinaryString;
import java.util.Arrays;
import java.util.Iterator;

public class Deck implements Cloneable
{
    private ArrayDeque<Card> contents, topHalf, bottomHalf;

    
    public Deck() {
           
        this.contents = new ArrayDeque(52);
        for (var s : Suit.values()) {

           for(int i = 1; i <= 13; i++){
               
               Card c = new Card(s,i);
               try{
                   this.contents.addLast(c);
               }
               catch(Exception e){
                   System.out.println(e.getMessage());
               }
               
           }

       }
    } // end default constructor
    
    
    
    public Deck(int numberOfCards) {
        
        this.contents = new ArrayDeque(numberOfCards);
        Deck m = new Deck();
        
        
        for(int i = 0; i < numberOfCards; i++){
            
            try{
                this.contents.addLast(m.contents.removeFirst());
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        }
  
    } // end constructor
    /* Returns the contents of the deck.
    @return The contents of the deck. */
    
   public ArrayDeque<Card> getContents() {
        return contents;
    } 
   
   public ArrayDeque<Card> getTopHalf() {
        return topHalf;
    } 
   
   public ArrayDeque<Card> getBottomHalf() {
        return bottomHalf;
    } 

    public boolean nextShufler() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Method not implemented!"); 
    }
    
    public void splitDeck(Deck d) {
        
        int half = d.contents.size()/2;
            
        this.topHalf = new ArrayDeque(half);
        this.bottomHalf = new ArrayDeque(half);

        for(int j = 0; j < half; j++){

            try{
                topHalf.addLast(d.contents.removeFirst());
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        }
        
        
        for(int j = 0; j < half; j++){

            try{
                bottomHalf.addLast(d.contents.removeFirst());
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        }
        
        
    }
    
    // Performs a perfect in-shuffle.
    public void inShuffle() {
        
        splitDeck(this);
        Iterator<Card> itTop = topHalf.iterator();
        Iterator<Card> itBottom = bottomHalf.iterator();
        while(itBottom.hasNext() || itTop.hasNext()){
            this.contents.addLast(itBottom.next());
            this.contents.addLast(itTop.next());
        }
        
    } // end inShuffle 
    
    // Performs a perfect out-shuffle.
  
    public void outShuffle() {
        
        splitDeck(this);
        Iterator<Card> itTop = topHalf.iterator();
        Iterator<Card> itBottom = bottomHalf.iterator();
        while(itBottom.hasNext() || itTop.hasNext()){
            this.contents.addLast(itTop.next());
            this.contents.addLast(itBottom.next());
        }
        
    } // end outShuffle
    /* Shifts the top card of the deck a given number of positions down in the deck.
    @param position The number of positions to move the top card by.
    @param messages Whether or not messages should be displayed. */
   
    public void moveTop(int position, boolean messages) {
        
        String binary = toBinaryString(position);
        if(messages == true){
            
            for(int i = 0; i < binary.length(); i++){
                
                if(binary.charAt(i) == '1'){
                    
                    System.out.println("IN-SHUFFLE");
                    System.out.print("Original deck: ");
                    this.printContents(this.contents);
                    this.inShuffle();
                    System.out.print("Top half: ");
                    this.printContents(this.topHalf);
                    System.out.print("Bottom half: ");
                    this.printContents(this.bottomHalf);
                    System.out.print("Shuffled: ");
                    this.printContents(this.contents);
                    
                }
                else{
                    
                    System.out.println("OUT-SHUFFLE");
                    System.out.print("Original deck: ");
                    this.printContents(this.contents);
                    this.outShuffle();
                    System.out.print("Top half: ");
                    this.printContents(this.topHalf);
                    System.out.print("Bottom half: ");
                    this.printContents(this.bottomHalf);
                    System.out.print("Shuffled: ");
                    this.printContents(this.contents);
                    
                }
                
            }
            
            System.out.print("After the shift: ");
            this.printContents(this.contents);
            
        }
        else {
            
            for(int i = 0; i < binary.length(); i++){
                
                if(binary.charAt(i) == 1) this.inShuffle();
                else this.outShuffle();
                
            }
            
        }
        
    } // end shiftFirst
    
    public void printContents(ArrayDeque<Card> d){
        
        Iterator<Card> it = d.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
        System.out.println();
        
    }

    boolean equals(Deck b) {
        
        Iterator<Card> itThis = this.contents.iterator();
        Iterator<Card> itD = b.contents.iterator();
        while(itThis.hasNext()){
            if(!(itThis.next().getSuit() == itD.next().getSuit() && itThis.next().getValue() == itD.next().getValue())) return false;
        }
        return true;
        
    }
    
} // end Deck 

package Elevens;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//make a Deck class
class Deck {
	public static final int NUMCARDS = 52;
	public static final String[] SUITS = "CLUBS DIAMONDS HEARTS SPADES".split(" ");
	
	private List<Card> cards;
	private int top;

   //make a Deck constructor
   	//refer cards to new ArrayList
   	//set top to the top of the deck 51
   	
   	//loop through all suits
   		//loop through all faces 1 to 13
   			//add a new TwentyOneCard to the deck
        
        public Deck() {
            cards = new ArrayList();
            for (int i = 0; i < NUMCARDS; i++) {
                cards.add(new Card(SUITS[i/13], i%13+1));
            }
            top = NUMCARDS-1;
        }

   
   //make a dealCard() method that returns the top card
        public Card dealCard() {
            return cards.get(top--);
        }
   
   //write a shuffle() method
   	//use Colletions.shuffle
   	//reset the top card 
        public void shuffle() {
            Collections.shuffle(cards);
            top = NUMCARDS-1;
        }
}
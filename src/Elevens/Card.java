package Elevens;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};
        public static final String SUITS[] = {"CLUBS","DIAMONDS","HEARTS","SPADES"};

	//instance variables
		//String suit
		//int face
        private String suit;
        private int face;

  	//constructors
        public Card(String Suit, int Face) {
            suit = Suit;
            face = Face;
        }


	// modifiers
		//set methods
        

  	//accessors
		//get methods
        public String getSuit() {
            return suit;
        }
        public int getFace() {
            return face;
        }

  	//toString
        public String toString() {
            return suit + " of " + FACES[face];
        }
 }
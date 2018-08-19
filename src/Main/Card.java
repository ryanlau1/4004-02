package Main;
public class Card {
	private int rank;
	private int suit;
	private boolean showing = false;
	
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	//1 = diamond
	//2 = clubs
	//3 = hearts
	//4 = spade
	public int getSuit() {
		return this.suit;
	}	
	
	@Override
	public String toString() {
		String srank;
		String ssuit;		
		srank = rankToString(rank);
		ssuit = suitToString(suit);		
		return srank + " of " + ssuit;
	}
	
	public boolean getShowing(){
		return showing;
	}
	
	public void setShowing(boolean s){
		showing = s;
	}
	
	public boolean isHigher(Card c) {
		if(this.getRank() > c.getRank() || (this.getRank() == c.getRank() && this.getSuit() > c.getSuit()))
		    return true;
		else
		    return false;
	    }
	public String rankToString(int num){
		String srank ="";
		switch(num){
		case 2:
			srank = "Two";
			break;
		case 3:
			srank = "Three";
			break;
		case 4:
			srank = "Four";
			break;
		case 5:
			srank = "Five";
			break;
		case 6:
			srank = "Six";
			break;
		case 7:
			srank = "Seven";
			break;
		case 8:
			srank = "Eight";
			break;
		case 9:
			srank = "Nine";
			break;
		case 10:
			srank = "Ten";
			break;
		case 11:
			srank = "Jack";
			break;
		case 12:
			srank = "Queen";
			break;
		case 13:
			srank = "King";
			break;
		case 14:
			srank = "Ace";
			break;	
		case 0:
			srank = "?";
		
		}
		return srank;
	}
	
	public String suitToString(int num){
		String ssuit ="";
		switch(num){
		case 1:
			ssuit = "Diamonds";
			break;
		case 2:
			ssuit = "Clubs";
			break;
		case 3:
			ssuit = "Hearts";
			break;
		case 4:
			ssuit = "Spades";
			break;
		}
		return ssuit;
		
	}
}

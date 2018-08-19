package Main;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Deck {
	private List<Card> d;
	private Card top;
	
	//get instance of Deck
	private static class DeckHolder {
        private static final Deck INSTANCE = new Deck();
    }
	public static final Deck getInstance(){
		return DeckHolder.INSTANCE;
	}
	
	//Populate the deck with all 52 cards
	public Deck(){
		d = new ArrayList<Card>();
		for(int i = 2; i <= 14; i++){
			for(int j = 1; j <= 4; j++)
			{
				Card c = new Card(i,j);
				d.add(c);
				//System.out.println(c.toString());
			}
		}		
		Collections.shuffle(d);
	}
	//Get the size of the deck
	public int deckSize(){
		return d.size();
	}
	
	//Remove the top card from the deck
	public Card getTopCard(){
		top = d.get(0);
		return top;
	}
	
	public Card removeTopCard(){
		top = d.get(0);
		d.remove(0);
		return top;
	}
	
	public void removeCardAtIndex(int i){
		d.remove(i);
	}
	//Returns true if card is in deck
	public boolean checkIfInDeckAndRemove(Card c){
		for (int i = 0; i < d.size(); i++){
			if (c.getRank() == d.get(i).getRank() && c.getSuit() == d.get(i).getSuit()){
				removeCardAtIndex(i);
				return true;
			}
		}
		return false;
	}
	
	
	
}

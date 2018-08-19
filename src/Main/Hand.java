package Main;
import java.util.List;
import java.util.ArrayList;

public class Hand {
	private List<Card> h;
	private int hrank;
	
	//Get 5 random cards
	public Hand(Deck d){
		h = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			//d.getTopCard();
			Card c = d.removeTopCard();
			h.add(c);
			//System.out.println(c.toString());
		}
		evaluateHandRank();
	}
	
	//Get specific hand, and remove those cards from the deck
	public Hand(Deck d, List<Card> a){
		h = new ArrayList<Card>();
		//First, check if card is in the deck
		//If it is, add it to the hand
		for (int i = 0; i < 5; i++){
			if (d.checkIfInDeckAndRemove(a.get(i))){
				Card c = a.get(i);
				h.add(c);
			}
		}
		evaluateHandRank();
	}
	//Swap the cards in the positions
	//Pass in an array with 5 positions 	
	//If the card in that position is to be swapped, the value in the array is 1
	//Set the card to showing
	public void swapCard(int[] a, Deck d){
		for (int i = 0; i < a.length; i++){
			if (a[i] == 1){
				h.remove(i);
				h.add(i, d.removeTopCard());
				h.get(i).setShowing(true);				
			}
		}	
		//evaluateHandRank();
	}
	public List<Card> getShowingCards(){
		List<Card> temp = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			if (h.get(i).getShowing()){
				temp.add(h.get(i));
			}
		}
		sort(temp);
		return temp;
		
	}
	public void swapCardWithSpecific(int[] a, Deck d, List<Card> c){
		for (int i = 0; i < a.length; i++){
			if (a[i] == 1){
				h.remove(i);				
				d.checkIfInDeckAndRemove(c.get(i));
				h.add(i, c.get(i));
				h.get(i).setShowing(true);				
			}
		}	
	}
	
	public void swapSingleCardAtIndex(int i, Deck d, Card c){
		h.remove(i);
		d.checkIfInDeckAndRemove(c);
		h.add(i,c);
		h.get(i).setShowing(true);
	}
	
	//Get the rank of your cards
	public int getHandRank(){
		return hrank;
	}
	
	public List<Card> getCards(){
		return h;
	}
	public String whoWins(Hand b){
		if (betterHandRank(b) == 1){
			return "WIN";
		}
		if (betterHandRank(b) == 2){
			return "LOSE";
		}
		if (betterHandRank(b) == 3){
			return "TIE";
		}
		return "TIE";
	}
	//0 if tie
	//1 if win
	//2 if lose
	
	public int betterHandRank(Hand b){
		//If better hand
		if (hrank > b.getHandRank()){
			return 1;
		}
		//If worse hand
		else if (hrank < b.getHandRank()){
			return 2;
		}
		//If same hand, compare 
		else if (hrank == b.getHandRank()){
			return compareSameHand(b);
		}
		return 0;
	}
	//Method for finding rank
	public void sort(List<Card> a){
		Card temp;
		int minIndex;
		for(int i = 0; i < a.size(); i++) {
		    minIndex = i;
		    for(int j = i; j < a.size(); j++) {

			if(a.get(minIndex).isHigher(a.get(j)))
			    minIndex = j;
		    }
		    //swap the elements at i and j
		    temp = a.get(minIndex);
		    a.set(minIndex, a.get(i));
		    a.set(i, temp);
		}
	}
	
	//Find rank of cards
	public void evaluateHandRank(){
		List<Card> sorted;
		sorted = h;
		sort(sorted);
		
		hrank = 0;
		int pIndex = -1;
		
		//Checking for a pair
		for (int i = 0; i < 4; i++){
			if (sorted.get(i).getRank() == sorted.get(i+1).getRank()){
				pIndex = i;
				hrank = 1;
				i = 7;
			}
		}
		
		//Checking for 2 pair
		if(hrank == 1) {
		    for(int i = pIndex + 2; i < 4; i++)
			if(sorted.get(i).getRank() == sorted.get(i+1).getRank())
			    hrank = 2;
		}
		
		//Checking for 3 of a kind or full house
		for(int i = 0; i < 3; i++)
		{
			
		    if(sorted.get(i).getRank() == sorted.get(i+1).getRank() && sorted.get(i+1).getRank() == sorted.get(i+2).getRank()) 
		    {
		    	hrank = 3;
		    	if(i==0 && sorted.get(3).getRank()==sorted.get(4).getRank() || i==2 && sorted.get(0).getRank() == sorted.get(1).getRank())
		    	{
		    		hrank = 6;
		    	}
		   }
		}
		//Checking for 4 of a kind
		for(int i = 0; i < 2; i++)
		{
		    if(sorted.get(i).getRank() == sorted.get(i+1).getRank() && sorted.get(i+1).getRank() == sorted.get(i+2).getRank() &&
		    		sorted.get(i+2).getRank() == sorted.get(i+3).getRank()) {
		    	hrank = 7;
		    }
		}
		
		//Checking for a straight if no pairs
		//If pairs, not a straight!
		if(hrank == 0) 
		{
		    if((sorted.get(4).getRank() - sorted.get(0).getRank() == 4) ||
		       (sorted.get(3).getRank() - sorted.get(0).getRank() == 3 && sorted.get(4).getRank() == 14 && sorted.get(0).getRank() == 2)) {
		    	
		    	hrank = 4;
		    }
		}
		//check for flush if no pairs
		//If pairs, not a flush!
		boolean flush;
		if(hrank == 0 || hrank == 4) {
		    flush = true;
		    for(int i = 0; i < 4; i++)
			if(sorted.get(i).getSuit() != sorted.get(i+1).getSuit())
			    flush = false;
		    if(flush && hrank == 4)
			hrank = 8; //straight flush!
		    else if(flush)
			hrank = 5;
		}
		
		//Check for royal flush
		//If its a straight flush
		if(hrank == 8 && sorted.get(4).getRank() == 14 && sorted.get(0).getRank() == 10)
		    hrank = 9; //royal flush!
	    }
	
	public String getRankString(){
		String result = "";
		switch(hrank) {
		case 0:
		    result += "High Card";
		    break;
		case 1:
		    result += "Pair";
		    break;
		case 2:
		    result += "Two Pair";
		    break;
		case 3:
		    result += "Three of a Kind";
		    break;
		case 4:
		    result += "Straight";
		    break;
		case 5:
		    result += "Flush";
		    break;
		case 6:
		    result += "Full House";
		    break;
		case 7:
		    result += "Four of a Kind";
		    break;
		case 8:
		    result += "Straight Flush";
		    break;
		case 9:
		    result += "Royal Flush";
		    break;
		default:
		    result += "High Card";
		    break;
		
		}
		return result;
		
	}
	
	
	
	
	//0 if tie
	//1 if win
	//2 if lose
	public int compareSameHand(Hand b){
		List<Card> cb;
		cb = b.getCards();
		sort(cb);
		
		List<Card> sorted;
		sorted = h;
		sort(sorted);
		
		//If both are royal flushes, higher suit wins
		if (hrank == 9){
			if (sorted.get(4).getSuit() > cb.get(4).getSuit()){
				return 1;
			}
			else{
				return 2;
			}
		}
		//If both are straight flushes, higher suit wins
		else if (hrank == 8){
			if (sorted.get(4).getSuit() > cb.get(4).getSuit()){
				return 1;
			}
			else{
				return 2;
			}
			
		}
		//If we have two four of a kinds, higher rank wins		
		else if (hrank == 7){
			//when sorted, one member of the triple (or quad) will always be in the middle 
			if (sorted.get(2).getRank() > cb.get(2).getRank()){
				return 1;
			}
			else {
				return 2;
			}
			
		}
		//If we have two full houses, higher rank wins
		else if (hrank == 6){
			//when sorted, one member of the triple (or quad) will always be in the middle 
			if (sorted.get(2).getRank() > cb.get(2).getRank()){
				return 1;
			}
			else {
				return 2;
			}
			
		}
		//If both are flushes higher highest number wins
		//If they are the same number, repeat for second highest, then 3rd, etc.
		else if (hrank == 5){
				//If number is higher than opponent
				if (sorted.get(4).getRank() > cb.get(4).getRank()){
					return 1;
				}
				//If number is lower than opponent
				else if (sorted.get(4).getRank() < cb.get(4).getRank())
				{
					return 2;
				}
				else{
					if (sorted.get(4).getSuit() > cb.get(4).getSuit()){
						return 1;
					}
					else{
						return 2;
					}
				}
			}
			
			
				
		
		//If both are straight higher number wins
		//Same with straight flush and royal flush
		else if(hrank == 4){
			if (sorted.get(4).getRank() > cb.get(4).getRank()){
				return 1;
			}
			else if (sorted.get(4).getRank() < cb.get(4).getRank()){
				return 2;
			}
			else
			{
				if (sorted.get(4).getSuit() > cb.get(4).getSuit()){
					return 1;
				}
				else{
					return 2;
				}
			}				
			
		}
		//If both are 4 of a kind or 3 of a kind or a full house, higher rank wins
		else if(hrank == 3){
			
			//when sorted, one member of the triple (or quad) will always be in the middle 
			if (sorted.get(2).getRank() > cb.get(2).getRank()){
				return 1;
			}
			else {
				return 2;
			}
			//Impossible to tie here, can't have the same highest rank
		}
		
		//If two pair
		//Compare the highest pair, then the other pair
		else if (hrank == 2){
			//when sorted a member of the highest pair will always be in slot 4 of 5
			if (sorted.get(3).getRank() > cb.get(3).getRank()){
				return 1;
			}
			else if (sorted.get(3).getRank() < cb.get(3).getRank()){
				return 2;
			}
			//If both highest pairs are the same, compare the next pair
			else if (sorted.get(3).getRank() == cb.get(3).getRank()){
				//when sorted a member of the highest pair will always be in slot 2 of 5
				if (sorted.get(1).getRank() > cb.get(1).getRank()){
					return 1;
				}
				else if (sorted.get(1).getRank() < cb.get(1).getRank()){
					return 2;
				}
				//If both other pairs are the same, compare the last card
				else if (sorted.get(1).getRank() < cb.get(1).getRank()){
					int first = 0, second = 0;
					
					for (int i = 0; i < 4; i++){
						if (sorted.get(i).getRank() != sorted.get(i+1).getRank()){
							first = sorted.get(i).getRank();
						}
						if (cb.get(i).getRank() != cb.get(i+1).getRank()){
							second = sorted.get(i).getRank();
						}
					}
					
					if (first > second){
						return 1;
					}
					else if (first < second){
						return 2;
					}
					else{
						return 0;
					}
				}
			}
		}
		//If both are pairs
		else if (hrank == 1){
			int first = 0, second = 0;
			for (int i = 0; i < 4; i++){
				if (sorted.get(i).getRank() + 1 == sorted.get(i+1).getRank())
				{
					first = sorted.get(i).getRank();
				}
				if (cb.get(i).getRank() + 1 == cb.get(i+1).getRank())
				{
					second = sorted.get(i).getRank();
				}
				if (first != 0 && second != 0){
					i = 50;
				}
			}
			if (first > second){
				return 1;
			}
			else if (second > first)
			{
				return 2;
			}
		
			/**
			int first = 0, second = 0;
			
			for (int i = 0; i < 4; i++){
				if (sorted.get(i).getRank() == sorted.get(i+1).getRank()){
					first = sorted.get(i).getRank();
				}
				if (cb.get(i).getRank() == cb.get(i+1).getRank()){
					second = sorted.get(i).getRank();
				}
			}
			
			if (first > second){
				return 1;				
			}
			else if (first < second){
				return 2;
			}
			else{
				for (int i = 0; i < 4; i++){
					if (sorted.get(i).getRank() != sorted.get(i+1).getRank()){
						first = sorted.get(i).getRank();
					}
					if (cb.get(i).getRank() != cb.get(i+1).getRank()){
						second = sorted.get(i).getRank();
					}
				}
				if (first > second){
					return 1;				
				}
				else if (first < second){
					return 2;
				}
				else {
					return 0;
				}
			}*/
		
		}
		//If high card higher wins
		//If same high card, compare suit
		else if (hrank == 0){
			if (sorted.get(4).getRank() > cb.get(4).getRank()){
				return 1;
			}
			else if (sorted.get(4).getRank() < cb.get(4).getRank()){
				return 2;
			}
			else if (sorted.get(4).getSuit() > cb.get(4).getSuit()){
				return 1;
			}
			else if (sorted.get(4).getSuit() < cb.get(4).getSuit()){
				return 2;
			}
		}
		return 0;
	}
}
	


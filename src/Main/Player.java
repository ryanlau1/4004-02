package Main;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Player {
	private Hand h;
	private int strategy;
	
	public Player(Deck d){
		Random rand = new Random();
		h = new Hand(d);
		strategy = rand.nextInt(2) + 1;
	}
	
	public Player(Deck d, List<Card> c){
		h = new Hand(d, c);
		Random rand = new Random();		
		strategy = rand.nextInt(1) + 1;
	}
	
	public Player(Deck d, List<Card> c, int strat){
		h = new Hand(d, c);	
		strategy = strat;
	}
	public Hand getHand(){
		return h;
	}
	
	public List<Card> getCardsInHand(){
		return h.getCards();
	}
	
	public int getStrategy(){
		return strategy;
	}
	
	public void setHand(Hand h){
		this.h = h;
	}
	
	public void setStrategy(int a){
		strategy = a;
	}
}

package Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Main.Card;
import Main.Deck;
import Main.Game;
import Main.Player;

public class TestingStr2 {

	public Game g = new Game(); 
	@Test
	public void test1() {
		Deck de = new Deck();
		
		List<Card> a = new ArrayList<Card>();	
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();
		List<Card> d = new ArrayList<Card>();
		
		a.add(new Card (7,2));
		a.add(new Card (7,1));
		a.add(new Card (4,4));
		a.add(new Card (2,1));
		a.add(new Card (10,3));
		
		Player p1 = new Player(de, a, 2);
		p1.setStrategy(1);
		
		b.add(new Card (8,2));
		b.add(new Card (8,1));
		b.add(new Card (4,3));
		b.add(new Card (12,2));
		b.add(new Card (9,2));
		
		Player p2 = new Player(de, b, 2);
		p2.setStrategy(1);
		
		c.add(new Card (7,4));
		c.add(new Card (9,4));
		c.add(new Card (7,3));
		c.add(new Card (9,3));
		c.add(new Card (4,2));
		
		Player p3 = new Player(de, c, 2);
		p3.setStrategy(1);
		
		d.add(new Card(13,4));
		d.add(new Card(12,4));
		d.add(new Card(3,2));
		d.add(new Card(6,2));
		d.add(new Card(5,1));
		
		Player p4 = new Player(de, d, 2);
		p4.setStrategy(1);
		
		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();
		List<Card> nextCards3 = new ArrayList<Card>();
		List<Card> nextCards4 = new ArrayList<Card>();
		
		nextCards1.add(new Card(2,1));
		nextCards1.add(new Card(4,2));
		nextCards1.add(new Card(5,3));
		
		nextCards3.add(new Card(3,3));
		
		nextCards2.add(new Card(10,1));
		nextCards2.add(new Card(5,3));
		nextCards2.add(new Card(3,1));
		
		nextCards4.add(new Card(14,4));
		nextCards4.add(new Card(10,4));
		nextCards4.add(new Card(11,4));
		
		List<Integer> indexes = new ArrayList<Integer>();
		List<Card> ce = p1.getHand().getCards();
		
		//Pair member must exist at index 1 or 3, when sorted
		if (ce.get(1).getRank() != ce.get(0).getRank() && ce.get(1).getRank() != ce.get(2).getRank()){
			indexes.add(0);
			indexes.add(1);
			if (ce.get(2).getRank() != ce.get(3).getRank()){
				indexes.add(2);
			}
			else if (ce.get(4).getRank() != ce.get(3).getRank()){
				indexes.add(4);				
			}
			
		}
		else if (ce.get(3).getRank() != ce.get(4).getRank() && ce.get(3).getRank() != ce.get(2).getRank()){
			indexes.add(4);
			indexes.add(3);
			if (ce.get(1).getRank() != ce.get(2).getRank()){
				indexes.add(2);
			}
			else if (ce.get(1).getRank() != ce.get(0).getRank()){
				indexes.add(3);				
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			p1.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards1.get(i));
		}
		p1.getHand().evaluateHandRank();
		assertEquals("Pair",p1.getHand().getRankString());
		
		indexes.clear();
		ce = p2.getHand().getCards();
	
		//Pair member must exist at index 1 or 3, when sorted
		if (ce.get(1).getRank() != ce.get(0).getRank() && ce.get(1).getRank() != ce.get(2).getRank()){
			indexes.add(0);
			indexes.add(1);
			if (ce.get(2).getRank() != ce.get(3).getRank()){
				indexes.add(2);
			}
			else if (ce.get(4).getRank() != ce.get(3).getRank()){
				indexes.add(4);				
			}
			
		}
		
		else if (ce.get(3).getRank() != ce.get(4).getRank() && ce.get(3).getRank() != ce.get(2).getRank()){
			indexes.add(4);
			indexes.add(3);
			if (ce.get(1).getRank() != ce.get(2).getRank()){
				indexes.add(2);
			}
			else if (ce.get(1).getRank() != ce.get(0).getRank()){
				indexes.add(3);				
			}
		}
		
		for (int i = 0; i < indexes.size(); i++){
			p2.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards2.get(i));
		}
		p2.getHand().evaluateHandRank();
		assertEquals("Pair",p2.getHand().getRankString());
		
		
		indexes.clear();
		ce = p3.getHand().getCards();
		
		if (ce.get(1).getRank() != ce.get(0).getRank()){
			indexes.add(0);
		}
		else if (ce.get(1).getRank() != ce.get(2).getRank()){
			indexes.add(2);
		}
		else if (ce.get(3).getRank() != ce.get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			p3.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards3.get(i));
		}
		
		p3.getHand().evaluateHandRank();
		
		indexes.clear();
		
		p4.getHand().sort(p4.getCardsInHand());
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		for (int i = 0; i < indexes.size(); i++){
			p4.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards4.get(i));
		}
		p4.getHand().evaluateHandRank();
		
		assertEquals("Royal Flush", p4.getHand().getRankString());
		assertEquals("Pair", p2.getHand().getRankString());
		assertEquals("Pair", p1.getHand().getRankString());
		assertEquals("Two Pair", p3.getHand().getRankString());
		
		assertEquals("LOSE",p1.getHand().whoWins(p4.getHand()));
		assertEquals("LOSE",p1.getHand().whoWins(p3.getHand()));
		assertEquals("WIN",p1.getHand().whoWins(p2.getHand()));
		assertEquals("LOSE", p2.getHand().whoWins(p4.getHand()));
		assertEquals("LOSE", p3.getHand().whoWins(p4.getHand()));
	}
	
	@Test
	public void test2(){
		Deck de = new Deck();
		
		List<Card> a = new ArrayList<Card>();	
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();
		List<Card> d = new ArrayList<Card>();
		
		a.add(new Card (7,2));
		a.add(new Card (7,1));
		a.add(new Card (4,4));
		a.add(new Card (2,1));
		a.add(new Card (10,3));
		
		Player p1 = new Player(de, a, 2);
		p1.setStrategy(1);
		b.add(new Card (14,4));
		b.add(new Card (12,4));
		b.add(new Card (4,3));
		b.add(new Card (12,2));
		b.add(new Card (9,2));
		
		Player p2 = new Player(de, b, 2);
		
		c.add(new Card (8,4));
		c.add(new Card (8,1));
		c.add(new Card (8,2));
		c.add(new Card (2,3));
		c.add(new Card (6,4));
		
		Player p3 = new Player(de, c, 2);
		
		
		d.add(new Card(13,4));
		d.add(new Card(13,2));
		d.add(new Card(13,1));
		d.add(new Card(13,3));
		d.add(new Card(5,1));
		
		Player p4 = new Player(de, d, 2);
		
		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();
		List<Card> nextCards3 = new ArrayList<Card>();
		List<Card> nextCards4 = new ArrayList<Card>();
		
		nextCards1.add(new Card(9,1));
		nextCards1.add(new Card(9,2));
		nextCards1.add(new Card(9,3));
		
		nextCards3.add(new Card(3,3));
		nextCards3.add(new Card(8,3));
		
		nextCards2.add(new Card(10,1));
		nextCards2.add(new Card(5,3));
		nextCards2.add(new Card(3,1));
		nextCards2.add(new Card(4,2));
		
		List<Integer> indexes = new ArrayList<Integer>();
		List<Card> ce = p1.getHand().getCards();
		
		//Pair member must exist at index 1 or 3, when sorted
		if (ce.get(1).getRank() != ce.get(0).getRank() && ce.get(1).getRank() != ce.get(2).getRank()){
			indexes.add(0);
			indexes.add(1);
			if (ce.get(2).getRank() != ce.get(3).getRank()){
				indexes.add(2);
			}
			else if (ce.get(4).getRank() != ce.get(3).getRank()){
				indexes.add(4);				
			}
			
		}
		else if (ce.get(3).getRank() != ce.get(4).getRank() && ce.get(3).getRank() != ce.get(2).getRank()){
			indexes.add(4);
			indexes.add(3);
			if (ce.get(1).getRank() != ce.get(2).getRank()){
				indexes.add(2);
			}
			else if (ce.get(1).getRank() != ce.get(0).getRank()){
				indexes.add(3);				
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			p1.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards1.get(i));
		}
		p1.getHand().evaluateHandRank();
		assertEquals("Full House",p1.getHand().getRankString());
		
		indexes.clear();
		ce = p2.getHand().getCards();
		
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		indexes.add(3);
		for (int i = 0; i < indexes.size(); i++){
			p2.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards2.get(i));
		}
		
		p2.getHand().evaluateHandRank();
		assertEquals("High Card", p2.getHand().getRankString());
		
		indexes.clear();
		ce = p3.getHand().getCards();
		
		if (ce.get(2).getRank() != ce.get(3).getRank()){
			indexes.add(3);
			indexes.add(4);
		}
		else if (ce.get(3).getRank() != ce.get(4).getRank()){
			indexes.add(4);
			indexes.add(0);
			
		}
		else if (ce.get(2).getRank() != ce.get(1).getRank()){
			indexes.add(1);
			indexes.add(0);
		}
		else if (ce.get(0).getRank() != ce.get(1).getRank()){
			indexes.add(4);
			indexes.add(0);
		}
		//ha.swapCardWithSpecific(array, d, nextCards1);
		for (int i = 0; i < indexes.size(); i++){
			p3.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards3.get(i));
		}
		
		p3.getHand().evaluateHandRank();
		assertEquals("Four of a Kind", p3.getHand().getRankString());
		
		p4.getHand().evaluateHandRank();
		assertEquals("Four of a Kind", p4.getHand().getRankString());
		
		assertEquals("WIN", p4.getHand().whoWins(p3.getHand()));
		assertEquals("WIN", p4.getHand().whoWins(p2.getHand()));
		assertEquals("WIN", p4.getHand().whoWins(p1.getHand()));
		assertEquals("LOSE", p2.getHand().whoWins(p3.getHand()));
		assertEquals("LOSE", p1.getHand().whoWins(p3.getHand()));
		assertEquals("WIN", p1.getHand().whoWins(p2.getHand()));
	}
	
	@Test
	public void test3(){
		Deck de = new Deck();
		
		List<Card> a = new ArrayList<Card>();	
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();
		List<Card> d = new ArrayList<Card>();
		
		a.add(new Card (7,2));
		a.add(new Card (7,1));
		a.add(new Card (4,4));
		a.add(new Card (2,1));
		a.add(new Card (10,3));
		
		Player p1 = new Player(de, a, 2);
		p1.setStrategy(1);
		
		b.add(new Card (7,4));
		b.add(new Card (7,3));
		b.add(new Card (4,3));
		b.add(new Card (12,2));
		b.add(new Card (6,2));
		
		Player p2 = new Player(de, b, 2);
		p2.setStrategy(1);
		
		c.add(new Card (8,4));
		c.add(new Card (8,1));
		c.add(new Card (8,2));
		c.add(new Card (2,3));
		c.add(new Card (6,4));
		
		Player p3 = new Player(de, c, 2);
		
		
		d.add(new Card(13,4));
		d.add(new Card(14,4));
		d.add(new Card(11,4));
		d.add(new Card(12,4));
		d.add(new Card(10,4));
		
		Player p4 = new Player(de, d, 2);
		
		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();
		List<Card> nextCards3 = new ArrayList<Card>();
		List<Card> nextCards4 = new ArrayList<Card>();
		
		nextCards1.add(new Card(13,2));
		nextCards1.add(new Card(4,3));
		nextCards1.add(new Card(6,3));
		
		nextCards2.add(new Card(9,1));
		nextCards2.add(new Card(9,2));
		nextCards2.add(new Card(9,3));
		
		nextCards3.add(new Card(8,3));
		nextCards3.add(new Card(11,2));
		
		List<Integer> indexes = new ArrayList<Integer>();
		List<Card> ce = p1.getHand().getCards();
		
		//Pair member must exist at index 1 or 3, when sorted
		if (ce.get(1).getRank() != ce.get(0).getRank() && ce.get(1).getRank() != ce.get(2).getRank()){
			indexes.add(0);
			indexes.add(1);
			if (ce.get(2).getRank() != ce.get(3).getRank()){
				indexes.add(2);
			}
			else if (ce.get(4).getRank() != ce.get(3).getRank()){
				indexes.add(4);				
			}
			
		}
		else if (ce.get(3).getRank() != ce.get(4).getRank() && ce.get(3).getRank() != ce.get(2).getRank()){
			indexes.add(4);
			indexes.add(3);
			if (ce.get(1).getRank() != ce.get(2).getRank()){
				indexes.add(2);
			}
			else if (ce.get(1).getRank() != ce.get(0).getRank()){
				indexes.add(3);				
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			p1.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards1.get(i));
		}
		p1.getHand().evaluateHandRank();
		assertEquals("Pair",p1.getHand().getRankString());
		
		 indexes.clear();
		 ce = p2.getHand().getCards();
		 
		 if (ce.get(1).getRank() != ce.get(0).getRank() && ce.get(1).getRank() != ce.get(2).getRank()){
				indexes.add(0);
				indexes.add(1);
				if (ce.get(2).getRank() != ce.get(3).getRank()){
					indexes.add(2);
				}
				else if (ce.get(4).getRank() != ce.get(3).getRank()){
					indexes.add(4);				
				}
				
			}
			else if (ce.get(3).getRank() != ce.get(4).getRank() && ce.get(3).getRank() != ce.get(2).getRank()){
				indexes.add(4);
				indexes.add(3);
				if (ce.get(1).getRank() != ce.get(2).getRank()){
					indexes.add(2);
				}
				else if (ce.get(1).getRank() != ce.get(0).getRank()){
					indexes.add(3);				
				}
			}
			for (int i = 0; i < indexes.size(); i++){
				p2.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards2.get(i));
			}
			p2.getHand().evaluateHandRank();
			assertEquals("Full House",p2.getHand().getRankString());
			
			
			indexes.clear();
			ce = p3.getHand().getCards();
			
			if (ce.get(2).getRank() != ce.get(3).getRank()){
				indexes.add(3);
				indexes.add(4);
			}
			else if (ce.get(3).getRank() != ce.get(4).getRank()){
				indexes.add(4);
				indexes.add(0);
				
			}
			else if (ce.get(2).getRank() != ce.get(1).getRank()){
				indexes.add(1);
				indexes.add(0);
			}
			else if (ce.get(0).getRank() != ce.get(1).getRank()){
				indexes.add(4);
				indexes.add(0);
			}
			//ha.swapCardWithSpecific(array, d, nextCards1);
			for (int i = 0; i < indexes.size(); i++){
				p3.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards3.get(i));
			}
			
			p3.getHand().evaluateHandRank();
			assertEquals("Four of a Kind", p3.getHand().getRankString());
			
			p4.getHand().evaluateHandRank();
			assertEquals("Royal Flush", p4.getHand().getRankString());
			
			assertEquals("LOSE", p3.getHand().whoWins(p4.getHand()));
			assertEquals("LOSE", p1.getHand().whoWins(p4.getHand()));
			assertEquals("LOSE", p2.getHand().whoWins(p4.getHand()));
			assertEquals("WIN", p3.getHand().whoWins(p2.getHand()));
			assertEquals("WIN", p3.getHand().whoWins(p1.getHand()));
			assertEquals("LOSE", p1.getHand().whoWins(p2.getHand()));
	}
	
	@Test
	public void test4(){
		Deck de = new Deck();
		
		List<Card> a = new ArrayList<Card>();	
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();
		List<Card> d = new ArrayList<Card>();
		
		a.add(new Card (7,2));
		a.add(new Card (7,4));
		a.add(new Card (4,4));
		a.add(new Card (2,1));
		a.add(new Card (10,3));
		
		Player p1 = new Player(de, a, 2);
		p1.setStrategy(1);
		
		b.add(new Card (8,2));
		b.add(new Card (8,1));
		b.add(new Card (4,3));
		b.add(new Card (12,2));
		b.add(new Card (6,2));
		
		Player p2 = new Player(de, b, 2);
		p2.setStrategy(1);
		
		c.add(new Card (5,2));
		c.add(new Card (5,3));
		c.add(new Card (8,3));
		c.add(new Card (2,3));
		c.add(new Card (6,4));
		
		Player p3 = new Player(de, c, 2);
		p3.setStrategy(1);
		
		d.add(new Card(13,4));
		d.add(new Card(11,1));
		d.add(new Card(3,4));
		d.add(new Card(10,4));
		d.add(new Card(7,1)); 
		
		Player p4 = new Player(de, d, 2);
		
		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();
		List<Card> nextCards3 = new ArrayList<Card>();
		List<Card> nextCards4 = new ArrayList<Card>();
		
		nextCards1.add(new Card(13,2));
		nextCards1.add(new Card(5,1));
		nextCards1.add(new Card(6,3));
		
		nextCards2.add(new Card(13,1));
		nextCards2.add(new Card(2,2));
		nextCards2.add(new Card(12,3));
		
		nextCards3.add(new Card(9,1));
		nextCards3.add(new Card(9,2));
		nextCards3.add(new Card(9,3));
		
		nextCards4.add(new Card(14,1));
		nextCards4.add(new Card(12,1));
		nextCards4.add(new Card(9,4));
		nextCards4.add(new Card(8,4));
		
		List<Integer> indexes = new ArrayList<Integer>();
		List<Card> ce = p1.getHand().getCards();
		
		//Pair member must exist at index 1 or 3, when sorted
		if (ce.get(1).getRank() != ce.get(0).getRank() && ce.get(1).getRank() != ce.get(2).getRank()){
			indexes.add(0);
			indexes.add(1);
			if (ce.get(2).getRank() != ce.get(3).getRank()){
				indexes.add(2);
			}
			else if (ce.get(4).getRank() != ce.get(3).getRank()){
				indexes.add(4);				
			}
			
		}
		else if (ce.get(3).getRank() != ce.get(4).getRank() && ce.get(3).getRank() != ce.get(2).getRank()){
			indexes.add(4);
			indexes.add(3);
			if (ce.get(1).getRank() != ce.get(2).getRank()){
				indexes.add(2);
			}
			else if (ce.get(1).getRank() != ce.get(0).getRank()){
				indexes.add(3);				
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			p1.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards1.get(i));
		}
		p1.getHand().evaluateHandRank();
		assertEquals("Pair",p1.getHand().getRankString());
		
		
		indexes.clear();
		 ce = p2.getHand().getCards();
		 
		 if (ce.get(1).getRank() != ce.get(0).getRank() && ce.get(1).getRank() != ce.get(2).getRank()){
				indexes.add(0);
				indexes.add(1);
				if (ce.get(2).getRank() != ce.get(3).getRank()){
					indexes.add(2);
				}
				else if (ce.get(4).getRank() != ce.get(3).getRank()){
					indexes.add(4);				
				}
				
			}
			else if (ce.get(3).getRank() != ce.get(4).getRank() && ce.get(3).getRank() != ce.get(2).getRank()){
				indexes.add(4);
				indexes.add(3);
				if (ce.get(1).getRank() != ce.get(2).getRank()){
					indexes.add(2);
				}
				else if (ce.get(1).getRank() != ce.get(0).getRank()){
					indexes.add(3);				
				}
			}
			for (int i = 0; i < indexes.size(); i++){
				p2.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards2.get(i));
			}
			p2.getHand().evaluateHandRank();
			assertEquals("Pair",p2.getHand().getRankString());
			
			
			indexes.clear();
			ce = p3.getHand().getCards();
			
			//Pair member must exist at index 1 or 3, when sorted
			if (ce.get(1).getRank() != ce.get(0).getRank() && ce.get(1).getRank() != ce.get(2).getRank()){
				indexes.add(0);
				indexes.add(1);
				if (ce.get(2).getRank() != ce.get(3).getRank()){
					indexes.add(2);
				}
				else if (ce.get(4).getRank() != ce.get(3).getRank()){
					indexes.add(4);				
				}
				
			}
			else if (ce.get(3).getRank() != ce.get(4).getRank() && ce.get(3).getRank() != ce.get(2).getRank()){
				indexes.add(4);
				indexes.add(3);
				if (ce.get(1).getRank() != ce.get(2).getRank()){
					indexes.add(2);
				}
				else if (ce.get(1).getRank() != ce.get(0).getRank()){
					indexes.add(3);				
				}
			}
			for (int i = 0; i < indexes.size(); i++){
				p3.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards3.get(i));
			}
			p3.getHand().evaluateHandRank();
			assertEquals("Two Pair",p3.getHand().getRankString());
			
			
			indexes.clear();
			ce = p4.getHand().getCards();
			
			indexes.add(0);
			indexes.add(1);
			indexes.add(2);
			indexes.add(3);
			for (int i = 0; i < indexes.size(); i++){
				p4.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards4.get(i));
			}
			
			p4.getHand().evaluateHandRank();
			assertEquals("High Card", p4.getHand().getRankString());
	}
	
	@Test
	public void test5(){
		Deck de = new Deck();
		
		List<Card> a = new ArrayList<Card>();	
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();
		List<Card> d = new ArrayList<Card>();
		
		a.add(new Card (7,2));
		a.add(new Card (7,4));
		a.add(new Card (4,4));
		a.add(new Card (2,1));
		a.add(new Card (10,3));
		
		Player p1 = new Player(de, a, 2);
		p1.setStrategy(1);
		
		b.add(new Card (6,2));
		b.add(new Card (8,1));
		b.add(new Card (4,3));
		b.add(new Card (12,2));
		b.add(new Card (6,3));
		
		Player p2 = new Player(de, b, 2);
		
		c.add(new Card (5,2));
		c.add(new Card (5,3));
		c.add(new Card (8,3));
		c.add(new Card (2,3));
		c.add(new Card (6,4));
		
		Player p3 = new Player(de, c, 2);
		
		d.add(new Card(13,4));
		d.add(new Card(11,1));
		d.add(new Card(3,2));
		d.add(new Card(10,2));
		d.add(new Card(10,1)); 
		
		Player p4 = new Player(de, d, 2);
		
		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();
		List<Card> nextCards3 = new ArrayList<Card>();
		List<Card> nextCards4 = new ArrayList<Card>();
		
		nextCards1.add(new Card(9,2));
		nextCards1.add(new Card(9,1));
		nextCards1.add(new Card(9,3));
		
		nextCards2.add(new Card(13,1));
		nextCards2.add(new Card(2,2));
		nextCards2.add(new Card(12,3));
		
		nextCards3.add(new Card(11,2));
		nextCards3.add(new Card(11,3));
		nextCards3.add(new Card(11,4));
		
		nextCards4.add(new Card(13,2));
		nextCards4.add(new Card(10,4));
		nextCards4.add(new Card(13,3));
		
		List<Integer> indexes = new ArrayList<Integer>();
		List<Card> ce = p1.getHand().getCards();
		
		//Pair member must exist at index 1 or 3, when sorted
		if (ce.get(1).getRank() != ce.get(0).getRank() && ce.get(1).getRank() != ce.get(2).getRank()){
			indexes.add(0);
			indexes.add(1);
			if (ce.get(2).getRank() != ce.get(3).getRank()){
				indexes.add(2);
			}
			else if (ce.get(4).getRank() != ce.get(3).getRank()){
				indexes.add(4);				
			}
			
		}
		else if (ce.get(3).getRank() != ce.get(4).getRank() && ce.get(3).getRank() != ce.get(2).getRank()){
			indexes.add(4);
			indexes.add(3);
			if (ce.get(1).getRank() != ce.get(2).getRank()){
				indexes.add(2);
			}
			else if (ce.get(1).getRank() != ce.get(0).getRank()){
				indexes.add(3);				
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			p1.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards1.get(i));
		}
		p1.getHand().evaluateHandRank();
		assertEquals("Full House",p1.getHand().getRankString());
		
		
		indexes.clear();
		ce = p2.getHand().getCards();
		//Pair member must exist at index 1 or 3, when sorted
		if (ce.get(1).getRank() != ce.get(0).getRank() && ce.get(1).getRank() != ce.get(2).getRank()){
			indexes.add(0);
			indexes.add(1);
			if (ce.get(2).getRank() != ce.get(3).getRank()){
				indexes.add(2);
			}
			else if (ce.get(4).getRank() != ce.get(3).getRank()){
				indexes.add(4);				
			}
			
		}
		else if (ce.get(3).getRank() != ce.get(4).getRank() && ce.get(3).getRank() != ce.get(2).getRank()){
			indexes.add(4);
			indexes.add(3);
			if (ce.get(1).getRank() != ce.get(2).getRank()){
				indexes.add(2);
			}
			else if (ce.get(1).getRank() != ce.get(0).getRank()){
				indexes.add(3);				
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			p2.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards2.get(i));
		}
		p2.getHand().evaluateHandRank();
		assertEquals("Pair",p2.getHand().getRankString());
			
			
		indexes.clear();
		ce = p3.getHand().getCards();
		
		//Pair member must exist at index 1 or 3, when sorted
		if (ce.get(1).getRank() != ce.get(0).getRank() && ce.get(1).getRank() != ce.get(2).getRank()){
			indexes.add(0);
			indexes.add(1);
			if (ce.get(2).getRank() != ce.get(3).getRank()){
				indexes.add(2);
			}
			else if (ce.get(4).getRank() != ce.get(3).getRank()){
				indexes.add(4);				
			}
			
		}
		else if (ce.get(3).getRank() != ce.get(4).getRank() && ce.get(3).getRank() != ce.get(2).getRank()){
			indexes.add(4);
			indexes.add(3);
			if (ce.get(1).getRank() != ce.get(2).getRank()){
				indexes.add(2);
			}
			else if (ce.get(1).getRank() != ce.get(0).getRank()){
				indexes.add(3);				
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			p3.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards3.get(i));
		}
		p3.getHand().evaluateHandRank();
		assertEquals("Two Pair",p3.getHand().getRankString());
		
		
		indexes.clear();
		ce = p4.getHand().getCards();
		
		//Pair member must exist at index 1 or 3, when sorted
		if (ce.get(1).getRank() != ce.get(0).getRank() && ce.get(1).getRank() != ce.get(2).getRank()){
			indexes.add(0);
			indexes.add(1);
			if (ce.get(2).getRank() != ce.get(3).getRank()){
				indexes.add(2);
			}
			else if (ce.get(4).getRank() != ce.get(3).getRank()){
				indexes.add(4);				
			}
			
		}
		else if (ce.get(3).getRank() != ce.get(4).getRank() && ce.get(3).getRank() != ce.get(2).getRank()){
			indexes.add(4);
			indexes.add(3);
			if (ce.get(1).getRank() != ce.get(2).getRank()){
				indexes.add(2);
			}
			else if (ce.get(1).getRank() != ce.get(0).getRank()){
				indexes.add(3);				
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			p4.getHand().swapSingleCardAtIndex(indexes.get(i), de, nextCards4.get(i));
		}
		p4.getHand().evaluateHandRank();
		assertEquals("Two Pair",p4.getHand().getRankString());
				
		
	}

}

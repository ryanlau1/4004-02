package Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Main.Deck;
import Main.Game;
import Main.Hand;
import Main.Card;

public class TestingStr1 {

	//TESTING
	//STRATEGY
	//1

	//For numbers 
	//14 Represents Ace
	//13 King
	//12 Queen
	//11 Jack
	//10 Ten
	//..
	//2 Two

	//For suits
	//4 represents Spades
	//3 Hearts
	//2 Clubs
	//1 Diamonds

	@Test
	//1) Testing that with two identical hands and matching high cards
	//that Spades (player 1) beats Hearts. Also tests card sorting.
	public void test1() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();	
		List<Card> b = new ArrayList<Card>();
		a.add(new Card(14,4));
		a.add(new Card(12,4));
		a.add(new Card(11,4));
		a.add(new Card(13,4));
		a.add(new Card(10,4));
		b.add(new Card(14,3));
		b.add(new Card(13,3));
		b.add(new Card(12,3));
		b.add(new Card(11,3));
		b.add(new Card(10,3));
		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//2) Testing that with Two Identical Hands and matching high cards
	//that Tie broken with Spades (player 2) beating Clubs
	public void test2() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,2));
			b.add(new Card(14-i,4));			
		}
		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//3) Testing that with Two Identical Hands and matching high cards
	//Tie broken with Spades (player 1) beating Diamonds
	public void test3() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,4));
			b.add(new Card(14-i,1));			
		}
		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		assertEquals("WIN", ha.whoWins(hb));
	}
	@Test
	//4) Testing that with Two Identical Hands and matching high cards
	//Tie broken with Hearts (player 2) beating Clubs
	public void test4() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,2));
			b.add(new Card(14-i,3));			
		}
		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		assertEquals("LOSE", ha.whoWins(hb));
	}
	@Test
	//5) Testing that with Two Identical Hands and matching high cards
	//Tie broken with Hearts (player 2) beating Diamonds
	public void test5() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,1));
			b.add(new Card(14-i,3));			
		}
		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		assertEquals("LOSE", ha.whoWins(hb));
	}
	@Test
	//6) Testing that Two Identical Hands and matching high cards
	//Tie broken with Clubs (player 1) beating Diamonds
	public void test6() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,2));
			b.add(new Card(14-i,1));			
		}
		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	// Testing that Royal Flush (player 1) Beats Straight Flush
	public void test7() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,2));
			b.add(new Card(14-i,1));			
		}
		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//8) Testing that Royal Flush (player 1) Beats 4 of a kind
	public void test8() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,2));		
		}
		b.add(new Card(9,3));
		b.add(new Card(9,1));
		b.add(new Card(9,2));
		b.add(new Card(9,4));
		b.add(new Card(4,3));
		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//9) Testing that Royal Flush (player 1) Beats Full House (whose detection is checked)
	public void test9() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,2));		
		}
		b.add(new Card(9,3));
		b.add(new Card(9,1));
		b.add(new Card(9,2));
		b.add(new Card(4,4));
		b.add(new Card(4,3));
		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//10) Testing that Royal Flush (player 2) Beats Flush
	public void test10() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			b.add(new Card(14-i,2));		
		}
		a.add(new Card(2,3));
		a.add(new Card(9,3));
		a.add(new Card(7,3));
		a.add(new Card(5,3));
		a.add(new Card(4,3));
		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//11) Testing that Royal Flush (player 1) Beats Straight
	public void test11() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,2));		
		}
		b.add(new Card(7,4));
		b.add(new Card(8,3));
		b.add(new Card(6,1));
		b.add(new Card(5,3));
		b.add(new Card(4,3));
		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//12) Testing that Royal Flush (p1) Beats 3 of a kind, there is an exchange since 3 of a kind requires an exchange (of the 2 other cards)
	public void test12() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,2));		
		}
		b.add(new Card(9,2));
		b.add(new Card(9,3));
		b.add(new Card(9,1));
		b.add(new Card(7,4));
		b.add(new Card(8,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(13, 1));
		nextCards.add(new Card(11, 4));

		List<Integer> indexes = new ArrayList<Integer>();
		//Start at 2 middle

		//If third and fourth element arent the same add fourth and fifth, first three are 3 pair
		if (ha.getCards().get(2).getRank() != ha.getCards().get(3).getRank()){
			indexes.add(3);
			indexes.add(4);
		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank()){
			indexes.add(4);
			indexes.add(0);

		}
		else if (ha.getCards().get(2).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(1);
			indexes.add(0);
		}
		else if (ha.getCards().get(0).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(4);
			indexes.add(0);
		}
		//ha.swapCardWithSpecific(array, d, nextCards1);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//13) Testing that Royal Flush (p1) Beats 2 pairs, there is an exchange since 2 pairs requires an exchange
	public void test13() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,2));		
		}
		b.add(new Card(9,4));
		b.add(new Card(9,3));
		b.add(new Card(10,1));
		b.add(new Card(10,3));
		b.add(new Card(14,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		List<Card> nextCards1 = new ArrayList<Card>();
		//Diamond king
		nextCards1.add(new Card(13, 1));

		List<Integer> indexes = new ArrayList<Integer>();
		//All 2 pairs when sorted will have a member of a pair in slot 2 of 5 and slot 4 of 5
		if (hb.getCards().get(1).getRank() != hb.getCards().get(0).getRank()){
			indexes.add(0);
		}
		else if (hb.getCards().get(1).getRank() != hb.getCards().get(2).getRank()){
			indexes.add(2);
		}
		else if (hb.getCards().get(3).getRank() != hb.getCards().get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}
		hb.evaluateHandRank();
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//14) Testing that Royal Flush (p1) Beats full house obtained after	with 2 pairs
	public void test14() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,2));		
		}
		b.add(new Card(9,4));
		b.add(new Card(9,3));
		b.add(new Card(10,1));
		b.add(new Card(10,3));
		b.add(new Card(14,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		List<Card> nextCards1 = new ArrayList<Card>();
		//Diamond king
		nextCards1.add(new Card(10, 2));

		List<Integer> indexes = new ArrayList<Integer>();
		//All 2 pairs when sorted will have a member of a pair in slot 2 of 5 and slot 4 of 5
		if (hb.getCards().get(1).getRank() != hb.getCards().get(0).getRank()){
			indexes.add(0);
		}
		else if (hb.getCards().get(1).getRank() != hb.getCards().get(2).getRank()){
			indexes.add(2);
		}
		else if (hb.getCards().get(3).getRank() != hb.getCards().get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}		
		hb.evaluateHandRank();
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//15) Testing that Royal Flush (p1) Beats 1 pair, which requires an	exchange
	public void test15() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,2));		
		}
		b.add(new Card(9,2));
		b.add(new Card(9,3));
		b.add(new Card(11,1));
		b.add(new Card(7, 4));
		b.add(new Card(14,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(11, 4));
		nextCards.add(new Card(7, 3));
		nextCards.add(new Card(14, 1));

		List<Integer> indexes = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++){
			if (b.get(i).getRank() == b.get(i+1).getRank()){
				indexes.add(i);
				indexes.add(i+1);
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//16) Testing that Royal Flush (p1) Beats High Card, which requires an exchange of 3 cards
	public void test16() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,2));		
		}
		b.add(new Card(13,3));
		b.add(new Card(12,1));
		b.add(new Card(7,1));
		b.add(new Card(10, 4));
		b.add(new Card(8,2));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		List<Card> nextCards = new ArrayList<Card>();
		nextCards.add(new Card(7, 3));
		nextCards.add(new Card(10, 3));
		nextCards.add(new Card(8, 4));

		List<Integer> indexes = new ArrayList<Integer>();
		//Since it is high card, indices will just be the left 3
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}

		hb.evaluateHandRank();
		assertEquals("WIN", ha.whoWins(hb));
	}


	@Test
	//17) Testing that Royal Flush (p2) obtained from high pair beats other royal flush (of p1): TALK ABOUT LUCK!!
	public void test17() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(14-i,2));		
		}
		b.add(new Card(13,3));
		b.add(new Card(12,3));
		b.add(new Card(7,1));
		b.add(new Card(10, 4));
		b.add(new Card(8,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		List<Card> nextCards = new ArrayList<Card>();
		nextCards.add(new Card(11, 3));
		nextCards.add(new Card(14, 3));
		nextCards.add(new Card(10, 3));


		List<Integer> indexes = new ArrayList<Integer>();
		//Since it is high card, indices will just be the left 3
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}

		hb.evaluateHandRank();
		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//18) Testing that Straight Flush (p1) Beats 4 of a kind
	public void test18() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(13-i,3));		
		}
		b.add(new Card(8,3));
		b.add(new Card(8,4));
		b.add(new Card(8,1));
		b.add(new Card(8,2));
		b.add(new Card(10,1));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//19) Testing that Straight Flush (p1) Beats Full House
	public void test19() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(13-i,3));		
		}
		b.add(new Card(9,2));
		b.add(new Card(9,1));
		b.add(new Card(9,4));
		b.add(new Card(10,4));
		b.add(new Card(10,1));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//20) Testing that Straight Flush (player 2) Beats Flush
	public void test20() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			b.add(new Card(13-i,3));		
		}
		a.add(new Card(9,1));
		a.add(new Card(11,1));
		a.add(new Card(14,1));
		a.add(new Card(7,1));
		a.add(new Card(10,1));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//21) Testing that Straight Flush (player 1) Beats Straight
	public void test21() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(13-i,3));		
		}
		b.add(new Card(9,1));
		b.add(new Card(8,2));
		b.add(new Card(10,1));
		b.add(new Card(11,4));
		b.add(new Card(12,4));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//22) Testing that Straight Flush (p1) Beats 3 of a kind; there is an exchange
	public void test22() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(13-i,3));		
		}
		b.add(new Card(9,4));
		b.add(new Card(9,2));
		b.add(new Card(9,1));
		b.add(new Card(7,4));
		b.add(new Card(8,2));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();
		nextCards.add(new Card(8, 2));
		nextCards.add(new Card(13, 1));
		nextCards.add(new Card(11, 4));

		List<Integer> indexes = new ArrayList<Integer>();
		//Start at 2 middle

		//If third and fourth element arent the same add fourth and fifth, first three are 3 pair
		if (ha.getCards().get(2).getRank() != ha.getCards().get(3).getRank()){
			indexes.add(3);
			indexes.add(4);
		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank()){
			indexes.add(4);
			indexes.add(0);

		}
		else if (ha.getCards().get(2).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(1);
			indexes.add(0);
		}
		else if (ha.getCards().get(0).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(4);
			indexes.add(0);
		}
		//ha.swapCardWithSpecific(array, d, nextCards1);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}


		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//23) Testing that Straight Flush (p1) Beats 2 pairs, there is an exchange
	public void test23() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(13-i,3));		
		}
		b.add(new Card(9,4));
		b.add(new Card(9,2));
		b.add(new Card(10,1));
		b.add(new Card(10,4));
		b.add(new Card(14,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(14, 1));		

		List<Card> nextCards1 = new ArrayList<Card>();
		//Diamond king
		nextCards1.add(new Card(13, 1));

		List<Integer> indexes = new ArrayList<Integer>();
		//All 2 pairs when sorted will have a member of a pair in slot 2 of 5 and slot 4 of 5
		if (hb.getCards().get(1).getRank() != hb.getCards().get(0).getRank()){
			indexes.add(0);
		}
		else if (hb.getCards().get(1).getRank() != hb.getCards().get(2).getRank()){
			indexes.add(2);
		}
		else if (hb.getCards().get(3).getRank() != hb.getCards().get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}

		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//24) Testing that Straight Flush (p2) Beats 1 pair, there is an exchange
	public void test24() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			b.add(new Card(13-i,3));		
		}
		a.add(new Card(9,4));
		a.add(new Card(9,2));
		a.add(new Card(11,1));
		a.add(new Card(7,4));
		a.add(new Card(14,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(11, 4));	
		nextCards.add(new Card(7, 3));	
		nextCards.add(new Card(14, 1));

		List<Integer> indexes = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++){
			if (b.get(i).getRank() == b.get(i+1).getRank()){
				indexes.add(i);
				indexes.add(i+1);
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//25) Testing that Straight Flush (p1) Beats High Card, there is an	exchange
	public void test25() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		for (int i = 0; i < 5; i++){
			a.add(new Card(13-i,3));		
		}
		b.add(new Card(13,4));
		b.add(new Card(12,1));
		b.add(new Card(7,1));
		b.add(new Card(10,4));
		b.add(new Card(8,2));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(7,3));	
		nextCards.add(new Card(10,1));	
		nextCards.add(new Card(8,4));

		List<Integer> indexes = new ArrayList<Integer>();
		//Since it is high card, indices will just be the left 3
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//26) Testing that 4 of a Kind (p1) Beats Full House
	public void test26() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,1));
		a.add(new Card(8,4));
		a.add(new Card(8,3));
		a.add(new Card(8,2));
		a.add(new Card(10,3));

		b.add(new Card(9,3));
		b.add(new Card(9,2));
		b.add(new Card(9,1));
		b.add(new Card(10,4));
		b.add(new Card(10,1));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//27) Testing that 4 of a Kind (player 2) Beats Flush
	public void test27() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		b.add(new Card(8,1));
		b.add(new Card(8,4));
		b.add(new Card(8,3));
		b.add(new Card(8,2));
		b.add(new Card(10,3));

		a.add(new Card(9,1));
		a.add(new Card(11,1));
		a.add(new Card(14,1));
		a.add(new Card(7,1));
		a.add(new Card(10,1));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//28) Testing that 4 of a Kind (p1) Beats Straight
	public void test28() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,1));
		a.add(new Card(8,4));
		a.add(new Card(8,3));
		a.add(new Card(8,2));
		a.add(new Card(10,1));

		b.add(new Card(9,1));
		b.add(new Card(13,2));
		b.add(new Card(10,4));
		b.add(new Card(11,4));
		b.add(new Card(12,2));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//29) Testing that 4 of a Kind (p1) Beats 3 of a kind, there is an exchange
	public void test29() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,1));
		a.add(new Card(8,4));
		a.add(new Card(8,3));
		a.add(new Card(8,2));
		a.add(new Card(10,1));

		b.add(new Card(9,4));
		b.add(new Card(9,2));
		b.add(new Card(9,1));
		b.add(new Card(7,4));
		b.add(new Card(13,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(14, 1));	
		nextCards.add(new Card(11, 4));	

		List<Integer> indexes = new ArrayList<Integer>();
		//Start at 2 middle

		//If third and fourth element arent the same add fourth and fifth, first three are 3 pair
		if (ha.getCards().get(2).getRank() != ha.getCards().get(3).getRank()){
			indexes.add(3);
			indexes.add(4);
		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank()){
			indexes.add(4);
			indexes.add(0);

		}
		else if (ha.getCards().get(2).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(1);
			indexes.add(0);
		}
		else if (ha.getCards().get(0).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(4);
			indexes.add(0);
		}
		//ha.swapCardWithSpecific(array, d, nextCards1);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//30) Testing that 4 of a Kind (p1) Beats 2 pairs, there is an
	//exchange since 2 pairs is a hand that in the rules necessitates an exchange
	public void test30() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,1));
		a.add(new Card(8,4));
		a.add(new Card(8,3));
		a.add(new Card(8,2));
		a.add(new Card(10,1));

		b.add(new Card(9,4));
		b.add(new Card(9,2));
		b.add(new Card(10,4));
		b.add(new Card(10,2));
		b.add(new Card(14,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(14, 1));	

		List<Integer> indexes = new ArrayList<Integer>();
		//All 2 pairs when sorted will have a member of a pair in slot 2 of 5 and slot 4 of 5
		if (hb.getCards().get(1).getRank() != hb.getCards().get(0).getRank()){
			indexes.add(0);
		}
		else if (hb.getCards().get(1).getRank() != hb.getCards().get(2).getRank()){
			indexes.add(2);
		}
		else if (hb.getCards().get(3).getRank() != hb.getCards().get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//31) Testing that 4 of a Kind (p1) Beats 1 pair, there is an exchange 
	public void test31() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,1));
		a.add(new Card(8,4));
		a.add(new Card(8,3));
		a.add(new Card(8,2));
		a.add(new Card(10,1));

		b.add(new Card(9,4));
		b.add(new Card(9,2));
		b.add(new Card(11,1));
		b.add(new Card(7,4));
		b.add(new Card(14,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(11, 4));
		nextCards.add(new Card(7, 3));
		nextCards.add(new Card(14, 1));

		List<Integer> indexes = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++){
			if (b.get(i).getRank() == b.get(i+1).getRank()){
				indexes.add(i);
				indexes.add(i+1);
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//32) Testing that 4 of a Kind (p1) Beats High Card, there is an exchange 
	public void test32() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,1));
		a.add(new Card(8,4));
		a.add(new Card(8,3));
		a.add(new Card(8,2));
		a.add(new Card(10,1));

		b.add(new Card(14,3));
		b.add(new Card(12,1));
		b.add(new Card(7,1));
		b.add(new Card(10,4));
		b.add(new Card(9,2));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(10, 3));
		nextCards.add(new Card(7, 3));
		nextCards.add(new Card(9, 4));

		List<Integer> indexes = new ArrayList<Integer>();
		//Since it is high card, indices will just be the left 3
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);

		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));			
		}

		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//33) Testing that full house (player 1) beats a Flush
	public void test33() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,3));
		a.add(new Card(9,2));
		a.add(new Card(9,4));
		a.add(new Card(10,4));
		a.add(new Card(10,3));

		b.add(new Card(11,1));
		b.add(new Card(9,1));
		b.add(new Card(14,1));
		b.add(new Card(7,1));
		b.add(new Card(10,1));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//34) Testing that Full House (player 2) Beats Straight
	public void test34() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		b.add(new Card(9,3));
		b.add(new Card(9,2));
		b.add(new Card(9,4));
		b.add(new Card(10,4));
		b.add(new Card(10,1));

		a.add(new Card(9,1));
		a.add(new Card(13,2));
		a.add(new Card(10,2));
		a.add(new Card(11,4));
		a.add(new Card(12,4));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//35) Testing that Full House (p1) Beats 3 of a kind, there is an exchange 
	public void test35() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,3));
		a.add(new Card(9,2));
		a.add(new Card(9,4));
		a.add(new Card(10,4));
		a.add(new Card(10,3));

		b.add(new Card(8,4));
		b.add(new Card(8,2));
		b.add(new Card(8,1));
		b.add(new Card(7,4));
		b.add(new Card(13,2));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(13, 1));
		nextCards.add(new Card(14, 4));

		List<Integer> indexes = new ArrayList<Integer>();
		//Start at 2 middle

		//If third and fourth element arent the same add fourth and fifth, first three are 3 pair
		if (ha.getCards().get(2).getRank() != ha.getCards().get(3).getRank()){
			indexes.add(3);
			indexes.add(4);
		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank()){
			indexes.add(4);
			indexes.add(0);

		}
		else if (ha.getCards().get(2).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(1);
			indexes.add(0);
		}
		else if (ha.getCards().get(0).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(4);
			indexes.add(0);
		}
		//ha.swapCardWithSpecific(array, d, nextCards1);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//36) Testing that Full House (p1) Beats 2 pairs, there is an exchange  
	public void test36() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,3));
		a.add(new Card(9,2));
		a.add(new Card(9,4));
		a.add(new Card(10,4));
		a.add(new Card(10,1));

		b.add(new Card(7,2));
		b.add(new Card(10,3));
		b.add(new Card(10,2));
		b.add(new Card(7,4));
		b.add(new Card(14,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(13, 1));

		List<Integer> indexes = new ArrayList<Integer>();
		//All 2 pairs when sorted will have a member of a pair in slot 2 of 5 and slot 4 of 5
		if (hb.getCards().get(1).getRank() != hb.getCards().get(0).getRank()){
			indexes.add(0);
		}
		else if (hb.getCards().get(1).getRank() != hb.getCards().get(2).getRank()){
			indexes.add(2);
		}
		else if (hb.getCards().get(3).getRank() != hb.getCards().get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//37) Testing that Full House (p1) Beats 1 pair, there is an exchange  
	public void test37() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,3));
		a.add(new Card(9,2));
		a.add(new Card(9,4));
		a.add(new Card(10,4));
		a.add(new Card(10,1));

		b.add(new Card(7,2));
		b.add(new Card(8,4));
		b.add(new Card(8,2));
		b.add(new Card(11,1));
		b.add(new Card(13,4));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(14, 3));
		nextCards.add(new Card(11, 4));
		nextCards.add(new Card(7, 3));

		List<Integer> indexes = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++){
			if (b.get(i).getRank() == b.get(i+1).getRank()){
				indexes.add(i);
				indexes.add(i+1);
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//38) Testing that Full House (p1) Beats High Card, there is an	exchange  
	public void test38() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,3));
		a.add(new Card(9,2));
		a.add(new Card(9,4));
		a.add(new Card(10,4));
		a.add(new Card(10,1));

		b.add(new Card(13,4));
		b.add(new Card(12,1));
		b.add(new Card(7,1));
		b.add(new Card(10,2));
		b.add(new Card(8,2));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(7, 3));
		nextCards.add(new Card(10, 3));
		nextCards.add(new Card(8, 4));

		List<Integer> indexes = new ArrayList<Integer>();
		//Since it is high card, indices will just be the left 3
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//39) Testing that Flush (player 1) Beats Straight
	public void test39() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,1));
		a.add(new Card(11,1));
		a.add(new Card(14,1));
		a.add(new Card(7,1));
		a.add(new Card(10,1));

		b.add(new Card(13,2));
		b.add(new Card(10,3));
		b.add(new Card(11,4));
		b.add(new Card(12,4));
		b.add(new Card(9,4));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//39)Testing that Flush (player 2) Beats 3 of a kind, there is an
	//exchange since 3 // of a kind is a hand that in the rules necessitates 
	public void test392() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		b.add(new Card(10,1));
		b.add(new Card(7,1));
		b.add(new Card(9,1));
		b.add(new Card(11,1));
		b.add(new Card(14,1));

		a.add(new Card(8,4));
		a.add(new Card(8,2));
		a.add(new Card(8,1));
		a.add(new Card(7,4));
		a.add(new Card(13,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(13, 1));
		nextCards.add(new Card(11, 4));

		List<Integer> indexes = new ArrayList<Integer>();
		//Start at 2 middle

		//If third and fourth element arent the same add fourth and fifth, first three are 3 pair
		if (ha.getCards().get(2).getRank() != ha.getCards().get(3).getRank()){
			indexes.add(3);
			indexes.add(4);
		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank()){
			indexes.add(4);
			indexes.add(0);

		}
		else if (ha.getCards().get(2).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(1);
			indexes.add(0);
		}
		else if (ha.getCards().get(0).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(4);
			indexes.add(0);
		}
		//ha.swapCardWithSpecific(array, d, nextCards1);
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		ha.evaluateHandRank();
		hb.evaluateHandRank();

		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//40)Testing that Flush (player 1) Beats 2 pairs, there is an exchange 
	public void test40() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,1));
		a.add(new Card(11,1));
		a.add(new Card(14,1));
		a.add(new Card(7,1));
		a.add(new Card(10,1));

		b.add(new Card(9,4));
		b.add(new Card(9,2));
		b.add(new Card(10,3));
		b.add(new Card(10,2));
		b.add(new Card(14,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(13, 1));

		List<Integer> indexes = new ArrayList<Integer>();
		//All 2 pairs when sorted will have a member of a pair in slot 2 of 5 and slot 4 of 5
		if (hb.getCards().get(1).getRank() != hb.getCards().get(0).getRank()){
			indexes.add(0);
		}
		else if (hb.getCards().get(1).getRank() != hb.getCards().get(2).getRank()){
			indexes.add(2);
		}
		else if (hb.getCards().get(3).getRank() != hb.getCards().get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}


	@Test
	//41)Testing that Flush (player 1) Beats 1 pair, there is an exchange 
	public void test41() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,1));
		a.add(new Card(11,1));
		a.add(new Card(14,1));
		a.add(new Card(7,1));
		a.add(new Card(10,1));

		b.add(new Card(7,2));
		b.add(new Card(9,4));
		b.add(new Card(9,2));
		b.add(new Card(11,2));
		b.add(new Card(13,4));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(14,2));
		nextCards.add(new Card(11,4));
		nextCards.add(new Card(7,2));
		List<Integer> indexes = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++){
			if (b.get(i).getRank() == b.get(i+1).getRank()){
				indexes.add(i);
				indexes.add(i+1);
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//42)Testing that Flush (p1) Beats High Card, there is an exchange 
	public void test42() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,1));
		a.add(new Card(11,1));
		a.add(new Card(14,1));
		a.add(new Card(7,1));
		a.add(new Card(10,1));

		b.add(new Card(13,3));
		b.add(new Card(12,1));
		b.add(new Card(7,2));
		b.add(new Card(10,4));
		b.add(new Card(8,2));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(7,3));
		nextCards.add(new Card(10,3));
		nextCards.add(new Card(8,4));

		List<Integer> indexes = new ArrayList<Integer>();

		//Since it is high card, indices will just be the left 3
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);

		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//43) Testing that Straight (p1) Beats 3 of a kind, there is an	exchange
	public void test43() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,4));
		a.add(new Card(13,2));
		a.add(new Card(10,3));
		a.add(new Card(11,4));
		a.add(new Card(12,4));

		b.add(new Card(8,4));
		b.add(new Card(8,2));
		b.add(new Card(8,1));
		b.add(new Card(7,4));
		b.add(new Card(13,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(13,1));
		nextCards.add(new Card(11,3));

		List<Integer> indexes = new ArrayList<Integer>();
		//Start at 2 middle

		//If third and fourth element arent the same add fourth and fifth, first three are 3 pair
		if (ha.getCards().get(2).getRank() != ha.getCards().get(3).getRank()){
			indexes.add(3);
			indexes.add(4);
		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank()){
			indexes.add(4);
			indexes.add(0);

		}
		else if (ha.getCards().get(2).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(1);
			indexes.add(0);
		}
		else if (ha.getCards().get(0).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(4);
			indexes.add(0);
		}
		//ha.swapCardWithSpecific(array, d, nextCards1);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//44) Testing that Straight (p2) Beats 2 pairs, there is an exchange
	public void test44() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		b.add(new Card(9,4));
		b.add(new Card(13,2));
		b.add(new Card(10,3));
		b.add(new Card(11,4));
		b.add(new Card(12,4));

		a.add(new Card(9,3));
		a.add(new Card(9,2));
		a.add(new Card(10,4));
		a.add(new Card(10,2));
		a.add(new Card(14,2));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(13,1));

		List<Integer> indexes = new ArrayList<Integer>();
		//All 2 pairs when sorted will have a member of a pair in slot 2 of 5 and slot 4 of 5
		if (hb.getCards().get(1).getRank() != hb.getCards().get(0).getRank()){
			indexes.add(0);
		}
		else if (hb.getCards().get(1).getRank() != hb.getCards().get(2).getRank()){
			indexes.add(2);
		}
		else if (hb.getCards().get(3).getRank() != hb.getCards().get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//45) Testing that Straight (p1) Beats 1 pair, there is an exchange
	public void test45() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,4));
		a.add(new Card(13,2));
		a.add(new Card(10,3));
		a.add(new Card(11,4));
		a.add(new Card(12,4));

		b.add(new Card(7,2));
		b.add(new Card(9,3));
		b.add(new Card(9,2));
		b.add(new Card(11,3));
		b.add(new Card(13,4));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(14,3));
		nextCards.add(new Card(11,1));
		nextCards.add(new Card(7,1));

		List<Integer> indexes = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++){
			if (b.get(i).getRank() == b.get(i+1).getRank()){
				indexes.add(i);
				indexes.add(i+1);
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//46) Testing that Straight (p1) Beats High Card, there is an exchange
	public void test46() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,4));
		a.add(new Card(13,2));
		a.add(new Card(10,3));
		a.add(new Card(11,4));
		a.add(new Card(12,4));

		b.add(new Card(13,3));
		b.add(new Card(12,1));
		b.add(new Card(7,1));
		b.add(new Card(10,4));
		b.add(new Card(8,2));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards = new ArrayList<Card>();

		nextCards.add(new Card(7,3));
		nextCards.add(new Card(10,1));
		nextCards.add(new Card(8,4));

		List<Integer> indexes = new ArrayList<Integer>();
		//Since it is high card, indices will just be the left 3
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards.get(i));
		}
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//47) Testing that 3 Of A Kind (p2) Beats 2 pairs, there are 2 
	public void test47() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,3));
		a.add(new Card(9,2));
		a.add(new Card(10,4));
		a.add(new Card(10,2));
		a.add(new Card(14,3));

		b.add(new Card(8,2));
		b.add(new Card(8,1));
		b.add(new Card(8,4));
		b.add(new Card(7,4));
		b.add(new Card(13,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();

		//Swap cards for both players

		nextCards1.add(new Card(11,3));

		nextCards2.add(new Card(12,4));
		nextCards2.add(new Card(13,1));

		List<Integer> indexes = new ArrayList<Integer>();
		//Start at 2 middle

		//If third and fourth element arent the same add fourth and fifth, first three are 3 pair
		if (hb.getCards().get(2).getRank() != hb.getCards().get(3).getRank()){
			indexes.add(3);
			indexes.add(4);
		}
		else if (hb.getCards().get(3).getRank() != hb.getCards().get(4).getRank()){
			indexes.add(4);
			indexes.add(0);

		}
		else if (hb.getCards().get(2).getRank() != hb.getCards().get(1).getRank()){
			indexes.add(1);
			indexes.add(0);
		}
		else if (hb.getCards().get(0).getRank() != hb.getCards().get(1).getRank()){
			indexes.add(4);
			indexes.add(0);
		}
		//ha.swapCardWithSpecific(array, d, nextCards1);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards2.get(i));
		}

		indexes.clear();

		//All 2 pairs when sorted will have a member of a pair in slot 2 of 5 and slot 4 of 5
		if (ha.getCards().get(1).getRank() != ha.getCards().get(0).getRank()){
			indexes.add(0);
		}
		else if (ha.getCards().get(1).getRank() != ha.getCards().get(2).getRank()){
			indexes.add(2);
		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}


		ha.evaluateHandRank();
		hb.evaluateHandRank();

		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//48) Testing that 3 Of A Kind (p1) Beats 1 pair. There are 2 exchanges
	public void test48() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,4));
		a.add(new Card(8,2));
		a.add(new Card(8,1));
		a.add(new Card(7,4));
		a.add(new Card(13,3));

		b.add(new Card(7,2));
		b.add(new Card(9,2));
		b.add(new Card(9,3));
		b.add(new Card(11,3));
		b.add(new Card(13,4));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();

		//Swap cards for both players

		nextCards1.add(new Card(11,2));
		nextCards1.add(new Card(12,4));

		nextCards2.add(new Card(14,3));
		nextCards2.add(new Card(11,1));
		nextCards2.add(new Card(7,4));

		List<Integer> indexes = new ArrayList<Integer>();
		//Start at 2 middle

		//If third and fourth element arent the same add fourth and fifth, first three are 3 pair
		if (ha.getCards().get(2).getRank() != ha.getCards().get(3).getRank()){
			indexes.add(3);
			indexes.add(4);
		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank()){
			indexes.add(4);
			indexes.add(0);

		}
		else if (ha.getCards().get(2).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(1);
			indexes.add(0);
		}
		else if (ha.getCards().get(0).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(4);
			indexes.add(0);
		}
		//ha.swapCardWithSpecific(array, d, nextCards1);
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}

		indexes.clear();

		for (int i = 0; i < 3; i++){
			if (b.get(i).getRank() == b.get(i+1).getRank()){
				indexes.add(i);
				indexes.add(i+1);
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards2.get(i));
		}

		ha.evaluateHandRank();
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//49) Testing that 3 Of A Kind (p1) Beats High Card. There are 2 exchanges
	public void test49() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,4));
		a.add(new Card(8,2));
		a.add(new Card(8,1));
		a.add(new Card(7,4));
		a.add(new Card(13,4));

		b.add(new Card(13,3));
		b.add(new Card(12,1));
		b.add(new Card(7,1));
		b.add(new Card(10,4));
		b.add(new Card(8,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();

		//Swap cards for both players

		nextCards1.add(new Card(11,2));
		nextCards1.add(new Card(12,4));

		nextCards2.add(new Card(7,3));
		nextCards2.add(new Card(10,3));
		nextCards2.add(new Card(9,4));

		List<Integer> indexes = new ArrayList<Integer>();
		//Start at 2 middle

		//If third and fourth element arent the same add fourth and fifth, first three are 3 pair
		if (ha.getCards().get(2).getRank() != ha.getCards().get(3).getRank()){
			indexes.add(3);
			indexes.add(4);
		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank()){
			indexes.add(4);
			indexes.add(0);

		}
		else if (ha.getCards().get(2).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(1);
			indexes.add(0);
		}
		else if (ha.getCards().get(0).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(4);
			indexes.add(0);
		}
		//ha.swapCardWithSpecific(array, d, nextCards1);
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}

		indexes.clear();
		//Since it is high card, indices will just be the left 3
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards2.get(i));
		}

		ha.evaluateHandRank();
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}


	@Test
	//50) Testing that 2 Pairs (p1) Beats 1 pair. There are 2 exchanges.
	public void test50() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,3));
		a.add(new Card(9,2));
		a.add(new Card(10,4));
		a.add(new Card(10,2));
		a.add(new Card(14,3));

		b.add(new Card(7,2));
		b.add(new Card(8,3));
		b.add(new Card(8,2));
		b.add(new Card(11,3));
		b.add(new Card(13,4));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();

		//Swap cards for both players

		nextCards1.add(new Card(13,1));

		nextCards2.add(new Card(14,2));
		nextCards2.add(new Card(11,1));
		nextCards2.add(new Card(7,3));

		List<Integer> indexes = new ArrayList<Integer>();
		//All 2 pairs when sorted will have a member of a pair in slot 2 of 5 and slot 4 of 5
		if (hb.getCards().get(1).getRank() != hb.getCards().get(0).getRank()){
			indexes.add(0);
		}
		else if (hb.getCards().get(1).getRank() != hb.getCards().get(2).getRank()){
			indexes.add(2);
		}
		else if (hb.getCards().get(3).getRank() != hb.getCards().get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}

		indexes.clear();
		List<Card> c = hb.getCards();
		//Getting non pair value
		//Pair member must exist at index 1 or 3, when sorted
		if (c.get(1).getRank() != c.get(0).getRank() && c.get(1).getRank() != c.get(2).getRank()){
			indexes.add(0);
			indexes.add(1);
			if (c.get(2).getRank() != c.get(3).getRank()){
				indexes.add(2);
			}
			else if (c.get(4).getRank() != c.get(3).getRank()){
				indexes.add(4);				
			}

		}
		else if (c.get(3).getRank() != c.get(4).getRank() && c.get(3).getRank() != c.get(2).getRank())
		{
			indexes.add(4);
			indexes.add(3);					
			if (c.get(1).getRank() != c.get(2).getRank()){
				indexes.add(2);
			}
			else if (c.get(1).getRank() != c.get(0).getRank()){
				indexes.add(3);				
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards2.get(i));
		}

		ha.evaluateHandRank();
		hb.evaluateHandRank();

		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//51) Testing that 2 Pairs (p2) Beats High Card. There are 2 exchanges.
	public void test51() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		b.add(new Card(13,3));
		b.add(new Card(12,1));
		b.add(new Card(7,1));
		b.add(new Card(10,1));
		b.add(new Card(8,2));

		a.add(new Card(9,2));
		a.add(new Card(9,3));
		a.add(new Card(10,2));
		a.add(new Card(10,4));
		a.add(new Card(14,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();

		//Swap cards for both players

		nextCards1.add(new Card(8,4));

		nextCards2.add(new Card(13,1));
		nextCards2.add(new Card(7,3));
		nextCards2.add(new Card(10,3));

		List<Integer> indexes = new ArrayList<Integer>();
		//All 2 pairs when sorted will have a member of a pair in slot 2 of 5 and slot 4 of 5
		if (hb.getCards().get(1).getRank() != hb.getCards().get(0).getRank()){
			indexes.add(0);
		}
		else if (hb.getCards().get(1).getRank() != hb.getCards().get(2).getRank()){
			indexes.add(2);
		}
		else if (hb.getCards().get(3).getRank() != hb.getCards().get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}

		indexes.clear();
		//Since it is high card, indices will just be the left 3
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards2.get(i));
		}

		ha.evaluateHandRank();
		hb.evaluateHandRank();

		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//52) Testing that 1 Pair Beats High Card. There are 2 exchanges.
	public void test52() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(7,2));
		a.add(new Card(8,3));
		a.add(new Card(8,2));
		a.add(new Card(11,3));
		a.add(new Card(13,4));

		b.add(new Card(13,3));
		b.add(new Card(12,1));
		b.add(new Card(7,4));
		b.add(new Card(10,4));
		b.add(new Card(8,1));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();

		//Swap cards for both players

		nextCards1.add(new Card(14,2));
		nextCards1.add(new Card(11,1));
		nextCards1.add(new Card(7,1));

		nextCards2.add(new Card(7,3));
		nextCards2.add(new Card(10,3));
		nextCards2.add(new Card(8,4));

		List<Integer> indexes = new ArrayList<Integer>();

		//Getting non pair value
		//Pair member must exist at index 1 or 3, when sorted
		if (ha.getCards().get(1).getRank() != ha.getCards().get(0).getRank() && ha.getCards().get(1).getRank() != ha.getCards().get(2).getRank()){
			indexes.add(0);
			indexes.add(1);
			if (ha.getCards().get(2).getRank() != ha.getCards().get(3).getRank()){
				indexes.add(2);
			}
			else if (ha.getCards().get(4).getRank() != ha.getCards().get(3).getRank()){
				indexes.add(4);				
			}

		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank() && ha.getCards().get(3).getRank() != ha.getCards().get(2).getRank()){
			indexes.add(4);
			indexes.add(3);
			if (ha.getCards().get(1).getRank() != ha.getCards().get(2).getRank()){
				indexes.add(2);
			}
			else if (ha.getCards().get(1).getRank() != ha.getCards().get(0).getRank()){
				indexes.add(3);				
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}

		indexes.clear();
		//Since it is high card, indices will just be the left 3
		indexes.add(0);
		indexes.add(1);
		indexes.add(2);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards2.get(i));
		}

		ha.evaluateHandRank();
		hb.evaluateHandRank();

		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//53) Testing exchange can make you win, each player with a new hand:p2 wins
	public void test53() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(7,2));
		a.add(new Card(8,3));
		a.add(new Card(8,2));
		a.add(new Card(11,3));
		a.add(new Card(13,4));

		b.add(new Card(13,3));
		b.add(new Card(12,1));
		b.add(new Card(7,4));
		b.add(new Card(10,4));
		b.add(new Card(8,1));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);

		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();

		//Swap cards for both players

		nextCards1.add(new Card(8,4));
		nextCards1.add(new Card(14,2));
		nextCards1.add(new Card(11,1));

		nextCards2.add(new Card(11,4));
		nextCards2.add(new Card(14,3));
		nextCards2.add(new Card(10,3));

		int[] array = new int[]{1,1,1,1,1};

		for (int i = 0; i < 4; i++){
			if (a.get(i).getRank() == a.get(i).getRank()){
				array[i] = 0;
				array[i+1] = 0;				
			}
		}

		ha.swapCardWithSpecific(array, d, nextCards1);

		int[] arrayy = new int[]{1,1,1,0,0};

		hb.swapCardWithSpecific(arrayy, d, nextCards2);

		ha.evaluateHandRank();
		hb.evaluateHandRank();

		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//54) Testing that Ace High Card (p1) Wins Tie (using straights)
	public void test54() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(14,1));
		a.add(new Card(13,2));
		a.add(new Card(12,2));
		a.add(new Card(11,2));
		a.add(new Card(10,2));

		b.add(new Card(9,3));
		b.add(new Card(13,1));
		b.add(new Card(12,3));
		b.add(new Card(11,3));
		b.add(new Card(10,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//55) Testing that King High Card (p2) Wins Tie (using straights)
	public void test55() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(12,1));
		a.add(new Card(11,2));
		a.add(new Card(10,2));
		a.add(new Card(9,2));
		a.add(new Card(8,2));

		b.add(new Card(9,3));
		b.add(new Card(13,1));
		b.add(new Card(12,3));
		b.add(new Card(11,3));
		b.add(new Card(10,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//56) Testing that Queen High Card (p1) Wins Tie (using straights)
	public void test56() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(12,1));
		a.add(new Card(11,2));
		a.add(new Card(10,2));
		a.add(new Card(9,2));
		a.add(new Card(8,2));

		b.add(new Card(11,3));
		b.add(new Card(10,1));
		b.add(new Card(9,3));
		b.add(new Card(8,3));
		b.add(new Card(7,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//57) Testing that Jack High Card (p1) Wins Tie (using full houses)
	public void test57() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(11,1));
		a.add(new Card(11,2));
		a.add(new Card(11,3));
		a.add(new Card(9,2));
		a.add(new Card(9,3));

		b.add(new Card(8,3));
		b.add(new Card(8,1));
		b.add(new Card(8,4));
		b.add(new Card(7,4));
		b.add(new Card(7,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//58) Testing that Ten High Card (p2) Wins Tie (using full houses)
	public void test58() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,1));
		a.add(new Card(8,2));
		a.add(new Card(8,3));
		a.add(new Card(9,2));
		a.add(new Card(9,4));

		b.add(new Card(10,3));
		b.add(new Card(10,1));
		b.add(new Card(10,4));
		b.add(new Card(7,4));
		b.add(new Card(7,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//59) Testing that Nine High Card (p1) Wins Tie (using full houses)
	public void test59() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(7,1));
		a.add(new Card(7,2));
		a.add(new Card(9,3));
		a.add(new Card(9,2));
		a.add(new Card(9,4));

		b.add(new Card(8,3));
		b.add(new Card(8,1));
		b.add(new Card(8,4));
		b.add(new Card(7,4));
		b.add(new Card(7,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//60) Testing that when One Card Away from Royal Flush a card is exchanged and player 1 Loses after exchange
	public void test60() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(7,4));
		a.add(new Card(13,2));
		a.add(new Card(12,2));
		a.add(new Card(11,2));
		a.add(new Card(10,2));

		b.add(new Card(9,3));
		b.add(new Card(13,3));
		b.add(new Card(12,3));
		b.add(new Card(11,3));
		b.add(new Card(10,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		List<Card> nextCards1 = new ArrayList<Card>();

		//Card to be added
		nextCards1.add(new Card(8,2));

		//Check which one is not in sequence
		int toBeReplaced = 0;
		for (int i = 0; i < 4; i++){
			if (ha.getCards().get(i).getRank() + 1 == ha.getCards().get(i+1).getRank()){

			}
			else{
				toBeReplaced = i;
			}
		}
		int[] array = new int[]{0,0,0,0,0};
		array[toBeReplaced] = 1;
		ha.swapCardWithSpecific(array, d, nextCards1);

		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//61) Testing that when One Card Away from Royal Flush a card is exchanged and player 1 Wins after exchange
	public void test61() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(7,4));
		a.add(new Card(13,2));
		a.add(new Card(12,2));
		a.add(new Card(11,2));
		a.add(new Card(10,2));

		b.add(new Card(9,3));
		b.add(new Card(13,3));
		b.add(new Card(12,3));
		b.add(new Card(11,3));
		b.add(new Card(10,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		List<Card> nextCards1 = new ArrayList<Card>();

		//Card to be added
		nextCards1.add(new Card(14,2));

		//Check which one is not in sequence
		int toBeReplaced = 0;
		for (int i = 0; i < 4; i++){
			if (ha.getCards().get(i).getRank() + 1 == ha.getCards().get(i+1).getRank()){

			}
			else{
				toBeReplaced = i;
			}
		}
		int[] array = new int[]{0,0,0,0,0};
		array[toBeReplaced] = 1;
		ha.swapCardWithSpecific(array, d, nextCards1);

		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//62) Testing that when One card Away from Straight Flush a card is	exchanged and then player 1 loses after exchange
	public void test62() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(7,4));
		a.add(new Card(13,2));
		a.add(new Card(12,2));
		a.add(new Card(11,2));
		a.add(new Card(10,2));

		b.add(new Card(8,1));
		b.add(new Card(8,3));
		b.add(new Card(8,2));
		b.add(new Card(8,4));
		b.add(new Card(10,1));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		List<Card> nextCards1 = new ArrayList<Card>();

		//Card to be added
		nextCards1.add(new Card(7,2));

		//Check which one is not in sequence
		int toBeReplaced = 0;
		for (int i = 0; i < 4; i++){
			if (ha.getCards().get(i).getRank() + 1 == ha.getCards().get(i+1).getRank()){

			}
			else{
				toBeReplaced = i;
			}
		}
		int[] array = new int[]{0,0,0,0,0};
		array[toBeReplaced] = 1;
		ha.swapCardWithSpecific(array, d, nextCards1);

		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//63) Testing that when One card Away from Straight Flush a card is	exchanged and the player p1 Wins after exchange
	public void test63() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(7,4));
		a.add(new Card(13,2));
		a.add(new Card(12,2));
		a.add(new Card(11,2));
		a.add(new Card(10,2));

		b.add(new Card(8,1));
		b.add(new Card(8,3));
		b.add(new Card(8,2));
		b.add(new Card(8,4));
		b.add(new Card(10,1));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		List<Card> nextCards1 = new ArrayList<Card>();

		//Card to be added
		nextCards1.add(new Card(9,2));

		//Check which one is not in sequence
		int toBeReplaced = 0;
		for (int i = 0; i < 4; i++){
			if (ha.getCards().get(i).getRank() + 1 == ha.getCards().get(i+1).getRank()){

			}
			else{
				toBeReplaced = i;
			}
		}
		int[] array = new int[]{0,0,0,0,0};
		array[toBeReplaced] = 1;
		ha.swapCardWithSpecific(array, d, nextCards1);

		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//64) Testing that when One card Away from Flush a card is exchanged	and player p1 loses after exchange
	public void test64() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,3));
		a.add(new Card(11,1));
		a.add(new Card(14,1));
		a.add(new Card(7,1));
		a.add(new Card(10,1));

		b.add(new Card(9,4));
		b.add(new Card(13,2));
		b.add(new Card(10,3));
		b.add(new Card(11,4));
		b.add(new Card(12,4));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		List<Card> nextCards1 = new ArrayList<Card>();

		//Card to be added
		nextCards1.add(new Card(7,3));

		//Check if one card off flush	
		int[] array = new int[]{0,0,0,0,0};
		int[] arrayy = new int[]{0,0,0,0};
		int suitToRemove = 0;

		for (int i = 0; i < 5; i++){
			arrayy[ha.getCards().get(i).getSuit()-1]++;
		}
		for (int i = 0; i < 4; i++){
			if (arrayy[i] == 1){
				suitToRemove = i+1;
			}
		}
		for (int i = 0; i < 5; i++){
			if (ha.getCards().get(i).getSuit()-1 == suitToRemove){
				array[i] = 1;
			}
		}

		ha.swapCardWithSpecific(array, d, nextCards1);

		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//65) Testing that when One card Away from Flush a card is exchanged and player p1 wins after exchange
	public void test65() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(9,3));
		a.add(new Card(11,1));
		a.add(new Card(14,1));
		a.add(new Card(7,1));
		a.add(new Card(10,1));

		b.add(new Card(9,4));
		b.add(new Card(13,2));
		b.add(new Card(10,3));
		b.add(new Card(11,4));
		b.add(new Card(12,4));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		List<Card> nextCards1 = new ArrayList<Card>();

		//Card to be added
		nextCards1.add(new Card(9,1));

		//Check if one card off flush	
		int[] array = new int[]{0,0,0,0,0};
		int[] arrayy = new int[]{0,0,0,0};
		int suitToRemove = 0;

		for (int i = 0; i < 5; i++){
			arrayy[ha.getCards().get(i).getSuit()-1]++;
		}
		for (int i = 0; i < 4; i++){
			if (arrayy[i] == 1){
				suitToRemove = i+1;
			}
		}
		for (int i = 0; i < 5; i++){
			if (ha.getCards().get(i).getSuit()-1 == suitToRemove){
				array[i] = 1;
			}
		}

		ha.swapCardWithSpecific(array, d, nextCards1);

		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//66) Testing that when One card Away from Straight, a card is	exchanged and player p1 loses after each player exchanges (1 card for	p1 2 for p2)
	public void test66() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(7,4));
		a.add(new Card(13,2));
		a.add(new Card(10,3));
		a.add(new Card(11,4));
		a.add(new Card(12,4));

		b.add(new Card(8,1));
		b.add(new Card(8,2));
		b.add(new Card(8,4));
		b.add(new Card(7,3));
		b.add(new Card(13,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();

		//Card to be added
		nextCards1.add(new Card(8,3));

		nextCards2.add(new Card(13,1));
		nextCards2.add(new Card(11,3));

		//Check which one is not in sequence
		int toBeReplaced = 0;
		for (int i = 0; i < 4; i++){
			if (ha.getCards().get(i).getRank() + 1 == ha.getCards().get(i+1).getRank()){

			}
			else{
				toBeReplaced = i;
			}
		}
		int[] array = new int[]{0,0,0,0,0};
		array[toBeReplaced] = 1;

		ha.swapCardWithSpecific(array, d, nextCards1);

		array[0] = 1;
		array[1] = 1;
		array[2] = 1;
		array[3] = 1;
		array[4] = 1;

		for (int i = 0; i < 4; i++){
			if (b.get(i).getRank() == b.get(i).getRank()){
				array[i] = 0;
				array[i+1] = 0;				
			}
		}

		hb.swapCardWithSpecific(array, d, nextCards2);

		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//67) Testing that when One card Away from Straight a card is exchanged and player p1 wins after exchanges
	public void test67() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(7,4));
		a.add(new Card(13,2));
		a.add(new Card(10,3));
		a.add(new Card(11,4));
		a.add(new Card(12,4));

		b.add(new Card(8,1));
		b.add(new Card(8,2));
		b.add(new Card(8,4));
		b.add(new Card(7,3));
		b.add(new Card(13,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);


		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();

		//Card to be added
		nextCards1.add(new Card(9,3));

		nextCards2.add(new Card(13,1));
		nextCards2.add(new Card(11,3));

		//Check which one is not in sequence
		int toBeReplaced = 0;
		for (int i = 0; i < 4; i++){
			if (ha.getCards().get(i).getRank() + 1 == ha.getCards().get(i+1).getRank()){

			}
			else{
				toBeReplaced = i;
			}
		}
		int[] array = new int[]{0,0,0,0,0};
		array[toBeReplaced] = 1;

		ha.swapCardWithSpecific(array, d, nextCards1);

		List<Integer> indexes = new ArrayList<Integer>();
		//Start at 2 middle

		//If third and fourth element arent the same add fourth and fifth, first three are 3 pair
		if (ha.getCards().get(2).getRank() != ha.getCards().get(3).getRank()){
			indexes.add(3);
			indexes.add(4);
		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank()){
			indexes.add(4);
			indexes.add(0);

		}
		else if (ha.getCards().get(2).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(1);
			indexes.add(0);
		}
		else if (ha.getCards().get(0).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(4);
			indexes.add(0);
		}
		//ha.swapCardWithSpecific(array, d, nextCards1);
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards2.get(i));
		}

		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//68) Testing that 3 Of a Kind exchanging the 2 cards, and in this case loses
	public void test68() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,4));
		a.add(new Card(8,2));
		a.add(new Card(8,1));
		a.add(new Card(7,4));
		a.add(new Card(13,3));

		b.add(new Card(9,3));
		b.add(new Card(8,3));
		b.add(new Card(10,4));
		b.add(new Card(11,3));
		b.add(new Card(12,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);		

		List<Card> nextCards1 = new ArrayList<Card>();

		//Card to be added
		nextCards1.add(new Card(12,4));		
		nextCards1.add(new Card(11,2));

		List<Integer> indexes = new ArrayList<Integer>();
		//Start at 2 middle

		//If third and fourth element arent the same add fourth and fifth, first three are 3 pair
		if (ha.getCards().get(2).getRank() != ha.getCards().get(3).getRank()){
			indexes.add(3);
			indexes.add(4);
		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank()){
			indexes.add(4);
			indexes.add(0);

		}
		else if (ha.getCards().get(2).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(1);
			indexes.add(0);
		}
		else if (ha.getCards().get(0).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(4);
			indexes.add(0);
		}
		//ha.swapCardWithSpecific(array, d, nextCards1);
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}
		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//69) Testing that 3 Of a Kind exchanging the 2 cards, and in this case wins
	public void test69() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,4));
		a.add(new Card(8,2));
		a.add(new Card(8,1));
		a.add(new Card(7,4));
		a.add(new Card(13,3));

		b.add(new Card(9,3));
		b.add(new Card(8,3));
		b.add(new Card(10,4));
		b.add(new Card(11,3));
		b.add(new Card(12,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);		

		List<Card> nextCards1 = new ArrayList<Card>();

		//Card to be added
		nextCards1.add(new Card(7,2));		
		nextCards1.add(new Card(7,1));

		List<Integer> indexes = new ArrayList<Integer>();
		//Start at 2 middle

		//If third and fourth element arent the same add fourth and fifth, first three are 3 pair
		if (ha.getCards().get(2).getRank() != ha.getCards().get(3).getRank()){
			indexes.add(3);
			indexes.add(4);
		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank()){
			indexes.add(4);
			indexes.add(0);

		}
		else if (ha.getCards().get(2).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(1);
			indexes.add(0);
		}
		else if (ha.getCards().get(0).getRank() != ha.getCards().get(1).getRank()){
			indexes.add(4);
			indexes.add(0);
		}
		//ha.swapCardWithSpecific(array, d, nextCards1);
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}

		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//70) Testing 2 Pairs exchanging the 1 card, and in this case p1 loses
	public void test70() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,4));
		a.add(new Card(8,2));
		a.add(new Card(9,1));
		a.add(new Card(9,4));
		a.add(new Card(13,3));

		b.add(new Card(9,3));
		b.add(new Card(8,3));
		b.add(new Card(10,4));
		b.add(new Card(11,3));
		b.add(new Card(12,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);		

		List<Card> nextCards1 = new ArrayList<Card>();

		//Card to be added
		nextCards1.add(new Card(9,2));	

		List<Integer> indexes = new ArrayList<Integer>();

		//All 2 pairs when sorted will have a member of a pair in slot 2 of 5 and slot 4 of 5
		if (hb.getCards().get(1).getRank() != hb.getCards().get(0).getRank()){
			indexes.add(0);
		}
		else if (hb.getCards().get(1).getRank() != hb.getCards().get(2).getRank()){
			indexes.add(2);
		}
		else if (hb.getCards().get(3).getRank() != hb.getCards().get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));		
		}

		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//71) Testing 2 Pairs exchanging the 1 card, and in this case Player 1	wins
	public void test71() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,4));
		a.add(new Card(8,2));
		a.add(new Card(9,1));
		a.add(new Card(9,4));
		a.add(new Card(13,3));

		b.add(new Card(7,3));
		b.add(new Card(7,1));
		b.add(new Card(10,4));
		b.add(new Card(10,3));
		b.add(new Card(12,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);		

		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();
		//Card to be added
		nextCards1.add(new Card(9,2));
		nextCards2.add(new Card(14,2));

		List<Integer> indexes = new ArrayList<Integer>();

		if (ha.getCards().get(1).getRank() != ha.getCards().get(0).getRank()){
			indexes.add(0);
		}
		else if (ha.getCards().get(1).getRank() != ha.getCards().get(2).getRank()){
			indexes.add(2);
		}
		else if (ha.getCards().get(3).getRank() != ha.getCards().get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}
		indexes.clear();
		if (hb.getCards().get(1).getRank() != hb.getCards().get(0).getRank()){
			indexes.add(0);
		}
		else if (hb.getCards().get(1).getRank() != hb.getCards().get(2).getRank()){
			indexes.add(2);
		}
		else if (hb.getCards().get(3).getRank() != hb.getCards().get(4).getRank()){
			indexes.add(4);
		}		
		for (int i = 0; i < indexes.size(); i++){
			hb.swapSingleCardAtIndex(indexes.get(i), d, nextCards2.get(i));
		}
		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("WIN", ha.whoWins(hb));
	}

	@Test
	//72) Testing that 1 Pair exchanging the 3 cards, and in this case	loses
	public void test72() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,4));
		a.add(new Card(8,2));
		a.add(new Card(9,1));
		a.add(new Card(7,4));
		a.add(new Card(13,3));

		b.add(new Card(9,3));
		b.add(new Card(8,3));
		b.add(new Card(10,4));
		b.add(new Card(11,3));
		b.add(new Card(12,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);		

		List<Card> nextCards1 = new ArrayList<Card>();
		List<Card> nextCards2 = new ArrayList<Card>();
		//Card to be added

		nextCards1.add(new Card(7,2));
		nextCards1.add(new Card(7,1));
		nextCards1.add(new Card(13,1));

		List<Integer> indexes = new ArrayList<Integer>();

		List<Card> c = ha.getCards();
		//Pair member must exist at index 1 or 3, when sorted
		if (c.get(1).getRank() != c.get(0).getRank() && c.get(1).getRank() != c.get(2).getRank()){
			indexes.add(0);
			indexes.add(1);
			if (c.get(2).getRank() != c.get(3).getRank()){
				indexes.add(2);
			}
			else if (c.get(4).getRank() != c.get(3).getRank()){
				indexes.add(4);				
			}

		}
		else if (c.get(3).getRank() != c.get(4).getRank() && c.get(3).getRank() != c.get(2).getRank()){
			indexes.add(4);
			indexes.add(3);
			if (c.get(1).getRank() != c.get(2).getRank()){
				indexes.add(2);
			}
			else if (c.get(1).getRank() != c.get(0).getRank()){
				indexes.add(3);				
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}

		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//73) Testing that 1 Pair exchanging the 3 cards, and in this case wins
	public void test73() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();

		a.add(new Card(8,4));
		a.add(new Card(8,2));
		a.add(new Card(9,1));
		a.add(new Card(7,4));
		a.add(new Card(13,3));

		b.add(new Card(9,3));
		b.add(new Card(8,3));
		b.add(new Card(10,4));
		b.add(new Card(11,3));
		b.add(new Card(12,3));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);		

		List<Card> nextCards1 = new ArrayList<Card>();
		//Card to be added
		List<Integer> indexes = new ArrayList<Integer>();
		nextCards1.add(new Card(13,2));
		nextCards1.add(new Card(13,4));
		nextCards1.add(new Card(13,1));

		List<Card> c = ha.getCards();
		//Pair member must exist at index 1 or 3, when sorted
		if (c.get(1).getRank() != c.get(0).getRank() && c.get(1).getRank() != c.get(2).getRank()){
			indexes.add(0);
			indexes.add(1);
			if (c.get(2).getRank() != c.get(3).getRank()){
				indexes.add(2);
			}
			else if (c.get(4).getRank() != c.get(3).getRank()){
				indexes.add(4);				
			}

		}
		else if (c.get(3).getRank() != c.get(4).getRank() && c.get(3).getRank() != c.get(2).getRank()){
			indexes.add(4);
			indexes.add(3);
			if (c.get(1).getRank() != c.get(2).getRank()){
				indexes.add(2);
			}
			else if (c.get(1).getRank() != c.get(0).getRank()){
				indexes.add(3);				
			}
		}
		for (int i = 0; i < indexes.size(); i++){
			ha.swapSingleCardAtIndex(indexes.get(i), d, nextCards1.get(i));
		}

		ha.evaluateHandRank();
		hb.evaluateHandRank();
		assertEquals("LOSE", ha.whoWins(hb));
	}

	@Test
	//74) Testing 3 Players all different Hands (no exchanges): p3 wins
	public void test74() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();

		a.add(new Card(12,1));
		a.add(new Card(9,2));
		a.add(new Card(10,2));
		a.add(new Card(8,2));
		a.add(new Card(11,2));

		b.add(new Card(10,1));
		b.add(new Card(10,4));
		b.add(new Card(7,4));
		b.add(new Card(7,3));
		b.add(new Card(10,3));

		c.add(new Card(14,2));
		c.add(new Card(11,1));
		c.add(new Card(14,4));
		c.add(new Card(14,3));
		c.add(new Card(14,1));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		Hand hc = new Hand(d, c);

		assertEquals("LOSE", ha.whoWins(hb));
		assertEquals("LOSE", ha.whoWins(hc));
		assertEquals("LOSE", hb.whoWins(hc));
	}


	@Test
	//75) Testing 3 Players, 2 with identical Hands (no exchanges): p1 wins
	public void test75() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();

		a.add(new Card(12,2));
		a.add(new Card(11,2));
		a.add(new Card(10,2));
		a.add(new Card(9,2));
		a.add(new Card(13,2));

		b.add(new Card(12,3));
		b.add(new Card(11,3));
		b.add(new Card(10,3));
		b.add(new Card(9,3));
		b.add(new Card(8,3));

		c.add(new Card(7,2));
		c.add(new Card(11,1));
		c.add(new Card(11,4));
		c.add(new Card(7,3));
		c.add(new Card(7,1));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		Hand hc = new Hand(d, c);

		assertEquals("LOSE", hc.whoWins(hb));
		assertEquals("LOSE", hc.whoWins(ha));
		assertEquals("WIN", hb.whoWins(ha));
	}

	@Test
	//76) Testing 3 Players All with identical Hands (no exchanges):p2	wins because of Queen of spade
	public void test76() {
		Deck d = new Deck();
		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();

		a.add(new Card(12,1));
		a.add(new Card(11,2));
		a.add(new Card(10,2));
		a.add(new Card(9,2));
		a.add(new Card(8,2));

		b.add(new Card(12,4));
		b.add(new Card(11,3));
		b.add(new Card(10,3));
		b.add(new Card(9,3));
		b.add(new Card(8,3));

		c.add(new Card(12,3));
		c.add(new Card(11,1));
		c.add(new Card(10,1));
		c.add(new Card(9,1));
		c.add(new Card(8,1));

		Hand ha = new Hand(d, a);
		Hand hb = new Hand(d, b);
		Hand hc = new Hand(d, c);

		assertEquals("LOSE", hc.whoWins(hb));
		assertEquals("WIN", hc.whoWins(ha));
		assertEquals("WIN", hb.whoWins(ha));
	}

	@Test
	//77) Testing 4 Players All with Different Hands (no exchanges): p2	wins with royal flush
	public void test77() {
		Deck de = new Deck();

		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();
		List<Card> d = new ArrayList<Card>();

		a.add(new Card(12,1));
		a.add(new Card(11,2));
		a.add(new Card(10,2));
		a.add(new Card(9,2));
		a.add(new Card(8,2));

		b.add(new Card(14,4));
		b.add(new Card(13,4));
		b.add(new Card(12,4));
		b.add(new Card(11,4));
		b.add(new Card(10,4));

		c.add(new Card(9,3));
		c.add(new Card(9,4));
		c.add(new Card(9,1));
		c.add(new Card(10,3));
		c.add(new Card(10,1));

		d.add(new Card(8,1));
		d.add(new Card(11,1));
		d.add(new Card(14,1));
		d.add(new Card(7,1));
		d.add(new Card(13,1));

		Hand ha = new Hand(de, a);
		Hand hb = new Hand(de, b);
		Hand hc = new Hand(de, c);
		Hand hd = new Hand(de, d);

		assertEquals("LOSE", ha.whoWins(hb));
		assertEquals("LOSE", ha.whoWins(hc));
		assertEquals("LOSE", ha.whoWins(hd));
		assertEquals("WIN", hb.whoWins(hc));
		assertEquals("WIN", hb.whoWins(hd));
		assertEquals("LOSE", hd.whoWins(hc));
	}

	@Test
	//78) Testing 4 Players 2 with identical hands (no exchanges): p3 wins	with flush
	public void test78() {
		Deck de = new Deck();

		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();
		List<Card> d = new ArrayList<Card>();

		a.add(new Card(12,3));
		a.add(new Card(11,2));
		a.add(new Card(10,1));
		a.add(new Card(9,2));
		a.add(new Card(8,2));

		b.add(new Card(12,2));
		b.add(new Card(11,1));
		b.add(new Card(10,2));
		b.add(new Card(9,1));
		b.add(new Card(8,1));

		c.add(new Card(14,4));
		c.add(new Card(7,4));
		c.add(new Card(12,4));
		c.add(new Card(11,4));
		c.add(new Card(10,4));

		d.add(new Card(7,1));
		d.add(new Card(6,1));
		d.add(new Card(4,1));
		d.add(new Card(14,1));
		d.add(new Card(2,1));

		Hand ha = new Hand(de, a);
		Hand hb = new Hand(de, b);
		Hand hc = new Hand(de, c);
		Hand hd = new Hand(de, d);

		assertEquals("WIN", ha.whoWins(hb));
		assertEquals("LOSE", ha.whoWins(hc));
		assertEquals("LOSE", ha.whoWins(hd));
		assertEquals("LOSE", hb.whoWins(hc));
		assertEquals("LOSE", hb.whoWins(hd));
		assertEquals("LOSE", hd.whoWins(hc));
	}

	@Test
	///79) Testing 4 Players 3 with flushes and no exchanges: highest flush	(p3) beats straight
	public void test79() {
		Deck de = new Deck();

		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();
		List<Card> d = new ArrayList<Card>();

		a.add(new Card(12,1));
		a.add(new Card(9,1));
		a.add(new Card(8,1));
		a.add(new Card(11,1));
		a.add(new Card(14,1));

		b.add(new Card(8,2));
		b.add(new Card(11,2));
		b.add(new Card(14,2));
		b.add(new Card(7,2));
		b.add(new Card(13,2));

		c.add(new Card(8,3));
		c.add(new Card(11,3));
		c.add(new Card(14,3));
		c.add(new Card(7,3));
		c.add(new Card(13,3));

		d.add(new Card(10,4));
		d.add(new Card(6,4));
		d.add(new Card(9,4));
		d.add(new Card(8,4));
		d.add(new Card(7,4));

		Hand ha = new Hand(de, a);
		Hand hb = new Hand(de, b);
		Hand hc = new Hand(de, c);
		Hand hd = new Hand(de, d);

		assertEquals("LOSE", ha.whoWins(hb));
		assertEquals("LOSE", ha.whoWins(hc));
		assertEquals("LOSE", ha.whoWins(hd));
		assertEquals("LOSE", hb.whoWins(hc));
		assertEquals("LOSE", hb.whoWins(hd));
		assertEquals("WIN", hd.whoWins(hc));
	}

	@Test
	//80) Testing 4 Players All with identical hands (no exchanges):	player with King of Spades wins
	public void test80() {
		Deck de = new Deck();

		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();
		List<Card> d = new ArrayList<Card>();

		a.add(new Card(8,4));
		a.add(new Card(11,4));
		a.add(new Card(14,4));
		a.add(new Card(7,4));
		a.add(new Card(13,4));

		b.add(new Card(8,2));
		b.add(new Card(11,2));
		b.add(new Card(14,2));
		b.add(new Card(7,2));
		b.add(new Card(13,2));

		c.add(new Card(8,3));
		c.add(new Card(11,3));
		c.add(new Card(14,3));
		c.add(new Card(7,3));
		c.add(new Card(13,3));

		d.add(new Card(8,1));
		d.add(new Card(11,1));
		d.add(new Card(14,1));
		d.add(new Card(7,1));
		d.add(new Card(13,1));

		Hand ha = new Hand(de, a);
		Hand hb = new Hand(de, b);
		Hand hc = new Hand(de, c);
		Hand hd = new Hand(de, d);

		assertEquals("WIN", ha.whoWins(hb));
		assertEquals("WIN", ha.whoWins(hc));
		assertEquals("WIN", ha.whoWins(hd));
		assertEquals("LOSE", hb.whoWins(hc));
		assertEquals("WIN", hb.whoWins(hd));
		assertEquals("LOSE", hd.whoWins(hc));
	}

	@Test
	//81) Testing 4 Players, Player 4 Changing 1 card: p2 wins with royal flush...
	public void test81() {
		Deck de = new Deck();

		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();
		List<Card> d = new ArrayList<Card>();

		a.add(new Card(12,1));
		a.add(new Card(11,2));
		a.add(new Card(10,1));
		a.add(new Card(9,2));
		a.add(new Card(8,2));

		b.add(new Card(14,4));
		b.add(new Card(13,4));
		b.add(new Card(12,4));
		b.add(new Card(11,4));
		b.add(new Card(10,4));

		c.add(new Card(9,3));
		c.add(new Card(9,4));
		c.add(new Card(9,1));
		c.add(new Card(10,3));
		c.add(new Card(10,2));

		d.add(new Card(8,4));
		d.add(new Card(11,1));
		d.add(new Card(14,1));
		d.add(new Card(7,1));
		d.add(new Card(13,1));

		Hand ha = new Hand(de, a);
		Hand hb = new Hand(de, b);
		Hand hc = new Hand(de, c);
		Hand hd = new Hand(de, d);

		List<Card> nextCards = new ArrayList<Card>();
		nextCards.add(new Card(8,1));

		d.set(0, nextCards.get(0));
		hd.evaluateHandRank();

		assertEquals("LOSE", ha.whoWins(hb));
		assertEquals("LOSE", ha.whoWins(hc));
		assertEquals("WIN", ha.whoWins(hd));
		assertEquals("WIN", hb.whoWins(hc));
		assertEquals("WIN", hb.whoWins(hd));
		assertEquals("LOSE", hd.whoWins(hc));
	}

	@Test
	//82) Testing 4 Players , each player exchanges cards: you figure out the ranking
	public void test82() {
		Deck de = new Deck();

		List<Card> a = new ArrayList<Card>();
		List<Card> b = new ArrayList<Card>();
		List<Card> c = new ArrayList<Card>();
		List<Card> d = new ArrayList<Card>();

		a.add(new Card(12,1));
		a.add(new Card(12,4));
		a.add(new Card(10,2));
		a.add(new Card(9,2));
		a.add(new Card(7,2));

		b.add(new Card(8,3));
		b.add(new Card(8,4));
		b.add(new Card(12,2));
		b.add(new Card(11,3));
		b.add(new Card(10,1));

		c.add(new Card(9,3));
		c.add(new Card(9,4));
		c.add(new Card(11,1));
		c.add(new Card(10,3));
		c.add(new Card(7,3));

		d.add(new Card(7,4));
		d.add(new Card(7,1));
		d.add(new Card(14,3));
		d.add(new Card(13,4));
		d.add(new Card(8,1));

		Hand ha = new Hand(de, a);
		Hand hb = new Hand(de, b);
		Hand hc = new Hand(de, c);
		Hand hd = new Hand(de, d);

		List<Card> nextCards1 = new ArrayList<Card>();
		nextCards1.add(new Card(2,2));
		nextCards1.add(new Card(12,3));
		nextCards1.add(new Card(9,1));

		List<Card> nextCards2 = new ArrayList<Card>();
		nextCards2.add(new Card(8, 2));
		nextCards2.add(new Card(13, 1));
		nextCards2.add(new Card(11, 4));

		List<Card> nextCards3 = new ArrayList<Card>();
		nextCards3.add(new Card(11, 2));
		nextCards3.add(new Card(13, 3));
		nextCards3.add(new Card(13, 2));

		List<Card> nextCards4 = new ArrayList<Card>();
		nextCards4.add(new Card(14, 1));
		nextCards4.add(new Card(14, 4));
		nextCards4.add(new Card(14, 2));

		List<Card> ce = ha.getCards();
		List<Integer> indexes = new ArrayList<Integer>();
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
			ha.swapSingleCardAtIndex(indexes.get(i), de, nextCards1.get(i));
		}

		indexes.clear();
		ce = hb.getCards();
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
			hb.swapSingleCardAtIndex(indexes.get(i), de, nextCards2.get(i));
		}


		indexes.clear();
		ce = hc.getCards();
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
			hc.swapSingleCardAtIndex(indexes.get(i), de, nextCards3.get(i));
		}
		indexes.clear();
		ce = hd.getCards();
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
			hd.swapSingleCardAtIndex(indexes.get(i), de, nextCards4.get(i));
		}
		hd.evaluateHandRank();
		hc.evaluateHandRank();
		hb.evaluateHandRank();
		ha.evaluateHandRank();
		assertEquals("WIN", ha.whoWins(hb));
		assertEquals("WIN", ha.whoWins(hc));
		assertEquals("LOSE", ha.whoWins(hd));
		assertEquals("WIN", hb.whoWins(hc));
		assertEquals("LOSE", hb.whoWins(hd));
		assertEquals("WIN", hd.whoWins(hc));
	}

}

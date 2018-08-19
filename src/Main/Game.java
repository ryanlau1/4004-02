package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	public void start(){
		Scanner scan = new Scanner(System.in);
		
		boolean alwaysShowing = true;
		String playAgain = "";
		
		while (!playAgain.equals("n")){
		
		Deck d;
		d = new Deck();
		
		List<Player> playerList;
		playerList = new ArrayList<Player>();
		
		int numPlayers = 0;
			//If player enters anything but 2, 3 or 4
			//Give error message
			while (numPlayers < 2 || numPlayers > 4){
				System.out.println("WELCOME TO SIMPLISTIC POKER");
				System.out.println("ENTER NUMBER OF AI PLAYERS (2-4): ");
				numPlayers = scan.nextInt();
				if (numPlayers < 2 || numPlayers > 4){
					System.out.println("INVALID NUMBER!");
				}
			}
			
			
			//Adding the player(s) to the player list
			for (int i = 0; i < numPlayers; i++){				
					playerList.add(new Player(d));
			}
			
			//Outputting Cards of players
			for (int j = 0; j < numPlayers; j++){
				System.out.println("CARDS FOR PLAYER " + (j+1) + " : ");
				List<Card> cList= playerList.get(j).getCardsInHand();
				
				for (int i = 0; i < cList.size(); i++){	
					if (alwaysShowing){
						System.out.print("   "+ cList.get(i).toString());
					}
					else{					
						
						if (cList.get(i).getShowing()){
							System.out.print("   "+ cList.get(i).toString());
						}
						else
						{
							System.out.print("  X  ");
						}
					}
				}
				System.out.println("");
			}
			System.out.println("");
			System.out.println("CARDS LEFT IN DECK: " + d.deckSize());
			System.out.println("");
			
			//Only available if cards are all shown
			
			//Evaluating Rank of Cards for each player
			for (int j = 0; j < numPlayers; j++){
				System.out.print("CARD RANK FOR PLAYER " + (j+1) + " : ");
				Hand h = playerList.get(j).getHand();
				
				if (alwaysShowing){
					System.out.println(h.getRankString());
				}
				else{
					int counter = 0;
					for (int i = 0; i < 5; i++){
						if (playerList.get(j).getCardsInHand().get(i).getShowing()){
							counter++;
						}
					}
						//If all cards are visible, then show rank of hand
						if (counter == 5){
							System.out.println(h.getRankString());
						}
						else
						{
							System.out.println("HIDDEN ");
						}
				}
				
			}
			
			System.out.println("");
			System.out.println("SWAPPING OUT CARDS.. \n");
			//Changing Cards			
			for (int j = 0; j < numPlayers; j++){
				
				System.out.println("PLAYER " + (j+1) + " USING STRATEGY " + (playerList.get(j).getStrategy()));
				//playerList.get(j).getHand().sort(playerList.get(j).getCardsInHand());		
				
				//Strategy 1
				//Strategy 1
				//Strategy 1
				//Strategy 1
				//Strategy 1
				
				if (playerList.get(j).getStrategy() == 1){
					
					//Check if one card off flush
					boolean oneCardOffFlush = false;
					//Checking for one card off flush
					int[] arrayy = new int[]{0,0,0,0};
					for (int i = 0; i < 5; i++){
						arrayy[playerList.get(j).getCardsInHand().get(i).getSuit()-1]++;
					}
					
					for (int i = 0; i < 4; i++){
						if (arrayy[i] == 4){
							oneCardOffFlush = true;
						}
					}
					
					
					//Check if one card off straight
					boolean oneCardOffStraight = false;
					int toBeReplaced = 0;
					int cons = 0;
					for (int i = 0; i < 4; i++){
						if (playerList.get(j).getHand().getCards().get(i).getRank() + 1 == playerList.get(j).getHand().getCards().get(i+1).getRank()){
							
						}
						else{
							cons++;
							toBeReplaced = i+1;
						}
						//System.out.println(playerList.get(j).getHand().getCards().get(i).getRank());
						//System.out.println(playerList.get(j).getHand().getCards().get(i+1).getRank());
					}
					if (cons == 1){
						oneCardOffStraight = true;
					}
					
					if (oneCardOffFlush){
						int[] array = new int[]{0,0,0,0,0};
						for (int i = 0; i < 4; i++){
							if (arrayy[playerList.get(j).getCardsInHand().get(i).getSuit()-1] == 1){
								array[i] = 1;
							}
						}
						if (alwaysShowing){
							System.out.print("PLAYER " + (j+1) + " HAS ONE CARD OFF A FLUSH, ROYAL FLUSH OR STRAIGHT FLUSH ");
							System.out.println("SWAPPING OUT REMAINING CARD \n");
						}
						else{
							System.out.print("PLAYER " + (j+1) + " HAS ??? ");
							System.out.println("SWAPPING OUT ONE CARD \n");
						}
						playerList.get(j).getHand().swapCard(array, d);
					}
					else if (oneCardOffStraight){
						int[] array = new int[]{0,0,0,0,0};
						array[toBeReplaced] = 1;
						if (alwaysShowing){
							System.out.print("PLAYER " + (j+1) + " HAS ONE CARD OFF A STRAIGHT, ROYAL FLUSH OR STRAIGHT FLUSH ");
							System.out.println("SWAPPING OUT REMAINING CARD \n");
						}
						else{
							System.out.print("PLAYER " + (j+1) + " HAS ??? ");
							System.out.println("SWAPPING OUT ONE CARD \n");
						}
						playerList.get(j).getHand().swapCard(array, d);
					}
					//If player has a 3 of a kind AND NOT A FULL HOUSE, swap the other 2 cards
					else if (playerList.get(j).getHand().getHandRank() == 3 && playerList.get(j).getHand().getHandRank() != 6){
						int[] array = new int[]{1,1,1,1,1};
						for (int i = 0; i < 4; i++){
							if (playerList.get(j).getCardsInHand().get(i).getRank() == playerList.get(j).getCardsInHand().get(i+1).getRank()){
								array[i] = 0;
								array[i+1] = 0;
								
							}
						}
						if (alwaysShowing){
							System.out.print("PLAYER " + (j+1) + " HAS THREE OF A KIND ");
							System.out.println("SWAPPING OUT REMAINING TWO CARDS \n");
						}
						else{
							System.out.print("PLAYER " + (j+1) + " HAS ??? ");
							System.out.println("SWAPPING OUT TWO CARDS \n");
						}
						//Swap the cards
						playerList.get(j).getHand().swapCard(array, d);
					}
					//If player has 2 pairs AND NOT A FULL HOUSE, swap the remaining two cards
					else if (playerList.get(j).getHand().getHandRank() == 2 && playerList.get(j).getHand().getHandRank() != 6){
						int[] array = new int[]{1,1,1,1,1};
						//Check if pair
						for (int i = 0; i < 4; i++){
							if (playerList.get(j).getCardsInHand().get(i).getRank() == playerList.get(j).getCardsInHand().get(i+1).getRank()){
								array[i] = 0;
								array[i+1] = 0;
								
							}
						}
						if (alwaysShowing){
							System.out.print("PLAYER " + (j+1) + " HAS TWO PAIR ");
							System.out.println("SWAPPING OUT REMAINING CARD \n");						
						}
						else{
							System.out.print("PLAYER " + (j+1) + " HAS ??? ");
							System.out.println("SWAPPING OUT ONE CARD \n");
						}
						playerList.get(j).getHand().swapCard(array, d);
					}
					
					//If player has 1 pair, swap the remaining 3 cards
					else if (playerList.get(j).getHand().getHandRank() == 1){
						int[] array = new int[]{1,1,1,1,1};
						//Check if pair
						for (int i = 0; i < 4; i++){
							if (playerList.get(j).getCardsInHand().get(i).getRank() == playerList.get(j).getCardsInHand().get(i+1).getRank()){
								array[i] = 0;
								array[i+1] = 0;
								
							}
						}
						if (alwaysShowing){
							System.out.print("PLAYER " + (j+1) + " HAS PAIR ");
							System.out.println("SWAPPING OUT REMAINING 3 CARDS \n");
						}
						else{
							System.out.print("PLAYER " + (j+1) + " HAS ??? ");
							System.out.println("SWAPPING OUT THREE CARDS \n");
						}
						//Swap the cards
						playerList.get(j).getHand().swapCard(array, d);
					}
					//If player has high card, keep two highest and exchange remaining 3
					else if (playerList.get(j).getHand().getHandRank() == 0){
						if (alwaysShowing){
							System.out.print("PLAYER " + (j+1) + " HAS HIGH CARD ");
							System.out.println("SWAPPING OUT 3 LOWEST CARDS \n");
						}
						else{
							System.out.print("PLAYER " + (j+1) + " HAS ??? ");
							System.out.println("SWAPPING OUT THREE CARDS \n");
						}
						//Swap
						int[] array = new int[]{1,1,1,0,0};
						playerList.get(j).getHand().swapCard(array, d);
					
					//In any other case, do not swap cards
					}
					else{
						System.out.println("PLAYER " + (j+1) + " WILL NOT SWAP \n");
					}
				
				}
				//Strategy 2
				//Strategy 2
				//Strategy 2
				//Strategy 2
				//Strategy 2
				
				else if (playerList.get(j).getStrategy() == 2){
					//If First Player, go back and change to strategy 2
					if (j == 0){
						System.out.println("PLAYER FIRST TO GO. WILL REUSE STRATEGY 1");
						playerList.get(j).setStrategy(1);
						j--;
					}
					//Else if any player before has 3 or more visible of same suit
					else if (j != 0){
						int playerCounter = 1;
						int shownCards = 0;
						int[] suitOccurrences = new int[]{0,0,0,0};
						while (j-playerCounter >= 0){
							for (int i =0; i < 5; i++){
								if (playerList.get(j-playerCounter).getCardsInHand().get(i).getShowing() == true){
									shownCards++;
								}
							}
							if (shownCards >= 3){
								for (int i =0; i < 5; i++){
									if (playerList.get(j-playerCounter).getCardsInHand().get(i).getShowing() == true){
										suitOccurrences[playerList.get(j-playerCounter).getCardsInHand().get(i).getSuit()-1]++;
									}
								}
							}
							for (int i = 0; i < 4; i ++){
								if (suitOccurrences[i] >= 3){
									System.out.println("PLAYER NOT FIRST TO GO. WILL USE LOOK AT VISIBLE CARDS STRATEGY ");
									int []suitOc = new int[]{0,0,0,0};
									//If 3 or more visible cards from a player are of the same suit
									//Keep the cards with the suit you have the most of
									for (int x = 0; x < 5; x++){
										suitOc[playerList.get(j).getCardsInHand().get(x).getSuit()-1]++;
									}
									//Most frequent suit, the one to keep
									int mostFreq = 0;
									int record = 0;
									for (int u = 0; u < 4; u++){
										if (suitOc[u] > record){
											record = suitOc[u];
											mostFreq = u;
										}
									}
									int[] arrayy = new int[]{0,0,0,0,0};
									for (int u = 0; u < 5; u++){
										if (playerList.get(j).getCardsInHand().get(u).getSuit() != mostFreq){
											arrayy[u] = 1;
										}
									}
									playerList.get(j).getHand().swapCard(arrayy, d);
								}
								i = 5;
							}
							shownCards = 0;
							playerCounter++;
						}
					}
					//If flush or higher, do not swap
					else if (playerList.get(j).getHand().getHandRank() >= 5 ){
						System.out.println("PLAYER " + (j+1) + " WILL NOT SWAP \n");
					}
					//If 3 or more of the same rank card are revealed
					else if (j != 0){
						int shownCards = 0;
						int playerCounter = 1;
						while (j-playerCounter > 0){
							for (int i = 0; i < 5; i++){
								if (playerList.get(j-playerCounter).getCardsInHand().get(i).getShowing() == true){
									shownCards++;
								}
							}
							if (shownCards >= 3){
								if (playerList.get(j-playerCounter).getHand().getShowingCards().get(0).getRank() == playerList.get(j-playerCounter).getHand().getShowingCards().get(1).getRank()
										&& playerList.get(j-playerCounter).getHand().getShowingCards().get(0).getRank()  == playerList.get(j-playerCounter).getHand().getShowingCards().get(2).getRank()){
									//If the player has 3 or more of a kind
									int[] array = new int []{0,0,0,0,0};
									playerList.get(j).getHand().sort(playerList.get(j).getCardsInHand());
									for (int i = 0; i < 4; i++){
										if(playerList.get(j).getCardsInHand().get(i).getRank() != playerList.get(j).getCardsInHand().get(i+1).getRank()){
											array[i] = 1;
										}
										
										playerList.get(j).getHand().swapCard(array, d);
									}
									
								}
							}
							playerCounter++;
						}
					
					}					
					//Else reuse option 2 strategy 1
					else{
						System.out.println("PLAYER WILL REUSE STRATEGY 1");
						playerList.get(j).setStrategy(1);
						j--;
					}
				}
			}
			if (!alwaysShowing){
				for (int j = 0; j < numPlayers; j++){
					Collections.shuffle(playerList.get(j).getCardsInHand());
				}
			}
			//Outputting Cards of players
			for (int j = 0; j < numPlayers; j++){
				playerList.get(j).getHand().evaluateHandRank();
				System.out.println("CARDS FOR PLAYER " + (j+1) + " : ");
				if (alwaysShowing){
					List<Card> cList= playerList.get(j).getCardsInHand();
					
					for (int i = 0; i < cList.size(); i++){
						System.out.print("   "+ cList.get(i).toString());
					}
					System.out.println("");
				}
				else{
					List<Card> cList= playerList.get(j).getCardsInHand();
					
					for (int i = 0; i < cList.size(); i++){
						if (cList.get(i).getShowing()){
							System.out.print("   "+ cList.get(i).toString());
						}
						else{
							System.out.print("  X  ");
						}
					}
					System.out.println("");
					
				}
			}
			System.out.println("");
			System.out.println("CARDS LEFT IN DECK: " + d.deckSize());
			System.out.println("");
			
			//Evaluating Rank of Cards for each player
			for (int j = 0; j < numPlayers; j++){
				if (alwaysShowing){
					System.out.print("CARD RANK FOR PLAYER " + (j+1) + " : ");
					Hand h = playerList.get(j).getHand();				
					System.out.println(h.getRankString());
				}
				else{
					System.out.print("CARD RANK FOR PLAYER " + (j+1) + " : ");
					System.out.print("HIDDEN \n");
				}
				
			}
			if (alwaysShowing == false){
			System.out.println("");
			System.out.println("");
			//Show all cards
			System.out.println("SHOWDOWN! REVEAL TIME ! \n");
			for (int j = 0; j < numPlayers; j++){
				playerList.get(j).getHand().evaluateHandRank();
				System.out.println("CARDS FOR PLAYER " + (j+1) + " : ");
					List<Card> cList= playerList.get(j).getCardsInHand();
					
						for (int i = 0; i < cList.size(); i++){
							System.out.print("   "+ cList.get(i).toString());
						}
					System.out.println("\n");
			}
			
			for (int j = 0; j < numPlayers; j++){
					System.out.print("CARD RANK FOR PLAYER " + (j+1) + " : ");
					Hand h = playerList.get(j).getHand();
					System.out.println(h.getRankString());
			}
			}
			//Checking who wins
			int currBest = 0;
			int winner = -1;
			for (int j = 0; j < numPlayers-1; j++){
				for (int x = j+1; x < numPlayers; x++){
					if (currBest == 0){
						currBest = playerList.get(j).getHand().getHandRank();
						winner = j;							
					}	
					if (playerList.get(j).getHand().betterHandRank(playerList.get(x).getHand()) == 1){
						if (currBest < playerList.get(j).getHand().getHandRank()){
							currBest = playerList.get(j).getHand().getHandRank();
							winner = j;
						}
					}
					else if (playerList.get(j).getHand().betterHandRank(playerList.get(x).getHand()) == 2){
						//If the winning hand beats the current best hand
						if (currBest < playerList.get(x).getHand().getHandRank()){
							currBest = playerList.get(x).getHand().getHandRank();
							winner = x;
						}					
					}
					//System.out.println("COMPARING " + j + " AND " + x);
					//System.out.print(playerList.get(j).getHand().getHandRank());
					//System.out.print(playerList.get(x).getHand().getHandRank());
					//System.out.print(currBest);
				}
			}
			
			//Outputting who wins
			System.out.println("");
			if (winner >= 0){
				System.out.println("PLAYER " + (winner+1) + " WON");
			}
			
			System.out.println("");
			//Ask user if they want to play again			
			System.out.println("PLAY AGAIN?: (y/n)");
			playAgain = scan.next();
		
			}
			scan.close();
		}
		//Hand u want to swap and cards you want to swap in
		public Hand swap3HoldPair(Hand h, Deck d, List<Card> r){
			List<Integer> indexes = new ArrayList<Integer>();
			List<Card> c = h.getCards();
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
			for (int i = 0; i < indexes.size() -1; i++){
				h.swapSingleCardAtIndex(indexes.get(i), d, r.get(i));
			}
			return h;
		}
		
		public Hand swap3HoldHighCard(Hand h, Deck d, List<Card> r){
			h.sort(h.getCards());
			List<Integer> indexes = new ArrayList<Integer>();
			indexes.add(0);
			indexes.add(1);
			indexes.add(2);
			for (int i = 0; i < indexes.size() -1; i++){
				h.swapSingleCardAtIndex(indexes.get(i), d, r.get(i));
			}
			return h;
		}
	
}

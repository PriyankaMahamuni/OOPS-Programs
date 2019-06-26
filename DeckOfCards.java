/**
 * @purpose 	: To print deck of cards.
 * @author 		: Priynka Mahamuni
 * @version 	: 1.0
 * @since 		: 08.06.19
 */
package com.bridgeit.ObjectOrintedPrograming;
import java.util.Random;
public class DeckOfCards {
	   String [] suits= {"Clubs","Diamond","spades","Hearts"};
	   String [] rank= {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	   String[] totalCards=new String[52];
	   public static void main(String[] args) 
	   {
		 DeckOfCards refDeck=new DeckOfCards();
		 refDeck.getCards();
		 refDeck.shuffleCards();
		 String[][] playerCards=refDeck.distribute(4, 9);
		 refDeck.showCards(playerCards);
	   }
	   public String[] getCards ()
	   {
		   int i=0;
		   for(String match:suits)
		   {
			   for(String card:rank)
			   {
				   totalCards[i]=card+"-"+match;
				   i++;
			   }
		   }
		   return totalCards;
	   }
	   public void shuffleCards()
	   {
		   
		   Random shuffling=new Random();
		   for(int i=0;i<totalCards.length;i++)
		   {
			   int index=shuffling.nextInt(52);
			   String temp=totalCards[index];
			   totalCards[index]=totalCards[i];
			   totalCards[i]=temp;		   
		   }
	   }
	   public String[][] distribute(int numberOfPlayers,int numberOfCards)
	   {
		   int k=0;
		   String[][] playerCards=new String [numberOfPlayers][numberOfCards];
		   for(int i=0;i<numberOfPlayers;i++)
		   {
			   for(int j=0;j<numberOfCards;j++ )
			   {
				   playerCards[i][j]=totalCards[k];
				   k++;
			   }
		   }
		   return playerCards;
	   }
	   public void showCards(String [][] playerCards)
	   {
		   int i=1;
		   for(String[] printCard:playerCards)
		   {
			   System.out.println();
			   System.out.println("player "+i+" cards ");
			   System.out.println(" ");
			   i++;
			   for(String showCard:printCard)
			   {
				   System.out.println(showCard +" ");
			   }
		     System.out.println("  "); 
		   }
	   }

}

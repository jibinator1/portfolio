package problem_solving;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Smallest_Multiple {
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		
		System.out.println("how many players are there?");
		int players=myInput.nextInt();//Sets the player variable to the number of players playing the game to find how many times the loop will occur
		int totalPoints[]=new int[players];
		int playerNum=1;

		for(int i=0;i<players;i++) {

			//round1
			int diceRolled1[] = {randomDiceRoll(), randomDiceRoll(), randomDiceRoll(), randomDiceRoll(), randomDiceRoll()};//set for now, later will be random
			Arrays.sort(diceRolled1);//Sorts the array in numerical order
			int diceAside[]= new int[5];
			diceAside[0]=diceRolled1[3];
			diceAside[1]=diceRolled1[4];
			System.out.println(diceAside[0]+diceAside[1]);
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			//round2
			int diceRolled2[] = {randomDiceRoll(), randomDiceRoll(), randomDiceRoll()};//Set for now, later will be random
			Arrays.sort(diceRolled2);//Sorts the array in numerical order
			diceAside[2]=diceRolled2[0];
			System.out.println(diceAside[2]);
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			//round3
			int diceRolled3[] = {randomDiceRoll(), randomDiceRoll()};//set for now, later will be random
			Arrays.sort(diceRolled3);//Sorts the array in numerical order
			diceAside[3]=diceRolled2[1];
			System.out.println(diceAside[3]);

			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			//round4
			int diceRolled4[] = {randomDiceRoll()};//Set for now, later will be random
			Arrays.sort(diceRolled4);//Sorts the array in numerical order
			diceAside[4]=diceRolled4[0];
			System.out.println(diceAside[4]);

			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			int total=diceAside[0]+diceAside[1]-diceAside[2]+diceAside[3]-diceAside[4];

			System.out.println("The total for player number "+playerNum+" is: "+total);
			totalPoints[i]=total;
			playerNum=playerNum+1;
		}//end for loop
		findWinner(totalPoints);//Runs the totalPoints method
	}//end main

	public static int randomDiceRoll() {
		Random rand = new Random();
		int random_int = rand.nextInt(7);//Makes random number from 1-6
		return random_int;//Returns the random integer that was generated
	}//end randomDiceRoll method
	public static void findWinner(int[] totalPoints) {
		int max=0;
		int position=0;
		int numWinners=0;
		int x=0;
		int winners[]=new int[totalPoints.length];
		max=totalPoints[position];//Sets 0 as the interger at array[0]
		for(int i=0;i<totalPoints.length;i++) {
			if (totalPoints[i]>max) {//Runs only if the previous array is larger than previous
				max =totalPoints[i];
				position=i;//Finds the highest number position to the positon variable
			}
		}//end for loop
		
		for(int i=0;i<totalPoints.length;i++) {
			if(totalPoints[i]==max){//If there is more than 1 winner(have the same value), the totalpoints[i] will equal the max
				winners[x]=i;//Adds the position of winners in the winners array
				numWinners=numWinners+1;
				x=x+1;
			}
		}//end for loop
		
		if(numWinners==1) {//If the number of winners was only 1, just run the singular winner code
			position=position+1;
			System.out.println("Player number "+position+ " won the game!");
		}
		else {//If the number of winners was higher than 1, run the code where it will prints out the winners array
			System.out.println("Players number:");
			
			for(int i=0;i<numWinners;i++) {
				System.out.println((winners[i]+1));//Prints winner array+1 as arrays position starts at 0
			}
			System.out.println("won the game!");
		}
	}//end findWinner method
}



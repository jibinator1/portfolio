package problem_solving;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class fileio2redo {

	public static void main(String[] args) throws IOException {
		Scanner myInput = new Scanner(System.in);
		System.out.println("how many items are you adding to your to do list?");
		// Read an integer from the user and store it in the variable size
		int size = myInput.nextInt();
		int originalSize = size;
		// Create three arrays to store the task names, priorities, and time limits
		String[] todoList = new String[size];
		int[] priority = new int[size];
		int[] time = new int[size];

		// Loop through the array and read input from the user for each task
		for (int i = 0; i < size; i++) {
			myInput.nextLine(); // Clear the input buffer
			System.out.println("Please input your to do list");
			// Read a string from the user and store it in the todoList array
			todoList[i] = myInput.nextLine();
			System.out.println("What is the priority level? (lower the number, higher the priority)");
			// Read an integer from the user and store it in the priority array
			priority[i] = myInput.nextInt();
			System.out.println("How many days do you have for this task?");
			// Read an integer from the user and store it in the time array
			time[i] = myInput.nextInt();
		}
		// Call the menu function
		menu(todoList, size, priority, time, originalSize);
	}//end main method

	public static void menu(String[] todoList, int size, int[] priority, int[] time, int originalSize) throws IOException {
		FileWriter myWriter = new FileWriter("secondfileio.txt", true);
		File file = new File("secondfileio.txt");
		Scanner input = new Scanner(file);

		input.useDelimiter(" +"); //delimitor is one or more spaces
		Scanner myInput = new Scanner(System.in);
		System.out.println("Please enter the letter of which you would like to do\nA) Display Current List\nB) Add a new task to your list(s)\nC) Finish a task on the list \nD) Measure Progress \nE) Exit");
		String menuResponse = myInput.nextLine();

		// Use a switch statement to execute different code based on user input
		switch (menuResponse.toUpperCase()) {
			case "A":
				// Call the displayTasks function 
				displayTasks(todoList, priority, time, size, originalSize);
				break;
			case "B":
				// Call the addTask function
				todoList = addTask(todoList, priority, time, size, originalSize, myWriter);
				break;
			case "C":
				// Call the finishTask function 
				finishTask(todoList, priority, time, size, originalSize);
				break;
			case "D":
				// Call the progress function
				progress(originalSize, size, priority, time, myWriter);
				break;
			case "E":
				// Exit the program
				System.exit(0);
		}
	}

	public static void displayTasks(String[] todoList, int[] priority, int[] time, int size, int originalSize) throws IOException {
		for(int i=0; i<size; i++) {
			// A loop that iterates through the given size of the arrays and prints out the task name, priority, and time to complete.
			System.out.println("Task Name: "+todoList[i]+" Priority: "+ priority[i]+" Time: "+time[i]);
		}
		// Calls the menu method with the given arrays and original size to return to the main menu.
		menu(todoList,size, time, priority, originalSize);
	}//end displayTasks method
	
	public static String[] addTask(String[] todoList, int[] priority, int[] time, int size, int originalSize, FileWriter myWriter) throws IOException {
		PrintWriter myPrinter = new PrintWriter(myWriter);
		File file = new File("secondfileio.txt");
		Scanner input = new Scanner(file);
		Scanner myInput = new Scanner (System.in);
		String [] temp=new String[size+1];//creates a temporary array to put the new value in
		int [] tempTime=new int[size+1];//creates a temporary array to put the new value in
		int [] tempPriority=new int[size+1];//creates a temporary array to put the new value in

		String newTask=input.next();
		// Takes in the user's input as a new task.
		for(int i=0; i<size; i++) {
			temp[i]=todoList[i];
			// Copies over the old array to a temporary array
		}

		int newPriority=input.nextInt();
		
		for(int i=0; i<size; i++) {
			tempPriority[i]=priority[i];
			// Copies over the old priority array to a temporary array
		}

		int newTime=input.nextInt();
		for(int i=0; i<size; i++) {
			tempTime[i]=time[i];
			// Copies over the old time array to a temporary array for modification.
		}
		temp[size]=newTask;
		// Sets the last index of the temp array to the new task.
		tempPriority[size]=newPriority;
		// Sets the last index of the temp priority array tonewPriority.
		tempTime[size]=newTime;
		// Sets the last index of the time array to tempZtime 
		myPrinter.print("\n");
	input.close();
	myPrinter.close();
	myWriter.close();

		menu(temp, size+1, tempTime, tempPriority, originalSize+1);
		// Calls the menu method
		return temp;
	}//end addTask method
	
	public static void finishTask(String[] todoList, int[] priority, int[] time, int size, int originalSize) throws IOException {
	    Scanner myInput = new Scanner(System.in);
	    System.out.println("Please input the name of the task you have finished");
	    String task = myInput.nextLine();
	    int deleteIndex = -2;

	    for (int i = 0; i < size; i++) {
	        if (todoList[i].equals(task)) {
	            deleteIndex = i;
	            break;
	        }
	    }

	    if (deleteIndex == -2) {
	        System.out.println("Task not found");
	    } else {
	        System.arraycopy(todoList, deleteIndex + 1, todoList, deleteIndex, size - deleteIndex - 1);
	        todoList[size - 1] = null;
	        priority[size - 1] = 0;
	        time[size - 1] = 0;
	        size--;
	        System.out.println("Task removed");
	    }

	    menu(todoList, size, priority, time, originalSize);
	}


	public static void progress(int originalSize, int size, int[] priority, int [] time, FileWriter myWriter) throws IOException {
		PrintWriter myPrinter = new PrintWriter(myWriter);
		   int finishedTasks = originalSize - size;
		    int percentage = (int) (((double) finishedTasks / originalSize) * 100);//calculations to find percentage
		    double average = 0;
		    int totalTime=0;
		    int max=0;
			int position=0;
			max=time[position];
			for(int i=0;i<time.length;i++) {
				if (time[i]>max) {
					max =time[i];
				}
			}
			// Loop through the array and calculate the total time
			for (int i = 0; i < time.length; i++) {
			    totalTime += time[i];
			}

			// Calculate the average time
			if (time.length > 0) {
			    average = totalTime / time.length;
			}
		    myPrinter.println("You have finished " + percentage + "% of your tasks.");
		    myPrinter.println("You have " + size + " tasks left to do.");
		    myPrinter.println("The average days you have is "+average);
		    myPrinter.println("You have "+max+" days to finish all your tasks");
			myPrinter.close();
	}//end progress method
	

}//end class
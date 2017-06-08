import java.util.*;
import java.lang.*;
import java.io.*;

public class Knapsack 
{
	private static Scanner scanChecker(String[] argv)
	{
		Scanner in;
		// Did the user input a file?
		if(argv.length < 1)
		{
			System.out.println("File name not inputted, exitting program.");
			in = null;
		}

		// Does the file exist?
		try
		{
			in = new Scanner(new File(argv[0]));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found, exiting program.");
			in = null;
		}

		return in;
	}

	// Easy print array function for debugging purposes
	private static void printArr(int[] arr)
	{		
		for (int i = 0; i < arr.length; ++i)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] argv)
	{
		int numItems, counter, capacity, timeLmt;
		int[] values, weights;

		// Open + check input file
		Scanner fileScn = scanChecker(argv);

		// Set the time limit (default = 5 mins)
		timeLmt = 5;
		if(argv.length > 1)
		{
			timeLmt = Integer.parseInt(argv[1]);
		}

		// Get array sizes and create arrays to hold values
		numItems = Integer.parseInt(fileScn.next());
		values = new int[numItems];
		weights = new int[numItems];
		fileScn.nextLine();

		// Appending all the weights and values into their corresponding list
		for(int i = 0; i <= numItems - 1; ++i)
		{	
			// Append all the lines of text into an array
			String[] line = fileScn.nextLine().split("\\s+");
			int lmt = line.length - 1;

			values[i] = Integer.parseInt(line[lmt - 1]);
			weights[i] = Integer.parseInt(line[lmt]);
		}

		//	Get capacity last
		capacity = Integer.parseInt(fileScn.next());

		// Only use brute force if item number is small
		if(numItems <= 25)
		{
			BruteForce.compute(capacity, numItems, values, weights);
		}

		Greedy.compute(capacity, numItems, values, weights);
		Dynamic.compute(capacity, numItems, values, weights);
		BranchAndBound.compute(capacity, numItems, values, weights, timeLmt);
	}

}
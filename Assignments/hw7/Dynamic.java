import java.util.*;
import java.lang.*;
import java.io.*;

public class Dynamic
{
	// Compute optimal solution using bottom-up approach
	public static void compute(int capacity, int numItems, int[] values, int[] weights)
	{
		// Create a valTable to track values
		int [][] valTable = new int[numItems + 1][capacity + 1];
		for(int i = 0; i <= numItems - 1; ++i)
		{
			for(int j = 0; j <= capacity; ++j)
			{
				// Check to see if item should be taken
				if(weights[i] <= j)
				{
					valTable[i + 1][j] = Math.max(valTable[i][j], valTable[i][j - weights[i]] + values[i]);
				}
				else
				{
					valTable[i + 1][j] = valTable[i][j];
				}
			}
		}
		traceBack(capacity, numItems, values, weights, valTable);
	}

	public static void traceBack(int capacity, int numItems, int[] values, int[] weights, int[][] valTable)
	{
		int notTaken = numItems;
		int aSpace = capacity;

		int totalValue = 0;
		int totalWeight = 0;

		ArrayList<Integer> taken = new ArrayList<Integer>();

		// While items exist
		while(notTaken > 0 && aSpace >= 0)
		{
			if(valTable[notTaken][aSpace] != valTable[notTaken - 1][aSpace])
			{
				taken.add(notTaken--);
				totalValue += values[notTaken];
				totalWeight += weights[notTaken];
				aSpace -= weights[notTaken];
			}
			else
			{
				--notTaken;
			}
		}
		printResults(totalValue, totalWeight, taken);
	}

	public static void printResults(int value, int weight, ArrayList<Integer> taken)
	{
		Collections.sort(taken);
		System.out.println("DYNAMIC PROGRAMMING: Value "
					+ value + ", Weight " + weight);
		for(int obj : taken)
		{
			System.out.print(obj + " ");
		}
		System.out.println();
	}
}
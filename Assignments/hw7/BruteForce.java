import java.util.*;
import java.lang.*;
import java.io.*;

public class BruteForce
{
	public static void compute(int capacity, int numItems, int[] values, int[] weights)
	{
		int maxValue = 0;
		int weight = 0;
		int curValue = 0;
		int curWgt = 0;

		String bestOption = "";

		// Generates all possible combinations of items we can obtain
		ArrayList<String> options = getBinStrings(numItems, "", new ArrayList<String>());

		for(String option : options)
		{
			curValue = 0;
			curWgt = 0;

			for(int i = 0; i < numItems; ++i)
			{
				if(option.charAt(i) == '1')
				{
					curValue += values[i];
					curWgt += weights[i];
				}
			}

			// See if option fits in backpack + greater than last possible combination
			if(curWgt <= capacity && curValue > maxValue)
			{
				maxValue = curValue;
				weight = curWgt;
				bestOption = option;
			}
		}

		printResults(numItems, maxValue, weight, bestOption);


	}

	private static void printResults(int numItems, int maxValue, int weight, String bestOption)
	{
		System.out.println("BRUTE FORCE: " + 
			"Value " + maxValue + ", Weight " + weight);

		for(int i = 0; i < numItems; ++i)
		{
			if(bestOption.charAt(i) == '1')
			{
				System.out.print((i + 1) + " ");
			}
		}

		System.out.println();

	}

	// Generates a binary string w/ length numItems
	private static ArrayList<String> getBinStrings(int length, String input, ArrayList<String> binString)
	{
		if(length < 1)
		{
			binString.add(input);
		}
		else
		{
			getBinStrings(length - 1, input + "0", binString);
			getBinStrings(length - 1, input + "1", binString);
		}
		return binString;
	}

}
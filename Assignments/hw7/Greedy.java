import java.util.*;
import java.lang.*;
import java.io.*;

public class Greedy
{
	public static void compute(int capacity, int numItems, int[] values, int[] weights)
	{
		Item [] items = new Item[numItems];
		int curCap = capacity;
		int weight = 0;
		int maxValue = 0;

		ArrayList<Integer> options = new ArrayList<Integer>();

		for(int i = 0; i < numItems; ++i)
		{
			items[i] = new Item(values[i], weights[i], i + 1);
		}

		// Sort array by smallest ratio value to largest
		Arrays.sort(items, new Item.ItemComparator());

		for(Item curItem : items)
		{
			if(curCap > curItem.weight)
			{
				curCap -= curItem.weight;
				maxValue += curItem.value;
				weight += curItem.weight;
				options.add(curItem.number);
			}

			if(curCap <= 0)
			{
				break;
			}
		}

		Collections.sort(options);

		printResults(maxValue, weight, options);
	}

	private static void printResults(int maxValue, int weight, ArrayList<Integer> options)
	{
		System.out.println("GREEDY (not necessarily optimal): " + 
			"Value " + maxValue + ", Weight " + weight);

		for(Integer option : options)
		{
			System.out.print(option + " ");
		}
		System.out.println();
	}
}
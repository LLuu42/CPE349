import java.util.*;
import java.util.Arrays;
import java.lang.*;
import java.io.*;

public class BranchAndBound
{
	public static void compute(int capacity, int numItems, int[] values, int[] weights, int time)
	{
		// Utilize a timer to tell if BnB is taking too long
		long start = System.currentTimeMillis();
		boolean timeout = false;
		Node best = new Node();
		Node root = new Node();

		Item[] objects = new Item[numItems];

		// Fill objects array with created items
		for(int i = 0; i < numItems; ++i)
		{
			objects[i] = new Item(values[i], weights[i], i + 1);
		}

		// Sort the items based on the weight vs. value ratio
		Arrays.sort(objects, new Item.ItemComparator());

		// Find the initial starting point
		root.findUpBnd(capacity, numItems, objects);

		PriorityQueue<Node> itmQueue = new PriorityQueue<Node>();
		itmQueue.offer(root);

		// Check queue
		while(!itmQueue.isEmpty() && !timeout)
		{
			Node node = itmQueue.poll();

			// Check time for timeout
			if(System.currentTimeMillis() - start > time * 60000)
			{
				timeout = true;
				System.out.println("Reached timeout of " + time + " minutes.");
			}

			// Check if better node exists
			else if(node.uBound > best.nodeValue)
			{
				Node leftNode = new Node(node);

				// Keep track of item's level
				int itemNbr = node.level;

				// Update new node's level
				++ leftNode.level;

				// Include new node's weight
				leftNode.nodeWgt += objects[itemNbr].weight;

				// Check for capacity; if good, add item
				if(leftNode.nodeWgt <= capacity)
				{
					leftNode.taken.add(objects[itemNbr].number);
					leftNode.nodeValue += objects[itemNbr].value;

					// Check for more items
					if(leftNode.level < numItems)
					{
						leftNode.findUpBnd(capacity, numItems, objects);
					}

					// Update if best
					if(leftNode.nodeValue > best.nodeValue)
					{
						best = leftNode;
					}

					// If not best (but possible best) continue down
					if (leftNode.uBound > best.nodeValue && leftNode.level < numItems)
					{
						itmQueue.offer(leftNode);
					}
				}

				// If item was not taken
				Node rightNode = new Node(node);

				// Go down a level
				++rightNode.level;

				// Traverse tree after finding upper bound
				if(rightNode.level < numItems)
				{
					rightNode.findUpBnd(capacity, numItems, objects);
					if(rightNode.uBound > best.nodeValue)
					{
						itmQueue.offer(rightNode);
					}
				}
			}
		}
		printResults(best.nodeValue, best.nodeWgt, best.taken);
	}


	public static void printResults(int value, int weight, ArrayList<Integer> items)
	{
		System.out.println("BRANCH AND BROUND: Value " + value + " Weight " + weight);
		Collections.sort(items);
		for(int item : items)
		{
			System.out.print(item + " ");
		}
		System.out.println();
	}
}
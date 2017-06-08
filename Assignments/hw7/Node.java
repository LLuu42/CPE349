import java.util.*;
import java.lang.*;
import java.io.*;

public class Node implements Comparable<Node>
{
	int level, nodeWgt, nodeValue;
	double uBound;
	ArrayList<Integer> taken;

	// Default constructor - initializes everything to zero
	public Node()
	{
		this.level = 0;
		this.nodeWgt = 0;
		this.nodeValue = 0;
		this.uBound = 0;
		this.taken = new ArrayList<Integer>();
	}

	public Node(Node other)
	{
		this.level = other.level;
		this.nodeWgt = other.nodeWgt;
		this.nodeValue = other.nodeValue;
		this.uBound = 0;
		taken = new ArrayList<Integer>();
		taken.addAll(other.taken);
	}

	public void findUpBnd(int cap, int numItems, Item[] objects)
	{
		// Initialize calculations with current level, weight, and starting upper bound
		int currItem = this.level;
		int tmpwgt = this.nodeWgt;
		this.uBound = this.nodeValue;

		// Bound: while items exist and there is space
		while(currItem < numItems && tmpwgt + objects[currItem].weight <= cap)
		{
			tmpwgt += objects[currItem].weight;
			this.uBound += objects[currItem].value;
			++currItem;
		}

		if(currItem == numItems)
		{
			--currItem;
		}

		uBound += (cap - tmpwgt) * 1.0 * objects[currItem].value / objects[currItem].weight;

	}

	public int compareTo(Node node)
	{
		return (int) (node.uBound - this.uBound);
	}
}
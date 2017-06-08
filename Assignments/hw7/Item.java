import java.util.*;
import java.lang.*;
import java.io.*;

public class Item
{
	int weight, value, number;

	public Item(int value, int weight, int number)
	{
		this.value = value;
		this.weight = weight;
		this.number = number;
	}

	public static class ItemComparator implements Comparator<Object>
	{
		public int compare(Object obj1, Object obj2)
		{
			Item item1 = (Item) obj1;
			Item item2 = (Item) obj2;

			// Orders items by value/weight ratio
			double r1 = item1.value / (item1.weight + 1.0);
			double r2 = item2.value / (item2.weight + 1.0);

			if(r1 < r2)
			{
				return 1;
			}
			else if(r1 > r2)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}

		public boolean compare(Object object)
		{
			boolean ret = true;
			if(object == null || !object.getClass().equals(this.getClass()))
			{
				ret = false;
			}
			return ret;
		}

	}
}
import java.lang.*;
import java.util.*;
import java.io.*;

public class RodCutter
{
	public static int [] cutRod(int [] prices, int length) 
	{
		/* Store total values for each length */
    	int [] value = new int [length + 1];
    	/* Store the cut that had to be made at that length */
    	int [] cuts = new int [length + 1];

    	/* Begin keeping track of values as we traverse through the possible pipe lengths*/
    	value[0] = 0;
    	for (int i = 1; i <= length; i++) 
    	{
      		int maxSoFar = -1;
      		for (int j = 0; j < i; j++) 
      		{
        		if (maxSoFar < prices[j] + value[i-j-1]) 
        		{        
          			maxSoFar = prices[j] + value[i-j-1];
          			cuts[i] = j+1;
        		}
      		}
      		/* print out and store the highest value of the cuts of that length */
      		System.out.println("total for length " + i + "\t= " + maxSoFar);
      		value[i] = maxSoFar;
    	}
    	/* return the cuts made */
    	return cutsMade(cuts, length);
  	}

	private static int [] cutsMade(int [] cuts, int length) 
	{
 		int [] cutsMade = new int [length + 1]; // Stores how many of each cut is made
    	int remainder = length; // remainder of the rod to be cut

    	while (remainder > 0) 
    	{
      		int cutLength = cuts[remainder];
      		cutsMade[cutLength]++;
      		remainder = remainder - cuts[remainder];
    	}

    	return cutsMade;
  	}

	private static void printCuts(int [] cutsMade) 
	{
    	/* Iterate through every cut made */
    	for (int i = 0; i < cutsMade.length; i++) 
    	{
      		if (cutsMade[i] != 0) 
      		{
        		System.out.println("Number of rods of length " + i + "\t= "+ cutsMade[i]);
      		}
    	}
    	System.out.println();
	}

	public static void main(String[] argv)
	{
		/* Read file input */
		Scanner scan = new Scanner(System.in);
		System.out.print("File name: ");
		String filename = scan.next();

		/* Attempt to open file */
		try
		{
			Scanner fileScanner = new Scanner(new File(filename));

			/* Read the number of test cases */
			int testCount = Integer.parseInt(fileScanner.nextLine().split("\\s+")[0]);

			for(int i = 1; i <= testCount; ++i)
			{
				System.out.println("Case " + i + ": ");
				System.out.println();

				/* Read in length of rod */
				int length = Integer.parseInt(fileScanner.nextLine().split("\\s+")[0]);
				
				/* Append array of possible prices */
				int[] prices = new int[length];
				String[] data = fileScanner.nextLine().split(" ");
				for(int j = 0; j < length; ++j)
				{
					prices[j] = Integer.parseInt(data[j]);
				}

				/* Run calculation algorithm + print out results */
				printCuts(cutRod(prices, length));

			}
		}
		catch(Exception e)
		{
			/* Throw File not Found Exception */
			System.out.println(e);
		}
	}
}
import java.util.*;
import java.lang.*;

class Inversions
{
	public static int invCounter(int[] ranking)
	{
		int[] tmp = new int[ranking.length];

		/* Use mergesort to calculate number of inversions */
		return mergeSort(ranking, tmp, 0, ranking.length -1);
	} 

	private static int mergeSort(int[] arr, int[] tmp, int left, int right)
	{
		/* Number of inversions: 0 if sorted */
		int inversions = 0;

		if(left < right)
		{
			/* Inversions exist */

			/* Find the center of the array */
			int center = (left + right) / 2;

			/* Sort and count inversions separately */
			int invLeft = mergeSort(arr, tmp, left, center);
			int invRight = mergeSort(arr, tmp, center + 1, right);

			/* Add all inversions together */
			inversions = invLeft + invRight + merge(arr, tmp, left, center + 1, right);
		}
		return inversions;
	}

  private static int merge (int[] arr, int[] tmp, int leftStart, int rightStart, int end)
  {
    /* End point of the left array */
    int leftEnd = rightStart - 1;

    /* Starting point of sorted array */
    int sorted = leftStart;

    /* size of the sorted array */
    int size = end - leftStart + 1;

    int inversions = 0;

    /* Iterating through vales to compare */
    while(leftStart <= leftEnd && rightStart <= end)
    {
      /* Merge the two sides of the list */
      if(arr[leftStart] < arr[rightStart])
      {
        /* Copy left over to tmp */
        tmp[sorted] = arr[leftStart];
        sorted ++;
        leftStart ++;
      }
      else
      {
        /* Copy right over to tmp */
        tmp[sorted] = arr[rightStart];
        sorted ++;
        rightStart ++;

        /* Since right is supposed to be bigger than left, this counts as an inversion */
        /* All of the elements on the left side are bigger than the elements on the right side */
        /* Therefore, we count all the elements that have already been put into the array as an inversion. */
        inversions += leftEnd + 1 - leftStart;
      }
    }

    /* Copy the rest of the elements into the tmpArray */

    /* COpy the left side over */
    while(leftStart <= leftEnd)
    {
      tmp[sorted] = arr[leftStart];
      sorted ++;
      leftStart ++;
    }

    /* Copy the right side over */
    while(rightStart <= end)
    {
      tmp[sorted] = arr[rightStart];
      rightStart ++;
      sorted ++;
    }

    /* Copy the tmp array over to the real array */
    int i;
    for(i = 0; i < size; ++i, --end)
    {
    	arr[end] = tmp[end];
    }

    /* Return number of inversions */
    return inversions;

  }

}
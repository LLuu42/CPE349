public class Inversions {
  public static int numInversions(int [] ranking) {
    //create a temp array of the same size
    int [] temp = new int [ranking.length];
    //call mergesort to get number of inversions
    return mergeSort(ranking, temp, 0, ranking.length - 1);
  }
  private static int mergeSort(int [] arr, int [] temp, int left, int right) {
    //if there is more than 1 element in the subarray we want to sort
    if (left < right) {
      //find the splitting point
      int center = (left + right) / 2;
      //sort the left side and count left inversions
      int invLeft = mergeSort(arr, temp, left, center);
      //sort the right side and count right inversions
      int invRight = mergeSort(arr, temp, center + 1, right);
      //count inversions that cross between the middle
      return invLeft + invRight + merge(arr, temp, left, center + 1, right);
    }
    //otherwise there are 0 inversions
    return 0;
  }
  private static int merge(int [] arr, int [] temp, int left, int right,
                           int end) {
    //find the ending point of the left subarray
    int leftEnd = right - 1;
    //find the starting point of the temp array
    int pos = left;
    //get the size of the sorted array
    int size = end - left + 1;
    //keep track of inversion count
    int invCount = 0;
    //comparing left and right side
    while (left <= leftEnd && right <= end) {
      if (arr[left] < arr[right]) {
        temp[pos++] = arr[left++];
      } else {
        temp[pos++] = arr[right++];
        //since the right side is supposed to be bigger than the left side
        //if we get into this conditional, then however many elements are 
        //on the left side, are bigger than the next element on the right side
        //we start from the middle point and subtract however many we already
        //put into the temp array
        invCount += leftEnd + 1 - left;
      }
    }
    //copy the rest of the elements
    while (left <= leftEnd) {
      temp[pos++] = arr[left++];
    }
    while (right <= end) {
      temp[pos++] = arr[right++];
    }
    //copy the temp array over, starting from the end
    for (int j = 0; j < size; j++, end--) {
      arr[end] = temp[end];
    }
    //return the number of inversions
    return invCount;
  }
}




  private int merge (int[] arr, int[] tmp, int leftStart, int rightStart, int end)
  {
    /* End point of the left array */
    int leftEnd = rightStart - 1;

    /* Starting point of sorted array */
    int sorted = leftStart;

    /* size of the sorted array */
    int size = end - leftStart + 1;

    int inversions = 0;

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

    /* Return number of inversions */
    return inversions;

  }


import java.util.*;
import java.io.*;
public class Driver {
  public static void main(String [] argv) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Name of file: ");
    String fileName = scan.next();
    File f;
    try {
      f = new File(fileName);
      Scanner fileScanner = new Scanner(f);
      String [] nums = fileScanner.nextLine().split(" ");
      int [] ranking = new int [nums.length];
      for (int i = 0; i < ranking.length; i++) {
        ranking[i] = Integer.parseInt(nums[i]);
      }
      System.out.println("There are " + Inversions.numInversions(ranking) +
                        " inversions");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

2 3 8 6 1


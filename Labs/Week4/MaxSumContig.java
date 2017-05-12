// import java.lang.System;
// import java.util.Arrays;
// import java.util.Collections;
// import java.io.PrintWriter;
// import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Random;
import java.lang.Math;
import java.util.Scanner;

/**
   Simple program for max contig subseq sum for comparing the efficiency of different algorithms
   */

   public class MaxSumContig  {     

      public static void main(String[] args) throws FileNotFoundException {   
         Scanner in = new Scanner(System.in);
         Random generator = new Random();
         //int size = 1000;

         System.out.println("Please enter an array size:");
         while(in.hasNext())
         {

            int size = in.nextInt();
            int[] b = new int[size];
            for (int i = 0; i < size; i++){
              b[i] = generator.nextInt(20) - 10;
            };


   	     // Prints out array for debugging  
   	      // System.out.println(Arrays.toString(b));
           System.out.println("size of array  " + size);

            //Brute force n cubed 

           int thisSum = 0;
           long startTime = System.nanoTime();
           int maxSoFar = 0;
           for (int low = 0; low < size; low++){ 
            for (int high = 0; high < size; high++){ 
               thisSum = 0;
               for (int k = low; k<= high; k++)
                  thisSum = thisSum + b[ k ];
                  if( thisSum > maxSoFar )
                     maxSoFar = thisSum;
               }
            }
         long endTime = System.nanoTime();
         System.out.println("Brute force n-cubed solution  = " + maxSoFar);  
         long duration = endTime-startTime;
         System.out.println("duration for brute force n- cubed  = " + duration);   

            //Brute force n squared 
         startTime = System.nanoTime();
         maxSoFar = 0;
         for (int low = 0; low < size; low++){ 
            thisSum = 0;
            for (int high = low; high < size; high++){ 
               thisSum = thisSum + b[high];
               if( thisSum > maxSoFar )
                maxSoFar = thisSum;
          }
       }
       endTime = System.nanoTime();
       System.out.println("Brute force n-squared soln solution  = " + maxSoFar);
       duration = endTime-startTime;
       System.out.println("duration for Brute force n-squared  = " + duration); 



            //Divide and Conquer    n*log n   solution 
       startTime = System.nanoTime();
       maxSoFar = divideConqMaxSum(0,size-1, b);
       endTime = System.nanoTime();

       System.out.println("Divide and Conquer n*log n solution  = " + maxSoFar);
       duration = endTime-startTime;
       System.out.println("duration for Divide and Conquer n*log n solution  = " + duration);

            // A simple Dynamic Programming algorithm (Scanning solution)
       startTime = System.nanoTime();
       maxSoFar = 0;
       int maxEndingHere = 0;
       for (int i = 0; i < size; i++){ 
          maxEndingHere = Math.max(maxEndingHere + b[i], 0);
          maxSoFar = Math.max(maxEndingHere, maxSoFar);
       }

       endTime = System.nanoTime();
       System.out.println("Dynamic Prog solution  = " + maxSoFar);
       duration = endTime-startTime;
       System.out.println("duration for dynamic programming  = " + duration);
                   System.out.println(); 
         System.out.println("Please enter an array size."); 
   }

   }

   public static int divideConqMaxSum(int low,int high, int[] b){
      if (low > high) return 0;
      if (low == high) return Math.max(0,b[low]);
      int mid = (low+high)/2;
      int maxInLeft = divideConqMaxSum(low,mid, b);
      int maxInRight = divideConqMaxSum(mid+1,high, b);
         // now compute the max of any sequence crossing mid - this means it includes at least one entry on each side
         // first the left side 
      int sum = 0; int maxToLeft = 0;
      for (int i = mid; i>= low; i--) {
         sum = sum + b[i];
         maxToLeft = Math.max(maxToLeft, sum);
      }
         // now the right side
      sum = 0; int maxToRight = 0;
      for (int i = mid+1 ; i<= high; i++) {
         sum = sum + b[i];
         maxToRight = Math.max(maxToRight, sum);
      }
      int maxCross = maxToLeft + maxToRight;
      int maxAll = Math.max(maxCross, maxInRight);
      maxAll = Math.max(maxAll, maxInLeft);
      return maxAll ; 
   }// end divideConqMaxSum
}


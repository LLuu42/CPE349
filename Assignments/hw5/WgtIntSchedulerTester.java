import java.util.*;  

public class WgtIntSchedulerTester {


      public static void main(String[] args) {
      WgtIntScheduler wis = new WgtIntScheduler();
      // Test 1
      int[] startTime = {4,  3,  2, 10, 7};      
      int[] finishTime = {7, 10, 6, 13, 9};
      int[] weight =  {6,  6,  5,  2,  8};
      
      int[] answer = new int[20];
      answer = wis.getOptSet(startTime,finishTime,weight);
      System.out.print("Test 1");
      System.out.print(" the answer should be [1,4,5]    " );
      System.out.print("[");
      for (int i = 0; i < answer.length; i++) {
         if (i == answer.length - 1)
            System.out.print(answer[i]);
         else
            System.out.print(answer[i] + ",");
      }
      System.out.println("]");
            // Test 2
      int[] startTime2 = {3,  3,  1, 10, 8};      
      int[] finishTime2 = {7, 10, 4, 13, 11}  ;
      int[] weight2 =  {6,  9,  5,  8, 10}  ;
      
      answer = wis.getOptSet(startTime2,finishTime2,weight2);
      System.out.print("Test 2");
      System.out.print(" the answer should be [2,4]     " );
      System.out.print("[");
      for (int i = 0; i < answer.length; i++) {
         if (i == answer.length - 1)
            System.out.print(answer[i]);
         else
            System.out.print(answer[i] + ",");
      }
      System.out.println("]");

            // Test 3
      int[] startTime3 =  {3,  3,  6, 10, 14, 18}   ;      
      int[] finishTime3 = {25, 5,  8, 13, 16, 20}  ;
      int[] weight3 =     {30, 5,  5,  5,  5,  5}  ;
      
      answer = wis.getOptSet(startTime3,finishTime3,weight3);
      System.out.print("Test 3");
      System.out.print(" the answer should be [1]    " );
      System.out.print("[");
      for (int i = 0; i < answer.length; i++) {
         if (i == answer.length - 1)
            System.out.print(answer[i]);
         else
            System.out.print(answer[i] + ",");
      }
      System.out.println("]");

            // Test 4
      int[] startTime4 =  {3,  6, 10, 14, 18,  3}   ;      
      int[] finishTime4 = {5,  8, 13, 16, 20,  25}  ;
      int[] weight4 =     {5,  5,  5,  5,  5,  30}  ;
      
      answer = wis.getOptSet(startTime4,finishTime4,weight4);
      System.out.print("Test 4");
      System.out.print(" the answer should be [6]:   " );
      System.out.print("[");
      for (int i = 0; i < answer.length; i++) {
         if (i == answer.length - 1)
            System.out.print(answer[i]);
         else
            System.out.print(answer[i] + ",");
      }
      System.out.println("]");

            // Test 5
      int[] startTime5 =  {3,  6, 10, 14, 18,  3}   ;      
      int[] finishTime5 = {5,  8, 13, 16, 20,  25}  ;
      int[] weight5 =     {6,  6,  6,  6,  7,  30}  ;
      
      answer = wis.getOptSet(startTime5,finishTime5,weight5);
      System.out.print("Test 5");
      System.out.print(" the answer should be [1 2 3 4 5]    " );
      System.out.print("[");
      for (int i = 0; i < answer.length; i++) {
         if (i == answer.length - 1)
            System.out.print(answer[i]);
         else
            System.out.print(answer[i] + ",");
      }
      System.out.println("]");

            // Test 6
      int[] startTime6 =  {3,  6, 10, 14, 18,  4}   ;      
      int[] finishTime6 = {5,  8, 13, 16, 20,  19}  ;
      int[] weight6 =     {6,  6,  6,  6,  7,  30}  ;
      
      answer = wis.getOptSet(startTime6,finishTime6,weight6);
      System.out.print("Test 6");
      System.out.print(" the answer should be [1 2 3 4 5]    " );
      System.out.print("[");
      for (int i = 0; i < answer.length; i++) {
         if (i == answer.length - 1)
            System.out.print(answer[i]);
         else
            System.out.print(answer[i] + ",");
      }
      System.out.println("]");
            // Test 7
      int[] startTime7 =  {3,  6, 10, 14, 18,  4}   ;      
      int[] finishTime7 = {5,  8, 13, 16, 20,  19}  ;
      int[] weight7 =     {6,  6,  6,  6,  7,  32}  ;
      
      answer = wis.getOptSet(startTime7,finishTime7,weight7);
      System.out.print("Test 7");
      System.out.print(" the answer should be [6]   " );
      System.out.print("[");
      for (int i = 0; i < answer.length; i++) {
         if (i == answer.length - 1)
            System.out.print(answer[i]);
         else
            System.out.print(answer[i] + ",");
      }
      System.out.println("]");



   }
}
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.lang.Integer;

class DestructiveTesting 
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int height, safest;
      ArrayList<Integer> res = new ArrayList<Integer>(9);

      System.out.println("Please enter the height of the ladder.");
      height = Integer.parseInt(in.nextLine());

      System.out.println("Please enter the highest safe rung.");
      safest = Integer.parseInt(in.nextLine());

      res = findHighestSafeRung(height, safest);
      printList(res);

   }

   private static void printList(ArrayList<Integer> list)
   {
      int i;
      for(i = 0; i < 9; ++i)
      {
         System.out.printf("%d: %d\n", i, list.get(i));
      }
   }

   private static ArrayList<Integer> findHighestSafeRung(int height, int safest)
   {
      ArrayList<Integer> res = new ArrayList<Integer>(9);
      res.add(0, height); //adding height of ladder to 0 index
      res.add(1, safest); //adding safest rung to zero index

      for(int j = 2; j < 9; ++j)
      {
         res.add(-1);
      }

      int i, divide, totalDrops;

      divide = (int) Math.round(Math.sqrt(height)); // Finds divide for the ladder

      i = divide;
      totalDrops = 1;

      while(i <= height)
      {
         if(totalDrops < 4) //appending to first 3 drops
         {
            res.set(totalDrops + 3, i);
         }
         if(i > safest) // rung broke
         {
            res.set(7, i);
            i = i - divide + 1;
            ++ totalDrops;
            break;
         }
         else
         {
            i += divide;
            totalDrops ++;
         }
      }

      if(i > height)
      {
         i = i - divide + 1;
      }

      while(i <= height)
      {
         if(totalDrops < 4) //appending to first 3 drops
         {
            res.set(totalDrops + 3, i);
         }
         if(i > safest) // rung broke
         {
            if(res.get(7) >= 0)
            {
               res.set(8, i);
            }
            else
            {
               res.set(7, i);
            }
            
            res.set(2, i - 1);
            break;
         }
         else
         {
            i ++;
            totalDrops ++;
         }
      } 

      System.out.printf("Total number of drops: %d\n", totalDrops);
      res.set(3, totalDrops);

      
      return res;
   }

}

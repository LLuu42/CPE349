import java.util.Scanner;
import java.lang.Integer;
import java.util.ArrayList;

public class CODriver extends CombObjects {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.println("Please enter a String: ");
      String n = in.next();
      System.out.println("Comb Objects:");
      CombObjects myObjects = new CombObjects();
      printList(myObjects.getMinChgPerm(n));
   }

   private static void printList(ArrayList<String> list)
   {
      int i;
      for(i = 0; i < list.size(); ++i)
      {
         System.out.printf("%d: %s \n", i, list.get(i));
      }
      System.out.println();
   }

}


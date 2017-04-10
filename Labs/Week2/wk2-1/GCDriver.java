import java.util.Scanner;
import java.lang.Integer;
import java.util.ArrayList; 

public class GCDriver extends GrayCode {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.println("Please enter a number:");
      int n = Integer.parseInt(in.next());
      System.out.println("Gray Codes:");
      GrayCode myCodes = new GrayCode();
      printList(myCodes.getGrayCode(n));
   }

   private static void printList(ArrayList<String> list)
   {
      int i;
      for(i = 0; i < list.size(); ++i)
      {
         System.out.printf("%s ", list.get(i));
      }
      System.out.println();
   }

}

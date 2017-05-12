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
      Inversions inv = new Inversions();
      System.out.println("There are " + Inversions.invCounter(ranking) +
                        " inversions");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
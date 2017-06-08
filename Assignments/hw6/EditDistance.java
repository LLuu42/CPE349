import java.util.*;
import java.lang.*;
import java.io.*;

public class EditDistance {
  public static void minEditDistance(String s1, String s2, int print) {
    //make the table, dimensions are one larger than the lengths of the strings
    //because we need a row and column of base cases
    int [] [] table = new int [s1.length() + 1][s2.length() + 1];

    //sets the the first element in each row to be i * 2
    //this is because we are comparing an empty string to string 1, meaning
    //we insert spaces
    for (int i = 0; i <= s1.length(); i++) {
      table[i][0] = i * 2;
    }
    //sets every element in the first row to be j * 2
    //this is because we are comparing an empty string to string 2, meaning
    //we insert spaces
    for (int j = 0; j <= s2.length(); j++) {
      table[0][j] = j * 2;
    }
    //for each character in the first string
    for (int i = 1; i <= s1.length(); i++) {
      //for each character in the second string
      for (int j = 1; j <= s2.length(); j++) {
        //if we insert a gap in the first string
        int insertGapS1 = table[i-1][j] + 2;
        //if we insert a gap in the second string
        int insertGapS2 = table[i][j-1] + 2;
        //checks to see if the characters match
        int match = s1.charAt(i-1) == s2.charAt(j-1) ? 0 : 1;
        //if we don't insert a space
        int substitution = table[i-1][j-1] + match;
        //calculates the minimum of all three possibilities
        table[i][j] = Math.min(insertGapS1,
                      Math.min(substitution, insertGapS2));
      }
    }
    //prints out the values if the user asks for it
    if (print == 1) {
      traceBack(table, s1, s2);
    }
    //returns the minimum edit distance
    int dist = table[s1.length()][s2.length()];
    System.out.println("The minimum edit distance is " + dist);
  }
  
  public static void traceBack(int [][] table, String s1, String s2) {
    //creates the arraylists to hold the values of the traceback
    ArrayList<Character> s1chars = new ArrayList<Character>();
    ArrayList<Character> s2chars = new ArrayList<Character>();
    ArrayList<Integer> values = new ArrayList<Integer>();
    //keeps track of our position in the table
    int row = s1.length();
    int col = s2.length();
    while (row > 0 && col > 0) {
      //value of current position
      int valAtPos = table[row][col];
      //value of one column to the left
      int left = table[row][col - 1];
      //value of one row above
      int up = table[row - 1][col];
      //value of the diagonal
      int diagonal = table[row - 1][col - 1];
      //if the characters are the same, and we didn't insert a space
      if (valAtPos == diagonal &&
         (diagonal + 1 <= left + 2 && diagonal + 1 <= up + 2)) {
        s1chars.add(s1.charAt(--row));
        s2chars.add(s2.charAt(--col));
        values.add(0);
      //if they are not the same, but we didn't insert a space
      } else if (diagonal + 1 <= left + 2 && diagonal + 1 <= up + 2) {
        s1chars.add(s1.charAt(--row));
        s2chars.add(s2.charAt(--col));
        values.add(1);
      //we added a space to the first string
      } else if (left < up) {
        s1chars.add('-');
        s2chars.add(s2.charAt(--col));
        values.add(2);
      //otherwise we added a space to the second string
      } else {
        s1chars.add(s1.charAt(--row));
        s2chars.add('-');
        values.add(2);
      }
    }
    //while there are still values in the row
    while (row > 0) {
      s1chars.add(s1.charAt(--row));
      s2chars.add('-');
      values.add(2);
    }
    //while there are still values in the column
    while (col > 0) {
      s1chars.add('-');
      s2chars.add(s2.charAt(--col));
      values.add(2);
    }
    //prints out the values of all three arraylists; we go backwards because
    //we inserted the latest values first into the arraylist
    for (int i = values.size() - 1; i >= 0; i--) {
      System.out.println(s1chars.get(i) + " "
      + s2chars.get(i) + " " + values.get(i));
    }
  }

  public static void main(String [] argv) {
    try {
      Scanner fileScanner = new Scanner(new File(argv[0]));
      String s1 = fileScanner.nextLine();
      String s2 = fileScanner.nextLine();
      Scanner scan = new Scanner(System.in);
      System.out.print("Print the alignment (y/n): ");
      int printAlign = 0;
      if (scan.next().equals("y")) {
        printAlign = 1;
      }
      minEditDistance(s1, s2, printAlign);
    } catch(Exception e) {
      System.out.println(e);
    }
  }
}

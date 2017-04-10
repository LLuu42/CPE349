import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class SubsetGen
{
   public ArrayList<String> getSubsets(String setString)
   {
      ArrayList<String> A = new ArrayList<String>();
      ArrayList<String> tmp = new ArrayList<String>();
  
      if(setString.length() == 0) //base case
      {
         A.add("");
      }
      else
      {
         tmp = getSubsets(setString.substring(0, setString.length()-1));
         for(int i = 0; i < tmp.size(); ++i)
         {
            A.add(tmp.get(i));
         }
         for(int i = 0; i < tmp.size(); ++i)
         {
            A.add(tmp.get(i) + setString.charAt(setString.length() - 1));
         }
      }
      return A;
   }
}

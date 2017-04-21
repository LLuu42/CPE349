import java.lang.String;
import java.util.ArrayList;

class CombObjects
{

   public ArrayList<String> getLexPerm(String str)
   {
      ArrayList<String> myList = new ArrayList<String>();
      if(str.length() == 0)
      {
         myList.add(str);
         return myList;
      }
      int i;
      for(i = 0; i < str.length(); ++i)
      {
         String mutString = str.substring(0, i) + str.substring(i + 1);
         ArrayList<String> permList = getLexPerm(mutString);
         for(String s : permList)
         {
            myList.add(str.charAt(i) + s);
         }
      }
      return myList;
      
   }

   public ArrayList<String> getMinChgPerm(String str)
   {
      ArrayList<String> myList = new ArrayList<String>();
      if(str.length() == 0)
      {
         myList.add(str);
         return myList;
      }
      
      String shortened = "" + str.charAt(str.length() - 1);
      String perm = str.substring(0, str.length() - 1);
      ArrayList<String> perms = getMinChgPerm(perm);
   
      boolean rightToLeft = true;

      for(String s : perms)
      {
         if(rightToLeft)
         {
            int i;
            for(i = s.length(); i >= 0; --i)
            {
               String left = s.substring(0, i);
               String right = s.substring(i, s.length());
               myList.add(left + shortened + right);
            } 
         
            rightToLeft = false;
         }
         else
         {
            int i;
            for(i = 0; i <= s.length(); ++i)
            {
               String left = s.substring(0, i);
               String right = s.substring(i, s.length());
               myList.add(left + shortened + right);
            }
            rightToLeft = true;
         }
      }
      return myList;
   }
}

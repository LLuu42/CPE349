import java.util.ArrayList;
import java.lang.String;
import java.lang.Integer;

class GrayCode { 

   /**
   * getGrayCode
   *
   * Recursively generates an array list of all the graycodes
   * @param the number of items present for the graycode subset
   * @return an ArrayList<String> containing the graycodes.
   */
   public ArrayList<String> getGrayCode(int n) {
     if(n == 1) { 	//base case: when GrayCodes is empty   
         ArrayList<String> grayCodes = new ArrayList<String>();
         grayCodes.add("0");
         grayCodes.add("1");
         return grayCodes;
      }
      else {
         ArrayList<String> grayCodes = getGrayCode(n-1);
         ArrayList<String> appendedGrayCodes = new ArrayList<String>();
         int i;
         for(i = 0; i < grayCodes.size(); ++i) {	//iterates through graycodes
            appendedGrayCodes.add(0, "1" + grayCodes.get(i));
         }
         int j;
         for(j = grayCodes.size() - 1; j >=0; --j) {	//reverse iterates through graycodes
            appendedGrayCodes.add(0, "0" + grayCodes.get(j));            
         } 
 
         return appendedGrayCodes;
      }
   }
}

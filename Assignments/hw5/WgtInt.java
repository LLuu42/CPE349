public class WgtInt {
   public static void main(String [] argv) {
      int [] stime = {3, 6, 10, 14, 18, 4};
      int [] ftime = {5, 8, 13, 16, 20, 19};
      int [] weight = {6, 6, 6, 6, 7, 30};
      int [] result = WgtIntScheduler.getOptSet(stime, ftime, weight);
      for (int n : result) {
         System.out.println(n);
      }
   }
}

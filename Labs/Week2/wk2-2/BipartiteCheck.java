import java.util.*;
import java.io.*;

public class BipartiteCheck
{
   private int red = 0;
   private int black = 1;
   private int[] graph;
 
   private boolean colorTree(ArrayList<Integer>[] edges, int vertex)
   {
      LinkedList<Integer> queue = new LinkedList<Integer>();
      int current = -1;
      int neighbor = -1;

      graph[vertex] = red;
      queue.add(vertex);
 
      while(queue.size() != 0)
      {
         current = queue.poll();
         int i;
         for(i = 0; i < edges[current].size(); ++i)
         {
            neighbor = edges[current].get();
            if(graph[neighbor] == 69
         }
      }
   }
}

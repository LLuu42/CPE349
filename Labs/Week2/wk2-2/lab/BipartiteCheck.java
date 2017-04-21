import java.util.*;
import java.io.*;

public class BipartiteCheck{
   private final int RED = 0;
   private final int BLACK = 1;
   private int[] graph;
   
   private boolean colorTree(ArrayList<Integer>[] edges, int vertex){
      LinkedList<Integer> queue = new LinkedList<Integer>();
      int current = -1;
      int neighbor = -1;
      
      graph[vertex] = RED;
      queue.add(vertex);

      while(queue.size() != 0){
         current = queue.poll();

         for (int i = 0; i < edges[current].size(); i++){
            neighbor = edges[current].get(i);

            if (graph[neighbor] == -1){         // if not yet colored
               if (graph[current] == RED)       // if current is red, color neighbor black
                  graph[neighbor] = BLACK;
               else                             // if current is black, color neighbor red
                  graph[neighbor] = RED;

               queue.add(neighbor);             // add neighbor to queue to color adjects after
            }

            else if (graph[neighbor] == graph[current])  // if two adj are same color
               return false;                             // then not Bipartite
         }
      }
   
      return true;
   }

   public boolean isBipartite(ArrayList<Integer>[] edges, int nvertices){
      graph = new int[nvertices + 1];

      for (int i = 1; i < graph.length; i++)    // init graph for coloring
         graph[i] = -1;                         // -1 => no color

      for (int i = 1; i <= nvertices; i++){
         if (graph[i] == -1){
            if (colorTree(edges, i) == false)   // colorTree will color tree
               return false;                    // up to a point and can tell if
         }                                      // a network is bipartite
      } 

      return true;
   }

}

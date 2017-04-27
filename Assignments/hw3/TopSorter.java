import java.util.*;

public class TopSorter
{
   public static ArrayList<Integer> topSortGenerator(String filename)
   {
      GraphStart graph = new GraphStart();
      ArrayList<Integer> order = new ArrayList<Integer>();
      try
      { 
         graph.readfile_graph(filename);
      }
      catch(Exception e)
      {
         System.out.println(e);
      }

      int[] indegrees = indegrees(graph.nvertices, graph.edges);
      LinkedList<Integer> queue = new LinkedList<Integer>();
      for(int i = 1; i < indegrees.length; i++)
      {
         if(indegrees[i] == 0)
         {
            queue.add(i);
         }
      }

      if(queue.size() != 0)
      {
         while(queue.size() > 0)
         {
            int source = queue.poll();
            order.add(source);
            for(int i = 0; i < graph.edges[source].size(); i++)
            {
               int target = graph.edges[source].get(i);
               indegrees[target]--;
             
               if(indegrees[target] == 0)
               {
                  queue.add(target);
               }
            }
         }
         for(int i = 1; i < indegrees.length; ++i)
         {
            if(indegrees[i] != 0)
            {
               order.add(-1);
            }
         }
      }
      else
      {
         for(int i = 0; i < graph.nvertices; i++)
         {
            order.add(-1);
         }
      }
      return order;       
   }

   private static int[] indegrees(int nvertices, ArrayList<Integer>[] graph)
   {
      int[] indegree_count = new int[nvertices + 1];
      for(int i = 1; i <= nvertices; i++)
      {
         for(int j = 0; j < graph[i].size(); j++)
         {
            indegree_count[graph[i].get(j)]++;
         }
      }
      return indegree_count;
   }
}

import java.util.*;

public class ConnectCheck
{
   private boolean[] visited;

   public ArrayList<String> getComponents(int nvertices, ArrayList<Integer>[] edges)
   { 
      ArrayList<Integer> connections = new ArrayList<Integer>();
      ArrayList<String> components = new ArrayList<String>();
      visited = new boolean[nvertices + 1];
      String sequence = "";

      int i = 0;
      int j = 1;
  
      for(i = 0; i < visited.length; ++i)
      { 
         visited[i] = false;
      }

      for(j = 0; j < connections.size(); ++j)
      { 
         int k;
         if(visited[i] == false)
         {
            connections = getSequence(edges, i);
            sequence = "{ ";

            for(k = 0; k < connections.size(); ++k)
            {
               sequence += connections.get(k) + " ";
            }
 
            sequence += "}";
            components.add(sequence);
         }
      }
      return components;
   }
   
   public int getCons(int nvertices, ArrayList<Integer>[] edges)
   {
      boolean[] hasVisited = new boolean[nvertices + 1];
      int numConnections = 0;
      int vertexEdge = -1;
      int i;

      for(i = 0; i < hasVisited.length; ++i)
      {
         visited[i] = false;
      }

      for(i = 1; i < hasVisited.length; ++i)
      {
         int j;
         for(j = 0; j < edges[i].size(); ++j)
         {
            vertexEdge = edges[i].get(j);
            if(hasVisited[i] == false && hasVisited[vertexEdge] == false)
            {
               ++numConnections;
            }
            hasVisited[i] = true;
            hasVisited[vertexEdge] = true;
         }
         
         if(edges[i].size() == 0)
         {
            ++numConnections;
         }
      }
      return numConnections;
   }

   private ArrayList<Integer> getSequence(ArrayList<Integer>[] edges, int vertex)
   {
      ArrayList<Integer> connections = new ArrayList<Integer>();
      LinkedList<Integer> queue = new LinkedList<Integer>();
      int head = -1;
      int vertexEdge = -1;

      visited[vertex] = true;  //once true, we have visited all the nodes in the queue
      connections.add(vertex);
      queue.add(vertex);

      while(queue.size() != 0)
      {
         head = queue.poll();
         int i;
         for(i = 0; i < edges[head].size(); ++i)
         {
            vertexEdge = edges[head].get(i);
            if(visited[vertexEdge] == false)
            {
               visited[vertexEdge] = true;
               connections.add(vertexEdge);
               queue.add(vertexEdge);
            }
         }
      }

      return connections;
}
}

import java.util.*;

public class ConnectCheck{
   private boolean[] visited2;         // Will be used between 2 functions

   private ArrayList<Integer> getSequence(ArrayList<Integer>[] edges, int vertex){
      ArrayList<Integer> connections = new ArrayList<Integer>();
      LinkedList<Integer> queue = new LinkedList<Integer>(); //adjacent nodes
      int head = -1;
      int edgeVertex = -1;

      visited2[vertex] = true;         // Shows the vertex has been visited
      connections.add(vertex);         // Add first vertex on list of traversed 
      queue.add(vertex);               // Add first vertex to queue to traverse
                                       // 
      while(queue.size() != 0){        // 
         head = queue.poll();          // taking each of the vertices from the queue to traverse

         for (int i = 0; i < edges[head].size(); i++){
            edgeVertex = edges[head].get(i);

            if (visited2[edgeVertex] == false){ // Check to see vertex has been visited
               visited2[edgeVertex] = true;     // (if not, visit)
               connections.add(edgeVertex);     // add vertex to path
               queue.add(edgeVertex);           // add all adjacent nodes to the queue
            }                                   
         }
      }

      return connections;                       // return complete path
   }
   
   public ArrayList<String> getComponents (int nvertices, ArrayList<Integer>[] edges){
      ArrayList<String> components = new ArrayList<String>();
      ArrayList<Integer> connections = new ArrayList<Integer>();
      visited2 = new boolean[nvertices + 1];
      String sequence = "";

      for (int i = 0; i < visited2.length; i++)  // init visited array
         visited2[i] = false;

      for (int i = 1; i <= nvertices; i++){
         if (visited2[i] == false){                // if we havent visited
            connections = getSequence(edges, i);   // Create sequence of path from node
            sequence = "{ ";                       // New sequence created
                                                  

            for (int j = 0; j < connections.size(); j++) 
               sequence += connections.get(j) + " "; // add connection to sequence

            sequence += "}";                       //end sequence
            components.add(sequence);              // add complete path to components
         }                                         
      }

      return components; //return all components
   }

   public int getCons(int nvertices, ArrayList<Integer>[] edges){
      boolean[] visited = new boolean[nvertices + 1];
      int numConnections = 0;
      int edgeVertex = -1;
      
      for (int i = 0; i < visited.length; i++)   // init visited array
         visited[i] = false;

      /*
         If for any edge, both vertices are unvisited,
         then we have a new connection.
       */
      for (int i = 1; i <= nvertices; i++){
         for (int j = 0; j < edges[i].size(); j++){
            edgeVertex = edges[i].get(j);
            
            if (visited[i] == false && visited[edgeVertex] == false)
               numConnections++;

            visited[i] = true;
            visited[edgeVertex] = true;
         }

         if (edges[i].size() == 0)        // if only 1 vertex is in the path
            numConnections++;            
      }

      return numConnections;
   }
}

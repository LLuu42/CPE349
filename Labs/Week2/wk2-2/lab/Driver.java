import java.util.*;
import java.io.*;

public class Driver{

   public static void main(String[] args){
      GraphStart graph = new GraphStart();
      BipartiteCheck biChecker = new BipartiteCheck();
      ConnectCheck conChecker = new ConnectCheck();
      int numConnections = 0;
      ArrayList<String> components = new ArrayList<String>();

      if (args.length == 0){
         System.out.println("Usage: java driver [filename]");
         return;
      }

      try {
         graph.readfile_graph(args[0]);
      } 
      
      catch (FileNotFoundException e) {
         System.out.println(e);
         return;
      }

      System.out.println("Input Graph has " + graph.nvertices + " vertices, " +
                         graph.nedges + " edges");

      /* Check Bipartitability */
      if (biChecker.isBipartite(graph.edges, graph.nvertices) == true)
         System.out.println("It is BiColorable");
      else
         System.out.println("It is not BiColorable");

      /* Check Number of Connected Components */
      numConnections = conChecker.getCons(graph.nvertices, graph.edges);
      System.out.println("It has "+numConnections+" connected components:");

      /* Print connected Components */
      components = conChecker.getComponents(graph.nvertices, graph.edges);
      for (int i = 0; i < components.size(); i++)
         System.out.println(components.get(i));

   }
}

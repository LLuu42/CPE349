import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class GraphStart
{
   static final int MAXV = 100;
   static final int MAXDEGREE = 50;
   public boolean directed;
   public ArrayList<Integer>[] edges = new ArrayList[MAXV+1];
   public int degree[] = new int [MAXV+1];
   public int nvertices;
   public int nedges;

   GraphStart()   
   {      
      nvertices = nedges = 0;
      for(int i=0;i<=MAXV;i++)  
      {
         degree[i] = 0;
         edges[i] = new ArrayList<Integer>();
      }
   }
		
   void readfile_graph(String filename) throws FileNotFoundException     
   {
      int x,y;
      FileInputStream in = new FileInputStream(new File(filename));
      Scanner sc = new Scanner(in);
      directed =  (  1 == sc.nextInt()  );      // 1 directed, anything else undirected
      nvertices = sc.nextInt();
      int m = sc.nextInt();                     // m is the number of edges in the file
      for(int i=1;i<=m;i++)
      {
         x=sc.nextInt();
         y=sc.nextInt();
         insert_edge(x,y,directed);
      }
      for(int i=1;i<=nvertices;i++)
      {
         Collections.sort(edges[i]);
      }
   }

   void insert_edge(int x, int y, boolean directed)	
   {
      edges[x].add(y);
      degree[x]++;

      if (!directed)  
      {       // adding "mirror" edge since not directed
         edges[y].add(x);
         degree[y]++;
         nedges++;
      }
   }

   void remove_edge(int x, int y)  
   {
      if(degree[x]<0)
      System.out.println("Warning: no edge --" + x + ", " + y);
      edges[x].remove((Integer)y);
      degree[x]--;
   }
   
   void print_graph()	
   {
      if (directed)
      {
          System.out.printf("Directed Graph\n");
      }
      else
      {
         System.out.printf("Undirected Graph\n");
      }
      for(int i=1;i<=nvertices;i++)   
      {
         System.out.printf("%d: ",i);
         for(int j=0;j<=degree[i]-1;j++)
         System.out.printf(" %d",edges[i].get(j));
         System.out.printf("\n");
      }
   }
}

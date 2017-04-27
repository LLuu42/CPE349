import java.lang.*;
import java.util.*;

public class MyMinHeap
{
   private static final int CAPACITY = 50;
   private int[] heap;
   private int size;

   public MyMinHeap()
   {
      heap = new int[CAPACITY + 1];
      size = 0;
   }

   public MyMinHeap(int capacity)
   {
      heap = new int[capacity + 1];
      size = 0;
   }

   public boolean buildHeap(int[] elm)
   {
      if(elm.length > getHeapCap())
      {
         return false;
      }
      size = elm.length;
      for(int i = 0; i < elm.length; ++i)
      {
         heap[i + 1] = elm[i];
      }
      for(int i = size / 2; i >= 2; i--)
      {
         driftDown(i);
      }

      return true;
   }

   public boolean insert(int n)
   {
      if(isFull())
      {
         return false;
      }
      size ++;
      heap[size] = n;
      driftup(size);
      return true;
   }

   public int findMin()
   {
      if(isEmpty())
      {
         throw new ArrayIndexOutOfBoundsException();
      }
      return heap[1];
   }

   public int deleteMin()
   {
      if(size == 0)
      {
         throw new ArrayIndexOutOfBoundsException();
      }
      int res = findMin();
      size --;
      heap[1] = heap[size];
      driftDown(1);
      return res;
   }

   public void driftup(int index)
   {
      int tmp = heap[index];
      int tmpLocation = index;
      int parent = heap[index/2];
      int parentLocation = index/2;


      while (tmpLocation > 1 && tmp < parent)
      {   
         heap[tmpLocation] = parent;              

         tmpLocation = parentLocation;
         parentLocation = parentLocation/2;
         parent = heap[parentLocation];          
      }

      heap[tmpLocation] = tmp;
   }

   public void driftDown(int index)
   {
      int temp = heap[index];
      int tempLocation = index;
      int nextLocation = 0;
      int lLoc = index*2;      
      int rLoc = index*2 + 1;   
      int smallerChild = 69;

      while (lLoc <= size)
      {    

         if (rLoc <= size && heap[lLoc] > heap[rLoc]){
            smallerChild = heap[rLoc];
            nextLocation = rLoc;
         }
         else{ 
            smallerChild = heap[lLoc];
            nextLocation = lLoc;
         }
         
         if (smallerChild < temp){
            heap[tempLocation] = smallerChild;
            tempLocation = nextLocation;
         }
         else 
            break;

         /* Increment Other Indexes */
         lLoc = tempLocation*2;
         rLoc = tempLocation*2+1;
      }

      heap[tempLocation] = temp;
   }
	

   public boolean isEmpty()
   {
      return size == 0;
   }

   public boolean isFull()
   {
      return size == heap.length - 1;
   }

   public int getHeapCap()
   {
      return heap.length - 1;
   }

   public int getHeapSize()
   {
      return size;
   }
}

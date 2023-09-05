package Algorithms;
import java.util.*;
public class Heapsorts 
{
    public static void heapify(int a[], int n, int i) // Places the highest element at the top followed by descending order of elements
    {
        int L = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && a[l] > a[L]) 
            L = l;
        if (r < n && a[r] > a[L]) 
            L = r;
        if (L != i) 
        {
            int temp;
            temp = a[i];
            a[i] = a[L];
            a[L] =temp;
            heapify(a, n, L);
        }
    }
    public static void heapSort(int a[]) 
    {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);
        for (int i = n - 1; i > 0; i--) // To reverse the order of the elements i.e. to place lowest element at the top followed by ascending order
        {
            int temp ;
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }
    public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the number of elements: ");
      int n = sc.nextInt();
      int a[] = new int[n];
      System.out.println("Enter the elements:");
      for (int i = 0; i < n; i++)
    	  a[i] = sc.nextInt();
      heapSort(a);
      System.out.println(""); 
      for (int i = 0; i < n; i++) 
    	  System.out.println(a[i]+" ");
      
    }
 }
    	  

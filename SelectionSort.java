package sortingAlgorithms;

import java.util.Random;
import java.util.Scanner;

public class SelectionSort {

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    long start,end;
    int a[]=new int[10000];
    System.out.println("Enter number of terms:");
    int n=sc.nextInt();
    System.out.println("1.user input 2.random generation");
    int choice=sc.nextInt();
    switch(choice)
    {
    case 1:
      for(int i=0;i<n;i++)
      {
        a[i]=sc.nextInt();
      }
      break;
    case 2:
      Random rand=new Random();
      for(int i=0;i<n;i++)
      {
        a[i]=rand.nextInt(10000);
      }
    }
    start=System.nanoTime();
    selection_sort(a,n);
    end=System.nanoTime();
    System.out.println("After sorting:");
    for(int i=0;i<n;i++)
    {
      System.out.println(a[i]);
    }
    System.out.println("Time taken for sorting= "+(end-start)+"ns");
    sc.close();
  }
  
  public static void selection_sort(int a[],int n)
  {
    int i, j, temp,small;
    for (i = 0; i < n - 1; i++)
    {
      small = i;
      for (j = i + 1; j < n; j++)
      {
        if (a[j] < a[small])
          small = j;

        temp = a[small];
        a[small] = a[i];
        a[i] = temp;
      }
    }
  }
}
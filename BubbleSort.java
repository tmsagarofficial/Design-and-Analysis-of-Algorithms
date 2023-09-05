package sortingAlgorithms;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

  public static void main(String[] args)  {
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
    bubble_sort(a,n);
    end=System.nanoTime();
    System.out.println("After sorting:");
    for(int i=0;i<n;i++)
    {
      System.out.println(a[i]);
    }
    System.out.println("Time taken for sorting= "+(end-start)+"ns");
    sc.close();
  }
  public static void bubble_sort(int a[],int n)
  {
    int temp;
    for(int i=0;i<n;i++)
    {
      for(int j=1;j<n-i;j++)
      {
        if(a[j]<a[j-1])
        {
          temp=a[j-1];
          a[j-1]=a[j];
          a[j]=temp;
        }
      }
    }
  }
}
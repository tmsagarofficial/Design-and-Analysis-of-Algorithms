package sortingAlgorithms;
import java.util.Scanner;
import java.util.Random;

public class InsertionSort {

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
    insertion_sort(a,n);
    end=System.nanoTime();
    System.out.println("After sorting:");
    for(int i=0;i<n;i++)
    {
      System.out.println(a[i]);
    }
    System.out.println("Time taken for sorting= "+(end-start)+"ns");
    sc.close();
  }

  public static void insertion_sort(int a[],int n)
  {
    int i, j, temp;
    for ( i = 1; i < n; i++)
    {
     j=i;
     while(j>0&&a[j]<a[j-1]) {
    	 temp=a[j-1];
    	 a[j-1]=a[j];
    	 a[j]=temp;
    	 j=j-1;
     }
    }
  }
}
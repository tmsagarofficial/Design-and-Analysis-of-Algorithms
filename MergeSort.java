//done


package sortingAlgorithms;
import java.util.Scanner;

import java.util.Random;

public class MergeSort {
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
      break;
    }
    
    
    start=System.nanoTime();
    merge_sort(a,0,n-1);
    end=System.nanoTime();
    
    
    
    System.out.println("After sorting:");
    for(int i=0;i<n;i++)
    {
      System.out.println(a[i]);
    }
    
    
    
    System.out.println("Time taken for sorting= "+(end-start)+"ns");
    sc.close();
  }
  
  public static void merge_sort(int a[],int low,int high)
  {
    int mid;
    if(low<high)
    {
      mid=(low+high)/2;
      merge_sort(a,low,mid);
      merge_sort(a,mid+1,high);
      merge(a,low,mid,high);
    }
  }
  
  public static void merge(int a[],int low,int mid,int high)
  {
    int c[]=new int[10000];
    int i,j,k;
    i=low;j=mid+1;k=low;
    while((i<=mid)&&(j<=high))
    {
      if(a[i]<a[j])
      {
        c[k]=a[i];
        k++;
        i++;
      }
      else
      {
        c[k]=a[j];
        k++;
        j++;
      }
    }
    while(i<=mid)
    {
      c[k]=a[i];
      k++;
      i++;
    }
    while(j<=high)
    {
      c[k]=a[j];
      k++;
      j++;
    }
    for(i=low;i<k;i++)
    {
      a[i]=c[i];
    }
  }
}
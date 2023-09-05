//done

package sortingAlgorithms;
import java.util.Scanner;

import java.util.Random;

public class QuickSort {
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
    QuickSort Q=new QuickSort();
    
    
    start=System.nanoTime();
     Q.quick_sort(a,0,n-1);
    end=System.nanoTime();
    
    
    
    System.out.println("After sorting:");
    for(int i=0;i<n;i++)
    {
      System.out.println(a[i]);
    }
    System.out.println("Time taken for sorting= "+(end-start)+"ns");
    sc.close();
  }
  
  public static void quick_sort(int a[],int low,int high)
  {
    int j;
    if(low<high)
    {
      j=partition(a,low,high);
      quick_sort(a,low,j-1);
      quick_sort(a,j+1,high);
    }
  }
  
  public static int partition(int a[],int low,int high)
  {
    int i,j,pivot,temp;
    //i=low+1;j=high;
    i=low;j=high;
    pivot=a[high];
   
    while(true) {
    	while(a[i]<=pivot&& i<high){
        	i++;
        }
        while(a[j]>pivot) {
        	j--;
        }
        if(i<j) {
        	temp=a[i];
        	a[i]=a[j];
        	a[j]=temp;
        	
        }
        else {
        	temp=pivot;
        	pivot=a[j];
        	a[j]=temp;
        	break ;
        }

    }
    return j;
  
  }
  

}
package JobSequencing;

import java.util.*;
public class JobSequencing{
	static void  display(int[] a,int n) {
		for(int i=0;i<n;i++)
	    {
	      System.out.print(a[i]+" ");
	    }
		System.out.println();
	}
	static void swap(int[] a,int i,int j) {
		int temp;
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the number of Jobs");
    int n=sc.nextInt();
    int a[]=new int[n];//Jobs
    int b[]=new int[n];//profit
    int c[]=new int[n];//deadline
    for(int i=0;i<n;i++)
    {
      System.out.println("Enter the Jobs");
      a[i]=sc.nextInt();
      System.out.println("Enter the Profit");
      b[i]=sc.nextInt();
      System.out.println("Enter the DeadLine");
      c[i]=sc.nextInt();
    }
    System.out.println("--Arranged Order--");
    System.out.print("Jobs:    ");
    display(a,n);
    System.out.print("Profit:  ");
    display(b,n);
    System.out.print("DeadLine:");
    display(c,n);
    
    
    for(int i=0;i<n-1;i++)
    {
      for(int j=i+1;j<n;j++)
      {
          if(b[i]<b[j])
          {
              swap(b,i,j);
              swap(c,i,j);
              swap(a,i,j);
          }
      }
    }
    
    
    System.out.println();
    System.out.println("--Sorted Order--");
    System.out.print("Jobs:    ");
    display(a,n);
    System.out.print("Profit:  ");
    display(b,n);
    System.out.print("DeadLine:");
    display(c,n);
    
    
    int max=c[0];
    for(int i=0;i<n;i++)
    {
      if(c[i]>max)
      {
        max=c[i];
      }
    }
    String x[]=new String[max];
    int xx[]=new int[max];
    int profit=0;
    for(int i=0;i<n;i++)
    {
      int pp=c[i];
      pp=pp-1;
      if(x[pp]==null )
      {
    	x[pp]=("J"+a[i]);
        profit+=b[i];
      }
      else
      {
        while(pp!=-1)
        {
          if(x[pp]==null)
          {
            x[pp]=("J"+a[i]);
            profit+=b[i];
            break;
          }
            pp=pp-1;
        }
      }
    }
    for(int i=0;i<max;i++)
    {
        System.out.print("-->J"+x[i]);
    }
    System.out.println();
    System.out.print("Profit Earned: "+profit);
 }
}
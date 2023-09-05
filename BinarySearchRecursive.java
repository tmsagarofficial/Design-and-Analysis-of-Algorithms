
package searchingAlgorithms;

import java.util.Scanner;


public class BinarySearchRecursive {

	public static void main(String[] args) {
		int a[]=new int[100];
		long start,end;
		Scanner sc =new Scanner(System.in);
		System.out.println("88Enter the number of terms in the array:");
		int n= sc.nextInt();
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		System.out.println("Enter the key element to search:");
		int key=sc.nextInt();
		
		start=System.nanoTime();
	    int pos=binary_search(a,key,0,n-1);
	    end=System.nanoTime();
	    if(pos>0) {
	    	System.out.println("Pos:="+pos);
	        System.out.println("Time taken for searching= "+(end-start)+"ns");
	    }
	    else {
	    	System.out.println("Not found");
	    	System.out.println("Time taken for searching= "+(end-start)+"ns");
	    }
	    sc.close();
		
	}
	public static int  binary_search(int a[],int key,int low,int high) {

		int mid;
		while(low<=high) {
			mid=(low+high)/2;
			if(a[mid]==key){
				return mid;
			}			
			else if(a[mid]>key) {
				return binary_search(a,key,low,mid-1);
			}
			else 
				return binary_search(a,key,mid+1,high);
		}
		return -1;
		
	}

}
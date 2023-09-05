
package searchingAlgorithms;

import java.util.Scanner;


public class BinarySearchIterative {

	public static void main(String[] args) {
		int a[]=new int[100];
		long start,end;
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the number of terms in the array:");		
		int n= sc.nextInt();
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		System.out.println("Enter the key element to search:");
		int key=sc.nextInt();
		
		start=System.nanoTime();
	    int pos=binary_search(a,key,n);
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
	public static int  binary_search(int a[],int key,int n) {
		int beg=0,end=n-1;
		int mid;
		while(beg<=end) {
			mid=(beg+end)/2;
			if(a[mid]==key){
				return mid;
			}			
			else if(a[mid]>key) {
				end =mid-1;
			}
			else 
				beg=mid+1;
		}
		return -1;
		
	}

}

  

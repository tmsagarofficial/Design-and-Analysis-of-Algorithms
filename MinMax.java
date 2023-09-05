//MIN-MAX

package Algorithm;

import java.util.Scanner;

public class MinMax {
	
	static class Pair {

		int min;
		int max;
	}

	static Pair getMinMax(int arr[], int n) {
		Pair minmax = new Pair();
		int i;

		if (n == 1) {
			minmax.max = arr[0];
			minmax.min = arr[0];
			return minmax;
		}

		if (arr[0] > arr[1]) {
			minmax.max = arr[0];
			minmax.min = arr[1];
		} else {
			minmax.max = arr[1];
			minmax.min = arr[0];
		}

		for (i = 2; i < n; i++) {
			if (arr[i] > minmax.max) {
				minmax.max = arr[i];
			} else if (arr[i] < minmax.min) {
				minmax.min = arr[i];
			}
		}

		return minmax;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long start,end;
		int a[]=new int[20];
		System.out.println("Enter number of terms:");
		int n=sc.nextInt();
		System.out.println("Enter the terms:");
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		start=System.nanoTime();
		Pair minmax=getMinMax(a,n);
		end=System.nanoTime();
		System.out.printf("\nMinimum element is %d", minmax.min);
		System.out.printf("\nMaximum element is %d", minmax.max);
		System.out.println("\nTime taken="+(end-start)+"ns");
		sc.close();
	}
}
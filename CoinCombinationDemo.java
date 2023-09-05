package CoinCombination;
import java.util.Scanner;

public class CoinCombinationDemo{
	public static int n;
	public static int[] d=new int[100];
	public static int amt;
	public static int[] coin=new int[100];
	public static int[][]finalans=new int[100][100];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no of denomination:");
		n=sc.nextInt();
		System.out.println("enter the denomination:");
		for(int i=0;i<n;i++)
		{
			d[i]=sc.nextInt();
		}
		System.out.println("enter the amt:");
		amt=sc.nextInt();
		
		int temp;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(d[j]<d[j+1])
				{
					temp=d[j];
					d[j]=d[j+1];
					d[j+1]=temp;
				}
			}
		}
		coinchange();
		System.out.println("fesible solutions are:");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(finalans[i][j]+" ");
			}
			System.out.println(" ");
		}
		System.out.println("final solution:");
		int low=0;
		for(int i=0;i<n;i++)
		{
			if(finalans[i][n+1]<low)
			{
				low=i;
			}
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(finalans[low][i]+" ");
		}
	}
	public static void coinchange()
	{
		int k,damt,nocoin=0;
		for(int i=0;i<n;i++){
			k=0;
			damt=amt;
			for(int j=i;j<n;j++){
				coin[k]=damt/d[j];
				finalans[i][j]=coin[k];
				damt=damt%d[j];
				nocoin=nocoin+coin[k];
				k++;
			}
			finalans[i][n+1]=nocoin;
		}
	}
}
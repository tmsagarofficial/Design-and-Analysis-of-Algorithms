package Algorithms;
import java.util.*;
public class dijkstras {
	public static int n,s;
	public static int cost[][]= new int[10][10];
	public static int visited[]=new int[10];
	public static int dist[]=new int[10];
public static void main(String[] args) {
	Scanner stdin= new Scanner(System.in);
	
	System.out.println("Input the number of vertices");
	 n= stdin.nextInt();
	System.out.println("Input the weighted matrix");
	for(int i=1;i<=n;i++)
		for(int j=1;j<=n;j++)
			cost[i][j]=stdin.nextInt();
	System.out.println("Input the source vertex");
	s=stdin.nextInt();
	dij();
	stdin.close();
}
public static void dij() {
	int count=1,min,w,v=0;
	for(int i=1;i<=n;i++)
	{
		visited[i]=0;
		dist[i]=cost[s][i];
		visited[s]=1;
		
	}
	while(count<=n)
	{
		min=999;
		for(w=1;w<=n;w++)
			if((dist[w]<min)&&(visited[w]==0))
			{
				visited[v]=1;
				count++;
				min=dist[w];
				v=w;
			}
		for(w=1;w<=n;w++)
			if((dist[w])>(dist[v]+cost[v][w]))
				dist[w]=dist[v]+cost[v][w];
	}
	for( w=1;w<=n;w++)
		if(s==w)
			continue;
		else
			System.out.println(s+"->"+w+":"+dist[w]);
	}

}
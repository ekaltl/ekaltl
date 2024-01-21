package backjoon;

// DFS 연결 요소의 개수 
import java.util.Scanner;

public class back_11724 {
	static int[][]arr;
	static boolean[] visit;
	static int u,v,cnt;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N= scan.nextInt();
		int M= scan.nextInt();
		arr = new int [N+1][N+1];
		for(int i=0; i<M; i++) {
			u=scan.nextInt();
			v=scan.nextInt();
			
			arr[u][v] = 1;
			arr[v][u]=1;
		}
		visit = new boolean[ N+1];
		cnt=0;
		for(int i=1; i<N; i++) {
			if(visit[i]==false) {
		dfs(i);
		cnt++;

			}
		}
		System.out.println(cnt);

	}
	static void dfs(int start) {
		visit[start]=true;

		for(int i=1; i<arr.length; i++) {
			if(arr[start][i]==1 && visit[i]==false) {
				dfs(i);
			}
		}
		


		
	}

}

package backjoon;

import java.util.Scanner;

public class Main {	
	
	static int arr[][];
	static Boolean visit[][];
	static int M,N,K;
	static int cnt;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for(int y=0; y<T; y++) {
		M = scan.nextInt();
		N = scan.nextInt();
		K = scan.nextInt();
		
		arr = new int[M][N];
		visit = new Boolean[M][N];
		
		for(int i=0; i<K; i++) {
			int S= scan.nextInt();
			int E= scan.nextInt();
			
			arr[S][E]=1;
		}
		
		for(int j=0; j<M; j++) {
			for(int k=0; k<N; k++) {
				if(arr[j][k]==1 && visit[j][k]==false) {
					dfs(j,k);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		for(int i=0; i<4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX>=0 && nextX<M && nextY>=0 && nextY<N) {
			if(arr[nextX][nextY]==1 && visit[nextX][nextY]==false) {
				dfs(nextX,nextY);
			}
				
			}
		}
		
		
	}
	
	
}

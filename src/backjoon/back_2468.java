package backjoon;

import java.util.Scanner;

public class back_2468 {
	static int N;
	static int cnt;
	static int[][] arr;
	static boolean [][] visit;
	static int watermax;
	
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		visit=new boolean[N][N];
		arr=new int [N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = scan.nextInt();
				watermax = Math.max(watermax,arr[i][j]);
			}
		}
		for(int j=0; j<N; j++) {
			for(int k=0; k<N; k++) {
				if(arr[j][k]<watermax)
				dfs(0,0,1);
			}
		}

		System.out.println(cnt);
	}
	
	static void dfs(int x, int y, int high) {
		visit[x][y]=true;
		for(int i=0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			
			//그래프 범위안에 들어올때만 0~N 
			if(nextX>=0 && nextX<N && nextY>=0 && nextY<N) {
				
				if(arr[nextX][nextY]<high &&visit[nextX][nextY]==false ) {
					cnt++;
					dfs(nextX,nextY,high);
					
				}
				
			}
		}
		
	}
	

}

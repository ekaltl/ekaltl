package backjoon;

//유기농배추 DFS, 4방향, 2차원 그래프, 그룹의 수 구하기
import java.util.Scanner;

public class back_1012 {
	
	static int T,M,N,K,cnt;
	static int[][] arr;
	static boolean [][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		T=scan.nextInt();

		for(int y=0; y<T; y++) {
			M=scan.nextInt();
			N=scan.nextInt();
			K=scan.nextInt();
			
			cnt=0;		
			arr=new int [M+10][N+10];
			visit= new boolean [M+10][N+10];
			
			
		for(int i=0; i<K; i++) {
			int S= scan.nextInt();
			int E= scan.nextInt();
			
			arr[S][E]=1;
			}
		
		for(int j=0; j<M; j++) {
			for(int k=0; k<N; k++)	 {
				if(arr[j][k]==1 && visit[j][k] == false) {
					cnt++;
					dfs(j,k);

				}
				
			}
		}
		System.out.println(cnt);
	}

	}
	
	static void dfs(int x, int y) {
		visit[x][y]=true;
		int nextX, nextY;
		for(int i=0; i<4; i++) {
			nextX = x + dx[i];
			nextY = y + dy[i];
			if(nextX>=0 && nextX<M && nextY>=0 && nextY<N) {

			if(arr[nextX][nextY]==1 && visit[nextX][nextY]==false) {
				dfs(nextX, nextY);
			}
			}
		}

	}

}

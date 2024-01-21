package backjoon;
// BFS 미로탐색, 4방향, 최단거리 구하기

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class back_2178 {
	static int N,M;
	static int[][] arr;
	static boolean[][] visit;
	static int count=0;
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N=scan.nextInt();
		M=scan.nextInt();
		arr= new int[N][M];
		visit=new boolean[N][M];

		
		for(int i=0; i<N; i++) {
			String str= scan.next();
			for(int j=0; j<M; j++) {
				arr[i][j]=str.charAt(j)-'0';
			}
		}
		visit[0][0]=true;
		bfs(0,0);
		System.out.println(arr[N-1][M-1]);
	}
	
	static void bfs(int x, int y) {

		Queue<int[]> que= new LinkedList<>();
		que.offer(new int[] {x,y});
		
		while(!que.isEmpty()) {
			int now[]= que.poll();
			int nx = now[0];
			int ny= now[1];
			
			for(int i=0; i<4; i++) {
				int nextX= nx + dx[i];
				int nextY= ny + dy[i];
				
				if(nextX<0 || nextX>=N || nextY<0 || nextY>=M) 
					continue;
					if(arr[nextX][nextY]==1 && visit[nextX][nextY]==false) {
						que.offer(new int[] {nextX,nextY});
						visit[nextX][nextY]=true;
						arr[nextX][nextY]=arr[nx][ny]+1;
					
				}
			}
		}
		
	}
}

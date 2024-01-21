package backjoon;

//DFS 바이러스, 첫번째와 연결된 노드의 개수 구하기
import java.util.Scanner;

public class back_2606 {

	static int N,M,cnt;

	static int[][] arr;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N=scan.nextInt();
		M=scan.nextInt();
		
		arr=new int [N+1][N+1];
		visit=new boolean[N+1];
		for(int i=1; i<N; i++) {
			int S=scan.nextInt();
			int E=scan.nextInt();
			
			arr[S][E]=1;
			arr[E][S]=1;
		}
		
		dfs(1);
		System.out.println(cnt);
	}

	static void dfs(int V) {
		visit[V]=true;


		for(int i=1; i<arr.length; i++) {
			if(arr[V][i]==1 && visit[i]==false) {
				visit[i]=true;
				cnt++;
				dfs(i);
			}
		}
		
	}
}

package backjoon;

// BFS와 DFS 기본
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class BACK_1260 {
	
	static boolean visited[];
	static int arr[][];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		
		int N = scan.nextInt();
		int M = scan.nextInt();
		int V = scan.nextInt();		
		arr= new int[N+1][N+1];

		
		for(int i=0; i<M; i++) {
			int S = scan.nextInt();
			int E = scan.nextInt();
			
			arr[S][E] = 1;
			arr[E][S] = 1;
		}	
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
		
	}
	
	static void dfs(int v) {
		visited[v]=true;
		System.out.print(v +" ");
		
		if(v==arr.length) {
			return;
		}
		for(int j=1; j<arr.length; j++) {
			if(arr[v][j] == 1 && visited[j] == false) {
				dfs(j);
			}
		}
	}
	
	private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.offer(v);
        visited[v] = true;

        System.out.print(v + " ");

        while(!queue.isEmpty()) {
            int n = queue.poll();

			// 노드 하나로 연결된 노드 먼저 다 체크 
            for(int i = 1; i < arr.length; i++) {
           		 // 연결된 노드인데 방문하지 않은 경우 
                if(arr[n][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }
	}
}

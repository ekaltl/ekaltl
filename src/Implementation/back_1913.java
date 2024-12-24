package Implementation;

import java.util.Scanner;
/*
문제 유형 : 구현
 */
public class back_1913 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N =scan.nextInt();  
		int target = scan.nextInt();
		int[][] arr= new int[N][N];
		
		int x =0;
		int y=0;
		int targetX = 0;
		int targetY = 0;
		int Num = N*N;
		
		// 하, 우, 상, 좌
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		int nowPosition =0;
		
		while(Num>0) {
			arr[x][y]=Num;
			if(Num==target) {
				targetX= x+1;
				targetY= y+1;
			}
			Num--;
			
			int nx = x + dx[nowPosition];
			int ny = y + dy[nowPosition];
			
			if(nx<0 || nx >=N || ny <0 || ny>=N || arr[nx][ny] != 0) {
				nowPosition = (nowPosition+1) %4;
				nx = x +dx[nowPosition];
				ny = y +dy[nowPosition];

			}
			x=nx;
			y=ny;
		}
		
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(targetX).append(" ").append(targetY);
        System.out.print(sb.toString());
		
	}

}

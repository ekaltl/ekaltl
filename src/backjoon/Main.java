package backjoon;

import java.util.Scanner;

/* M,N개의 단위 정사각형
   M * N
  */
public class Main {

	static char [][] board ;
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 행
        int M = sc.nextInt(); // 열
        board = new char[N][M];

        // 보드 입력 받기
        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        

        int minChanges = 0;

        // 8x8 체스판으로 자를 수 있는 모든 경우 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minChanges = Math.min(minChanges, );
            }
        }


	}
}

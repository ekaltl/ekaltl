package Implementation;

import java.util.Scanner;

/*
 체스판 다시 칠하기
 문제 유형 : 구현
 브루트포스 알고리즘
 */
public class back_1018 {

	static char [][] arr;
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int M = sc.nextInt();
        arr = new char[N][M];

        for(int i=0; i<N; i++) {
        	String row = sc.next();
        	for(int j=0; j<M; j++) {
        		arr[i][j] = row.charAt(j);
        	}
        }
        int minChanges = Integer.MAX_VALUE; //Integer.MAX_VALUE 는 최소값을 구하기 위한 초기값(2,147,483,647 (2³¹-1))

        // 8x8 체스판으로 자를 수 있는 모든 경우 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minChanges = Math.min(minChanges, countChanges(i, j));
            }
        }

        System.out.println(minChanges);
    }
	
    // 해당 8x8 영역에서 다시 칠해야 할 최소 개수 계산
    static int countChanges(int startX, int startY) {
        int changesForWStart = 0; // 체스판 시작이 'W'인 경우
        int changesForBStart = 0; // 체스판 시작이 'B'인 경우

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char current = arr[startX + i][startY + j];
                // (i + j) % 2 == 0 : W or B 시작 판정
                if ((i + j) % 2 == 0) {
                    if (current == 'W') changesForBStart++; // W이어야 함
                    if (current == 'B') changesForWStart++; // B이어야 함
                } else {
                    if (current == 'B') changesForBStart++; // B이어야 함
                    if (current == 'W') changesForWStart++; // W이어야 함
                }
            }
        }

        // 두 경우 중 최소값 반환
        return Math.min(changesForWStart, changesForBStart);
	}
}

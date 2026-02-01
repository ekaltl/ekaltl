package Implementation;

import java.util.Scanner;
/* 
시각
문제 유형 : 구현
브루트포스 알고리즘 
 */
public class back_18312 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();

		String newK =Integer.toString(K);

		int cnt=0;
		
		
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<N+1; i++) {

			for(int j=0; j<60; j++) {
				for(int kk=0; kk<60; kk++) {
					sb.append(i < 10 ? "0" + i : i);
					sb.append(j < 10 ? "0" + j : j);
					sb.append(kk < 10 ? "0" + kk : kk);
					if(sb.indexOf(newK) != -1) {
						cnt++;
					}
					sb.setLength(0);
				}
			}
		}

		System.out.println(cnt);
	}
}

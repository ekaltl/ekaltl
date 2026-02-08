package brute_force;

import java.util.Scanner;

public class back_18111 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[][] arr;
		
		int N =scan.nextInt(); //가로
		int M = scan.nextInt(); //세로
		int B = scan.nextInt(); // 블럭
		int min = 256;
		int max = 0;

		arr = new int[M][N];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = scan.nextInt();
				
				min = Math.min(min, arr[i][j]);
				max = Math.max(max, arr[i][j]);
			}
		}
		
		int resultTime = Integer.MAX_VALUE;
		int height =0;
		
		for(int h=min; h<=max; h++) {
			int remove = 0;
			int add =0;
			int time=0;
			
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {

					int diff = arr[i][j] - h;
					if(diff > 0) {
						remove += diff;
					}
					else {
						add -= diff;
					}
					
				}
			}
			if(remove +B < add) continue;
			
			time = remove *2 + add;
			if(time < resultTime ||  (time ==resultTime && h> height))
			{
				resultTime = time;
				height = h;
			}
			
		}
		System.out.println(resultTime +" " + height);

		

	}

}

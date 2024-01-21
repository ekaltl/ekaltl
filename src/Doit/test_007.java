package Doit;

//투포인터 양방향

import java.util.Arrays;
import java.util.Scanner;

public class test_007 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N= scan.nextInt();
		int M= scan.nextInt();
		int[] arr= new int[N];
		int cnt=0;

		
		for(int i=0; i<N; i++) {
			arr[i]=scan.nextInt();
		}

		/* 내림차순 int가 아닌 Integer로 변수 선언해야 사용가능
		Integer[] arrs= new Integer[N+1];
		Arrays.sort(arrs, Collections.reverseOrder());
		*/
		
		Arrays.sort(arr); // 오름차순
		
		int start_index=0;
		int end_index=N-1;
		
		while(start_index<end_index) {
			if(arr[start_index]+arr[end_index]<M) {
				start_index++;
				
				System.out.println("시작번호" + arr[start_index]);
				System.out.println("끝" + arr[end_index]);
				System.out.println("--------------");
			}
			
			else if(arr[start_index]+arr[end_index]>M) {
				end_index--;
				
				System.out.println("시작번호" + arr[start_index]);
				System.out.println("끝" + arr[end_index]);
				System.out.println("--------------");
			}
			
			else {
				cnt++;
				start_index++;
				end_index--;
				System.out.println("시작번호" + start_index);
				System.out.println("끝" + end_index);
				System.out.println("카운트" + cnt);
				System.out.println("--------------");
			}

		}
		System.out.println(cnt);
		
		
	}

}

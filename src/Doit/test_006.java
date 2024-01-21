package Doit;

import java.util.Scanner;

// 투포인터 한방향
public class test_006 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int start_index=0;
		int end_index=0;
		int sum=0;
		int cnt=1;
		while(end_index !=N) {
			if(sum==N) {
				cnt++;
				end_index++;
				sum=sum+end_index;
			}
			else if(sum>N) {
				sum=sum-start_index;
				start_index++;
			}
			else {
				end_index++;
				sum=sum+end_index;

			}
		}
		System.out.println(cnt);

	}

}

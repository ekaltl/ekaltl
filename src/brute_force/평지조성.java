package brute_force;
import java.util.*;

public class 평지조성 {
    static int N, W, H;
    static int[][] ground;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();

        ground = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                ground[i][j] = sc.nextInt();

        int answer = Integer.MAX_VALUE;

        // W x H 형태 고려
        answer = Math.min(answer, calculateMinCost(W, H));

        // H x W 형태도 다를 경우 고려
        if (W != H) {
            answer = Math.min(answer, calculateMinCost(H, W));
        }

        System.out.println(answer);
    }

    static int calculateMinCost(int height, int width) {
        int minCost = Integer.MAX_VALUE;

        for (int x = 0; x <= N - height; x++) {
            for (int y = 0; y <= N - width; y++) {

                for (int target = 0; target <= 9; target++) {
                    int dig = 0;   // 깎는 양
                    int fill = 0;  // 쌓는 양

                    for (int i = x; i < x + height; i++) {
                        for (int j = y; j < y + width; j++) {
                            int diff = ground[i][j] - target;

                            if (diff > 0) dig += diff;
                            else fill -= diff;  // diff < 0이므로 음수 제거
                        }
                    }

                    // 깎은 양으로 쌓을 수 있는 만큼은 비용 1, 나머지는 2
                    int reuse = Math.min(dig, fill);
                    int need = fill - reuse;
                    int cost = (dig * 2) + (reuse * 1) + (need * 2);

                    minCost = Math.min(minCost, cost);
                }
            }
        }

        return minCost;
    }
}
package BOJ.dp.boj1101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class plumtree_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);

        int[][] dp = new int[t+1][w+1];

        for(int i=1; i<=t; i++) {
            int tree = Integer.parseInt(br.readLine());

            for(int j=0; j<=w; j++) {
                // 움직임이 없는 경우
                // 나무 1에 떨어지면 1 추가 / 나무 2에 떨어지면 아무일없음
                if(j == 0) {
                    if(tree == 1)
                        dp[i][j] = dp[i-1][j] + 1;
                    else
                        dp[i][j] = dp[i-1][j];

                    continue;
                }

                // 짝수번 움직이면 나무 1
                if(j%2 == 0) {
                    if(tree == 1)
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                    else
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                }

                // 홀수번 움직이면 나무 2
                else {
                    if(tree == 1)
                        dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
                    else
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                }
            }
        }
        int ans = 0;
        for(int i=0; i<=w; i++) {
            ans = Math.max(ans, dp[t][i]);
        }
        System.out.println(ans);
    }
}

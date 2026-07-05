import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int[] timeNum;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        timeNum = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            timeNum[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solve() {
        int n = findTimeNum(timeNum);

        for (int i = n-1; i >= 1111; i--) {
            if (checkTimeNum(i)) ans++;
        }
    }

    // 입력으로 주어진 십자 카드의 수들 중 시계수 찾기
    static int findTimeNum(int[] timeNums) {
        int min = 10000;

        for (int i = 0; i < 4; i++) {
            int j = i;
            StringBuilder sb = new StringBuilder();
            sb.append(timeNums[j]);

            while ((j+1) % 4 != i) {
                sb.append(timeNums[(j+1)%4]);
                j++;
            }

            if (Integer.parseInt(sb.toString()) < min) {
                min = Integer.parseInt(sb.toString());
            }
        }

        return min;
    }

    static boolean checkTimeNum(int timeNum) {
        String num = Integer.toString(timeNum);

        int[] timeNums = new int[4];
        for (int i = 0; i < 4; i++) {
            timeNums[i] = num.charAt(i) - '0';

            // 0은 포함되면 안됨
            if (timeNums[i] == 0) {
                return false;
            }
        }

        return timeNum == findTimeNum(timeNums);
    }

    static void output() throws IOException {
        bw.write((ans+1) + "\n");
        bw.flush();
    }
}

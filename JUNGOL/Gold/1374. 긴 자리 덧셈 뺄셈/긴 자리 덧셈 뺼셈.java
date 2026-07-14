import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static String str1, str2;
    static int maxLen;
    static int[][] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    static void input() throws IOException {
        while (true) {

            str1 = br.readLine().trim();
            str2 = br.readLine().trim();
            if (str1.equals("0") && str2.equals("0")) return;

            maxLen = Math.max(str1.length(), str2.length());
            int maxIdx;
            if (str1.length() > str2.length()) {
                maxIdx = 0;

            } else if (str1.length() < str2.length()) {
                maxIdx = 1;

            } else {
                maxIdx = 2;
            }

            nums = new int[4][maxLen+1];

            if (maxIdx == 0) {
                for (int i = 0; i < maxLen; i++) {
                    nums[0][i+1] = str1.charAt(i) - '0';
                }
                for (int i = maxLen-(str2.length()); i < maxLen; i++) {
                    nums[1][i + 1] = str2.charAt(i - (maxLen - (str2.length()))) - '0';
                }
            } else if (maxIdx == 1) {
                for (int i = 0; i < maxLen; i++) {
                    nums[0][i+1] = str2.charAt(i) - '0';
                }
                for (int i = maxLen-(str1.length()); i < maxLen; i++) {
                    nums[1][i+1] = str1.charAt(i - (maxLen-(str1.length()))) - '0';
                }
            } else {
                if (str1.compareTo(str2) >= 0) {
                    for (int i = 0; i < maxLen; i++) {
                        nums[0][i+1] = str1.charAt(i) - '0';
                        nums[1][i+1] = str2.charAt(i) - '0';
                    }
                } else {
                    for (int i = 0; i < maxLen; i++) {
                        nums[0][i+1] = str2.charAt(i) - '0';
                        nums[1][i+1] = str1.charAt(i) - '0';
                    }
                }
            }

            plus();
            minus();
            solve();

        }
    }

    static void solve() {
        // 덧셈 출력
        boolean isStart = false;
        for (int i = 0; i <= maxLen; i++) {
            if (nums[2][i] != 0) isStart = true;
            if (isStart) sb.append(nums[2][i]);
        }
        if (!isStart) sb.append(0); // 결과가 0인 경우 방어
        sb.append('\n');

        // 뺄셈 출력
        isStart = false;
        for (int i = 0; i <= maxLen; i++) {
            if (nums[3][i] != 0) isStart = true;
            if (isStart) sb.append(nums[3][i]);
        }
        if (!isStart) sb.append(0); // 결과가 0인 경우 방어
        sb.append('\n');
    }

    static void plus() {
        for (int i = maxLen; i > 0; i--) {
            int sum = nums[0][i] + nums[1][i] + nums[2][i];
            if (sum < 10) {
                nums[2][i] = sum;
            } else {
                nums[2][i] = sum - 10;
                nums[2][i-1] += 1;
            }
        }
    }

    static void minus() {
        for (int i = maxLen; i > 0; i--) {
            int sum = nums[0][i] - nums[1][i] + nums[3][i];

            if (sum >= 0) {
                nums[3][i] = sum;
            } else {
                nums[3][i] = sum + 10;
                nums[3][i-1] -= 1;
            }
        }
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


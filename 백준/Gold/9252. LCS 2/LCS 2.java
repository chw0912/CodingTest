import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static char[] A, B;
    static int[][] LCS;
    static int lenA, lenB;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();
        LCS = new int[A.length+1][B.length+1];
        lenA = A.length;
        lenB = B.length;
    }

    static void solve() {
        // 최장 길이 구하기
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (A[i-1] == B[j-1]) {
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }
        sb.append(LCS[lenA][lenB]).append("\n");
        // 문자열 구하기
        String answer = "";
        while (lenA > 0 && lenB > 0) {
            if (A[lenA-1] == B[lenB-1]) {
                answer = A[lenA-1] + answer;
                lenA--;
                lenB--;
            } else {
                if (LCS[lenA-1][lenB] <= LCS[lenA][lenB-1]) {
                    lenB--;
                } else {
                    lenA--;
                }
            }
        }
        sb.append(answer).append("\n");
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}

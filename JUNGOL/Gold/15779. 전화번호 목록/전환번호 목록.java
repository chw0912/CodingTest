// [Gold 5] 전화번호 목록

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int T, N;
    static String[] phone;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            phone = new String[N];

            for (int n = 0; n < N; n++) {
                phone[n] = br.readLine();
            }

            Arrays.sort(phone);
            boolean flag = false;

            for (int i = 0; i < N-1; i++) {
                if (phone[i+1].startsWith(phone[i])) {
                    flag = true;
                    break;
                }
            }

            if(flag) sb.append("NO").append("\n");
            else sb.append("YES").append("\n");
        }
    }

    static void solve() {

    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


// [Gold 3] 1332. 작명하기

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static String S;
    static int len;
    static int[] pi;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        S = br.readLine();
        len = S.length();

        pi = new int[len];
        getPi();

        result.add(len);

    }

    static void solve() {
        int curr = pi[len-1];
        while (curr > 0) {
            result.add(curr);
            curr = pi[curr-1];
        }

        Collections.sort(result);

        for(int l : result) {
            sb.append(l).append(" ");
        }
    }

    // KMP 알고리즘의 실패 함수(pi 배열) 구현
    static void getPi() {
        int j = 0;

        for (int i = 1; i < len; i++) {
            while (j > 0 && S.charAt(i) != S.charAt(j)) {
                j = pi[j - 1];
            }
            if (S.charAt(i) == S.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


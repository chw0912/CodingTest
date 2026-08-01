// [Silver 3] 1034. 단어 맞추기

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static char[] word;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        word = br.readLine().toCharArray();

    }

    static void solve() {
        int lastIdx = word.length - 1;
        int top = lastIdx;

        // 1. 뒤에서부터 꼭대기(오름차순이 깨지는 지점) 찾기
        while (top > 0 && word[top - 1] >= word[top]) {
            top--;
        }

        // 2. 다음 순열이 존재하는 경우 교환 및 뒤집기 수행
        if (top > 0) {
            int pos = lastIdx;
            while (word[top - 1] >= word[pos]) pos--;

            swap(top - 1, pos);

            // 꼭대기 뒷부분을 오름차순으로 정렬(뒤집기)
            while (top < lastIdx) {
                swap(top, lastIdx);
                top++;
                lastIdx--;
            }
        }

        // 3. 최종 상태의 word를 StringBuilder에 담기
        for (char c : word) {
            sb.append(c);
        }
        sb.append('\n');
    }


    static void swap(int i, int j) {
        char temp = word[i];
        word[i] = word[j];
        word[j] = temp;
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


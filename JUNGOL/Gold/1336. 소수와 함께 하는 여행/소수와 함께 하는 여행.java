// [Gold 3] 1336. 소수와 함께 하는 여행

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static final int MAX_SIZE = 10_000, STANDARD = 1_000;
    static int start, end, ans;
    static int[] numbers, visited;
    static boolean[] prime;
    static Queue<Integer> queue = new LinkedList<>(); // 현재 정류장 번호, 다음 정류장 번호, 환승 횟수

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        prime = new boolean[MAX_SIZE];
        visited = new int[MAX_SIZE];


        for (int i = STANDARD; i < MAX_SIZE; i++) {
            if (isPrime(i)) {
                prime[i] = true;
            }
        }

        Arrays.fill(visited, MAX_SIZE);
    }

    static void solve() {
        if (start == end) {
            visited[end] = 0;
            return;
        }
        bfs();
    }

    static void bfs() {

        queue.offer(start);
        visited[start] = 0;

        while (!queue.isEmpty()) {

            int cur = queue.poll();

            // 원더걸스 숙소 도착!
            if (cur == end) {
                break;
            }

            // 다음 정류장 이동
            for (int nxt = STANDARD; nxt < MAX_SIZE; nxt++) {
                // 소수가 아닌 경우
                if (!prime[nxt]) continue;
                // 자릿수의 차이가 1이 아닌 경우
                if (checkDigit(cur, nxt) != 1) continue;

                if (visited[nxt] == MAX_SIZE) {
                    visited[nxt] = visited[cur] + 1;
                    queue.offer(nxt);
                }
            }
        }
    }

    // 각 자리수 별 차이
    static int checkDigit(int cur, int nxt) {
        int diff = 0;

        if (prime[nxt]) {

            // 1000의 자리 판별
            if (cur / 1000 != nxt / 1000) {
                diff++;
            }
            cur %= 1000;
            nxt %= 1000;

            // 100의 자리 판별
            if (cur / 100 != nxt / 100) {
                diff++;
            }
            cur %= 100;
            nxt %= 100;

            // 10의 자리 판별
            if (cur / 10 != nxt / 10) {
                diff++;
            }
            cur %= 10;
            nxt %= 10;

            // 1의 자리 판별
            if (cur  != nxt) {
                diff++;
            }
        }


        return diff;
    }



    // 소수 판별
    static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    static void output() throws IOException {
//        for (int i = 0; i < MAX_SIZE; i++) {
//            bw.write(numbers[i] + " " + prime[i] + "\n");
//        }

//        bw.write(checkDigit(1033, 1009) + "\n");
        bw.write(visited[end] + "\n");
        bw.flush();

    }
}

/**
 * 1. 버스 번호의 범위 1000~9999 사이의 소수
 * 2. 각 자리의 수의 차이가 1인 경우 가능 (소수 판별, 각 자릿수별 차이)
 * 3. 도착지까지 가기 위한 최소 환승 횟수
 */
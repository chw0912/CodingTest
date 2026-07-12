// [Gold 2]. 숫자구슬

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M; // N : 구슬의 개수, M : 그룹의 수
    static int[] beads, groups; // beads : 숫자구슬의 배열, groups : M개의 그룹 별 숫자구슬의 개수
    static int min = Integer.MAX_VALUE, max, ans; // // min : 숫자구슬의 최소값, max : 모든 숫자구슬의 합, ans : M개의 조합의 최대값 중 최소값

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        beads = new int[N];
        groups = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, beads[i]);
            max += beads[i];
        }
    }

    static void solve() {
        ans = search();
    }

    // 이분탐색을 통해 최소값 탐색
    public static int search() {
        int left = min;
        int right = max;

        while (left <= right) {
            int mid = (left + right) / 2;
            // M개의 그룹을 만들 수 있을 때
            if (check(mid)) {
                right = mid - 1;
            } else {
                // M개의 구슬을 만들 수 없을 때
                left = mid + 1;
            }
        }

        return left;
    }

    // 중간값이 최소값이라고 가정할 때
    // M개의 그룹을 만들 수 있는지 확인하는 함수
    public static boolean check(int mid) {
        // 현재 그룹 개수
        int group = 1;
        // 탐색한 숫자구슬 개수
        int beadCount = 0;

        // 현재 그룹의 숫자구슬의 합
        int sum = 0;
        int[] curGroups = new int[M];

        // M개의 그룹을 만들 수 있는지 확인하기
        for (int i = 0; i < N; i++) {
            // 그룹의 개수가 M개보다 크거나, 단일 숫자 구슬이 최소값보다 클 때
            if (group > M || beads[i] > mid) {
                return false;
            }

            // 최소값보다 커졌을 때, 남은 숫자구슬 개수 == 남은 그룹 개수
            if (sum + beads[i] > mid || N-i <= M - group) {
                // 현재 그룹에 속한 숫자구슬 개수 저장
                curGroups[group-1] = beadCount;
                group++;        // 새로운 그룹 생성
                beadCount = 1;  // 새로운 그룹의 숫자구슬 저장
                sum = beads[i]; // 새로운 그룹에 맞는 합 초기화
            } else {
                // 그룹에 숫자구슬 추가
                beadCount++;
                sum += beads[i];
            }
        }

        // M갸의 숫자그룹을 만들 수 없을 때
        if (group > M) {
            return false;
        }

        // M개의 숫자그룹을 만들 수 있을 때
        curGroups[group-1] = beadCount;

        // 현재 M개의 그룹을 만들었을 때 각 그룹의 속한 숫자구슬 개수를 저장
        groups = curGroups;

        return true;
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        for (int i = 0; i < M; i++) {
            bw.write(groups[i] + " ");
        }
        bw.newLine();
        bw.flush();
    }
}


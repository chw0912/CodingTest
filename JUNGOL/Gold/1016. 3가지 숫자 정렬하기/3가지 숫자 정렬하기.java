// [Gold 4] 1016. 3가지 숫자 정렬하기

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] cnt = new int[4]; // 1, 2, 3의 개수

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            cnt[arr[i]]++;
        }

        // 구간별 잘못 위치한 개수를 기록할 배열 [i][j]: i구간에 있는 j의 개수
        int[][] map = new int[4][4];

        int idx = 0;
        // 1번 구간 (0 ~ cnt[1]-1)
        for (int i = 0; i < cnt[1]; i++) {
            map[1][arr[idx++]]++;
        }
        // 2번 구간 (cnt[1] ~ cnt[1]+cnt[2]-1)
        for (int i = 0; i < cnt[2]; i++) {
            map[2][arr[idx++]]++;
        }
        // 3번 구간 (마지막)
        for (int i = 0; i < cnt[3]; i++) {
            map[3][arr[idx++]]++;
        }

        // 1구간에 있는 2와 2구간에 있는 1의 교환 (맞교환)
        int ex12 = Math.min(map[1][2], map[2][1]);
        // 1구간에 있는 3과 3구간에 있는 1의 교환
        int ex13 = Math.min(map[1][3], map[3][1]);
        // 2구간에 있는 3과 3구간에 있는 2의 교환
        int ex23 = Math.min(map[2][3], map[3][2]);

        // 2개씩 맞교환 가능한 횟수 합산
        int totalEx = ex12 + ex13 + ex23;

        // 남은 어긋난 개수 계산
        int rem12 = map[1][2] - ex12;
        int rem13 = map[1][3] - ex13;
        int rem21 = map[2][1] - ex12;
        int rem23 = map[2][3] - ex23;
        int rem31 = map[3][1] - ex13;
        int rem32 = map[3][2] - ex23;

        // 남은 것들은 3개의 숫자가 순환되어 어긋난 상태이므로 (남은 개수 / 3) * 2 만큼 추가 교환 필요
        int remain = rem12 + rem13 + rem21 + rem23 + rem31 + rem32;
        int ans = totalEx + (remain / 3) * 2;

        System.out.println(ans);
    }
}

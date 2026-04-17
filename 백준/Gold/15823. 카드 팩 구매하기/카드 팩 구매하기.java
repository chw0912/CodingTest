import java.io.*;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M; // N : 진열된 카드의 수, M : 주띵이가 구매해야할 카드 팩의 수
    static int[] cards; // 입력으로 주어진 카드 번호
    static int[] visited; // visited[i] = k ->  i : 하나의 카드팩의 카드 수량, k : 구매 가능한 카드팩 수량
    static int ans; // 하나의 카드 팩에 구성할 수 있는 최대 수량

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            cards[n] = Integer.parseInt(st.nextToken());
        }

    }

    static void solve() {
        int left = 1, right = N / M; // left : 한팩의 카드 수량 최소값, right : 한팩의 카드 수량 최대값

        while (left <= right) {
            int mid = (left + right) / 2;

            if (checkCardPack(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
    }

    static boolean checkCardPack(int targetSize) {
        int packCnt = 0;
        int left = 0;
        Set<Integer> currentPack = new HashSet<>();

        for (int right = 0; right < N; right++) {
            int card = cards[right];

            while(currentPack.contains(card)) {
                currentPack.remove(cards[left]);
                left++;
            }

            currentPack.add(card);

            if (currentPack.size() == targetSize) {
                packCnt++;

                currentPack.clear();
                left = right + 1;
            }
        }

        return packCnt >= M;
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


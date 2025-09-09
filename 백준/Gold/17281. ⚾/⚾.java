import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static int[][] players;
    static boolean[] select;
    static int[] lineup;
    static int answer;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        players = new int[N + 1][10]; // [1-based][1-based]

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                players[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        select = new boolean[10];
        lineup = new int[10];

        select[4] = true;
        lineup[4] = 1;

        permutation(2);
        bw.write(String.valueOf(answer));
        bw.flush();

    }

    private static void permutation(int num) {
        if (num == 10) {
            playGame();
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (select[i]) {
                continue;
            }
            select[i] = true;
            lineup[i] = num;
            permutation(num + 1);
            select[i] = false;
        }
    }

    public static void playGame() {
        int score = 0;
        int playerIdx = 0;

        for (int i = 1; i <= N; i++) {
            boolean[] base = new boolean[4];
            int outCount = 0;

            while (outCount < 3) {
                int j = (playerIdx % 9) + 1;
                // 타자
                int batter = players[i][lineup[j]];
                base[0] = true;
                switch (batter) {
                    // 아웃
                    case 0:
                        outCount++;
                        break;
                    // 1루타
                    case 1:
                        // 현재 진루한 선수들을 확인하기 위한 for문
                        // ex) base[2] = true면 2루에 진루한 선수
                        // ex) base[0] = true면 타자
                        for (int k = 3; k >= 0; k--) {
                            // 진루한 선수가 있으면
                            // base[1] = true는 1루에 진루한 선수
                            if (base[k]) {
                                if (k == 3) {
                                    score++;
                                    base[k] = false;
                                    continue;
                                }
                                // 해당 루를 1칸씩 전진하기 위한 로직
                                base[k] = false;
                                base[k + 1] = true;
                            }
                        }
                        break;
                    // 2루타
                    case 2:
                        for (int k = 3; k >= 0; k--) {
                            if (base[k]) {
                                if (k == 3 || k == 2) {
                                    score++;
                                    base[k] = false;
                                    continue;
                                }
                                base[k] = false;
                                base[k + 2] = true;
                            }
                        }
                        break;
                    // 3루타
                    case 3:
                        for (int k = 3; k >= 0; k--) {
                            if (base[k]) {
                                if (k == 3 || k == 2 || k == 1) {
                                    score++;
                                    base[k] = false;
                                    continue;
                                }
                                base[k] = false;
                                base[k + 3] = true;
                            }
                        }
                        break;
                    // 홈런
                    case 4:
                        for (int k = 0; k < 4; k++) {
                            if (base[k]) {
                                score++;
                                base[k] = false;
                            }
                        }
                        break;


                }
                playerIdx++;
            }
        }

        answer = Math.max(answer, score);

    }


}

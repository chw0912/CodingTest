import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int[] A, B, C, D;
    static int[] AB, CD;
    static long ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            A[n] = Integer.parseInt(st.nextToken());
            B[n] = Integer.parseInt(st.nextToken());
            C[n] = Integer.parseInt(st.nextToken());
            D[n] = Integer.parseInt(st.nextToken());
        }
        // 두 개의 배열로 가능한 조합 합치기
        AB = new int[N*N];
        CD = new int[N*N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                AB[(i*N)+j] = A[i] + B[j];
                CD[(i*N)+j] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);
    }

    static void solve() {
        int left = 0;
        int right = (N*N) - 1;

        while(left < N*N && right >= 0) {
            int result = AB[left] + CD[right];
            if(result < 0) {
                left++;
            } else if(result > 0) {
                right--;
            } else {
                long leftCnt = 1, rightCnt = 1;
                while(left + 1 < N*N && (AB[left] == AB[left+1])) {
                    leftCnt++;
                    left++;
                }
                while(right > 0 && (CD[right] == CD[right -1])) {
                    rightCnt++;
                    right--;
                }
                ans += leftCnt * rightCnt;
                left++;
            }
        }


    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


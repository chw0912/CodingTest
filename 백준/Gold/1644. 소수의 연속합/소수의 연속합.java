import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static boolean[] isPrime;
    static ArrayList<Integer> primes = new ArrayList<>();
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        isPrime = new boolean[N+1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        // N까지의 소수 구하기
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j+= i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수 배열에 저장
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

    }

    static void solve() {
        for (int i = 0; i < primes.size(); i++) {
            int sum = 0;
            for (int j = i; j < primes.size(); j++) {
                sum += primes.get(j);

                if (sum > N) {
                    break;
                } else if (sum == N) {
                    ans++;
                }
            }

        }
    }

    static void output() throws IOException {
        bw.write(ans+"\n");
        bw.flush();
    }
}

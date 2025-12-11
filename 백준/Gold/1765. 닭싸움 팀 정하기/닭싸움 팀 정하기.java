import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, M; // 학생의 수, 인간 관계 수
    static ArrayList<ArrayList<Integer>> friend = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> enemy = new ArrayList<>();
    static char relationship;
    static int p, q;
    static final char F = 'F', E= 'E';
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        for ( int n = 0; n <= N; n++ ) {
            friend.add(new ArrayList<>());
            enemy.add(new ArrayList<>());
        }

        for ( int m = 0; m < M; m++ ) {
            st = new StringTokenizer(br.readLine());
            relationship = st.nextToken().charAt(0);
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            if ( relationship == F ) {
                friend.get(p).add(q);
                friend.get(q).add(p);
            } else {
                enemy.get(p).add(q);
                enemy.get(q).add(p);
            }
        }
    }

    static void solve() {
        // 2. 원수의 원수는 친구
        // 예를들어, 1번의 원수가 2명이상이면 그들끼리 친구이다.
        // 해당 학생의 원수들을 친구로 만들기 
        for ( int n = 1; n <= N; n++ ) {
            ArrayList<Integer> e = enemy.get(n);
            for ( int i = 0; i < e.size(); i++ ) {
                p = e.get(i); //
                for ( int j = 0; j < e.size(); j++ ) {
                    q = e.get(j);
                    if ( i == j ) continue;
                    if ( friend.get(p).contains(q)) continue;
                    friend.get(p).add(q);
                }
            }
        }

        //
        for ( int n = 1; n <= N; n++ ) {
            if ( !visited[n] ) {
                dfs(n);
                ans++;
            }
        }
    }

    static void output() throws IOException {
//        for ( int n = 1; n<=N; n++ ) {
//            bw.write(friend.get(n).toString() + "\n");
//        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
    
    // 팀 결성을 위한 dfs
    static void dfs(int x) {
        if (visited[x]) {
            return;
        }

        visited[x] = true;

        for ( int f : friend.get(x) ) {
            dfs(f);
        }
    }
}


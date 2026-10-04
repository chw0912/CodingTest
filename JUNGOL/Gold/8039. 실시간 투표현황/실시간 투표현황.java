// [Gold 5] 8039. 실시간 투표현황

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N, Q;
    static int command;
    static int[] votes;
    static TreeMap<Integer, TreeSet<Integer>> voteMap = new TreeMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        votes = new int[N+1];

        TreeSet<Integer> zeroGroup = new TreeSet<>();

        for (int i = 1; i <= N; i++) {
            zeroGroup.add(i);
        }
        voteMap.put(0, zeroGroup);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());

            if (command == 0) {
                int id = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                int currentScore = votes[id];
                int nextScore = currentScore + v;

                TreeSet<Integer> currentGroup = voteMap.get(currentScore);
                currentGroup.remove(id);
                if (currentGroup.isEmpty()) {
                    voteMap.remove(currentScore);
                }

                votes[id] = nextScore;
                voteMap.computeIfAbsent(nextScore, k -> new TreeSet<>()).add(id);

            } else {
                int v = Integer.parseInt(st.nextToken());

                if (voteMap.containsKey(v) && !voteMap.get(v).isEmpty()) {
                    TreeSet<Integer> targetGroup = voteMap.get(v);
                    for (int id : targetGroup) {
                        sb.append(id).append(" ");
                    }
                } else {
                    sb.append("None");
                }
                sb.append("\n");
            }

        }
    }

    static void solve() {

    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();
    }
}


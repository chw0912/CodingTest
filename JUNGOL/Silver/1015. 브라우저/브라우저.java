// [Silver 1] 1015. 브라우저

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static String command;
    static String curr = "http://www.acm.org/";
    static Stack<String> backwards = new Stack<>();
    static Stack<String> forwards = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        while (true) {
            command = br.readLine().trim();

            // 프로그램 종료
            if (command.equals("QUIT")) {
                break;
            }

            // VISIT 명령어
            if (command.split(" ").length == 2) {
                backwards.push(curr);
                curr = command.split(" ")[1];
                sb.append(curr).append("\n");
                forwards.clear();
            } else {
                // BACKWARD 명령어
                if (command.equals("BACK")) {
                    if (backwards.isEmpty()) {
                        sb.append("Ignored").append("\n");
                        continue;
                    }
                    forwards.push(curr);
                    curr = backwards.pop();
                    sb.append(curr).append("\n");
                } else {
                    // FORWARD 명령어
                    if(forwards.isEmpty()) {
                        sb.append("Ignored").append("\n");
                        continue;
                    }
                    backwards.push(curr);
                    curr = forwards.pop();
                    sb.append(curr).append("\n");
                }
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

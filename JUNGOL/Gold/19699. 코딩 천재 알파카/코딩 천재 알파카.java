// [Gold 2] 19699. 코딩 천재 알파카

import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MAX_LOOP = 10_000_000, INF = 255;

    static char[] commands;
    static int[] shell = new int[30_000];
    static int[] jumpMap; // 괄호 짝꿍의 인덱스를 O(1)로 찾기 위해 미리 저장할 배열
    static int pointer = 0, idx = 0;
    static boolean flag = false;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();

        // 1. 실행 전 문법 오류([ ] 짝 안 맞음)를 먼저 검사합니다.
        checkSyntaxAndMapJumps();

        // 문법 오류가 없다면 실행합니다.
        if (!flag) {
            solve();
        }

        output();
    }

    static void input() throws IOException {
        String line;
        StringBuilder cmdBuilder = new StringBuilder();

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) break;

            for (char c : line.toCharArray()) {
                if (c == '>' || c == '<' || c == '+' || c == '-' || c == '.' || c == '[' || c == ']') {
                    cmdBuilder.append(c);
                }
            }
        }
        commands = cmdBuilder.toString().toCharArray();
    }

    // 💡 조건 1 해결: 문법 오류 검증 및 점프 인덱스 사전 매핑
    static void checkSyntaxAndMapJumps() {
        jumpMap = new int[commands.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == '[') {
                stack.push(i);
            } else if (commands[i] == ']') {
                if (stack.isEmpty()) {
                    flag = true; // 여는 괄호 없이 닫는 괄호가 먼저 나온 경우 (문법 오류)
                    return;
                }
                int match = stack.pop();
                jumpMap[match] = i; // '[' 위치에 ']' 위치 저장
                jumpMap[i] = match; // ']' 위치에 '[' 위치 저장
            }
        }

        if (!stack.isEmpty()) {
            flag = true; // 닫히지 않은 괄호가 남아있는 경우 (문법 오류)
        }
    }

    // 💡 조건 2 해결: 무한 루프 감지 및 O(1) 점프 실행
    static void solve() {
        idx = 0;
        int loop = 0;

        while (idx < commands.length) {
            // 명령을 10,000,000번 실행했는데도 안 끝났다면 무한 루프로 간주
            if (loop == MAX_LOOP) {
                flag = true;
                return;
            }

            switch (commands[idx]) {
                case '>': moveRight(); break;
                case '<': moveLeft(); break;
                case '+': plusShell(); break;
                case '-': minusShell(); break;
                case '.': printShell(); break;
                case '[':
                    if (shell[pointer] == 0) idx = jumpMap[idx];
                    break;
                case ']':
                    if (shell[pointer] != 0) idx = jumpMap[idx];
                    break;
            }
            idx++;
            loop++;
        }
    }

    static void moveRight() {
        pointer++;
        if (pointer == 30_000) pointer = 0;
    }

    static void moveLeft() {
        pointer--;
        if (pointer < 0) pointer = 29_999;
    }

    static void plusShell() {
        if (shell[pointer] == INF) {
            shell[pointer] = 0;
        } else {
            shell[pointer]++;
        }
    }

    static void minusShell() {
        if (shell[pointer] == 0) {
            shell[pointer] = INF;
        } else {
            shell[pointer]--;
        }
    }

    static void printShell() {
        sb.append((char) shell[pointer]);
    }

    static void output() throws IOException {
        // 문법 오류나 무한 루프가 발생했다면 -1 출력
        if (flag) {
            bw.write("-1\n");
        }
        // 정상 종료되었고 출력 내용이 있다면 그대로 출력
        // (sb가 비어있다면 아무것도 출력하지 않는 조건 자동 만족)
        else {
            bw.write(sb.toString());
        }
        bw.flush();
    }
}
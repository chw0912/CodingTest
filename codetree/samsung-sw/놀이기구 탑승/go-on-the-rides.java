import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static StringTokenizer st;
    static int N;
    static int ans;
    static int[] waiting;
    static int[][] board;
    static ArrayList<Student> classRoom = new ArrayList<>(); // 1-based

    // 동, 서, 남, 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] scores = {0, 1, 10, 100, 1000};

    public static class Student {
        int max_Blank, max_Like;
        int[] likeStudent = new int[4];
        int[][] blank_Board, like_Board;

        public Student(int N) {
            blank_Board = new int[N][N];
            like_Board = new int[N][N];
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        waiting = new int[N*N];

        for (int i = 0; i <= N*N; i++) {
            classRoom.add(new Student(N));
        }

        for (int i = 0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int studentNum = Integer.parseInt(st.nextToken());
            waiting[i] = studentNum;

            for (int j = 0; j < 4; j++) {
                classRoom.get(studentNum).likeStudent[j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        simulation();
    }

    static void simulation() {
        for (int num = 0; num < N*N; num++) {
            int student = waiting[num];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 0) {
                        explore(student, i, j);
                    }
                }
            }
            boarding(student);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                total_score(i, j);
            }
        }
    }

    static void total_score(int x, int y) {
        int likeCnt = 0;

        int studentNum = board[x][y];

        Student student = classRoom.get(studentNum);

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            for (int l = 0; l < 4; l++) {
                if (board[nx][ny] == student.likeStudent[l]) {
                    likeCnt++;
                }
            }

        }
        ans += scores[likeCnt];
    }

    static void boarding(int studentNum) {
        Student student = classRoom.get(studentNum);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 && student.like_Board[i][j] == student.max_Like) {
                    if (student.blank_Board[i][j] == calculateMaxBlank(studentNum)) {
                        board[i][j] = studentNum;
                        return;
                    }
                }
            }
        }
    }

    static int calculateMaxBlank(int studentNum) {
        int max = 0;
        Student student = classRoom.get(studentNum);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (student.like_Board[i][j] == student.max_Like) {
                    max = Math.max(max, student.blank_Board[i][j]);
                }
            }
        }

        return max;
    }

    // 주번 탐색
    static void explore(int studentNum, int x, int y) {
        // 현재 위치에 탑승한 학생이 존재하는 경우
        if (board[x][y] != 0) return;
        int blank = 0, like = 0;
        Student student = classRoom.get(studentNum);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 벗어난 경우
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            if (board[nx][ny] == 0) {
                student.blank_Board[x][y]++;
                blank++;
            }
            for (int j = 0; j < 4; j++) {
                // 인접한 칸 중 내가 좋아하는 학생이 있는지 찾기
                if (board[nx][ny] == student.likeStudent[j]) {
                    student.like_Board[x][y]++;
                    like++;
                }
            }
        }
        student.max_Like = Math.max(student.max_Like, like);
    }

    static void output() throws IOException {
        bw.write(ans + "\n");
        bw.flush();
    }
}


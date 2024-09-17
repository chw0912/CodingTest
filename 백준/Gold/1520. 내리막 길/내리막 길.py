# Gold 3. 내리막 길
import heapq
import sys

input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    hq = [(-maps[0][0], 0, 0)]
    dp = [[0] * M for _ in range(N)]
    dp[0][0] = 1

    while hq:
        h, x, y = heapq.heappop(hq)

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M and maps[nx][ny] < maps[x][y]:
                if dp[nx][ny] == 0:
                    heapq.heappush(hq, (-maps[nx][ny], nx, ny))
                dp[nx][ny] += dp[x][y]
    return dp[N-1][M-1]

N, M = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(N)]

print(bfs())
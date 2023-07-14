# Silver 1 2178. 미로 탐색

from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    dq = deque()
    dq.append((x, y))

    while dq:
        x, y = dq.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                if maze[nx][ny] == 1:
                    maze[nx][ny] = maze[x][y] + 1
                    dq.append((nx, ny))
    return maze[N - 1][M - 1]

N, M = map(int, input().split())

maze = [list(map(int, input())) for _ in range(N)]

print(bfs(0,0))


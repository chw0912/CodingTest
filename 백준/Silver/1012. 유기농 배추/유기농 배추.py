# Silver 2. 유기농 배추

from collections import deque

# 동, 서, 남, 북
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(x,y):
    dq = deque()
    dq.append((x, y))
    cnt = 1
    while dq:
        x, y = dq.popleft()
        visited[x][y] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < M and 0 <= ny < N and not visited[nx][ny] and field[nx][ny] == 1:
                cnt += 1
                visited[nx][ny] = True
                dq.append((nx, ny))
    return cnt

# testcase
T = int(input())

for t in range(T):
    # 가로 길이, 세로 길이, 심어져 있는 배추 개수
    M, N, K = map(int, input().split())

    field = [[0 for _ in range(N)] for _ in range(M)]
    visited = [[False for _ in range(N)] for _ in range(M)]

    # 배추 심어져 있는 밭
    cabbage_field = []

    # 배추 좌표 및 심기
    for k in range(K):
        x, y = map(int, input().split())
        field[x][y] = 1

    # 심어져 있는 배추 구하기
    for i in range(M):
        for j in range(N):
            if field[i][j] == 1 and not visited[i][j]:
                cabbage_field.append(bfs(i, j))

    # 배추흰지렁이 마리 수
    print(len(cabbage_field))
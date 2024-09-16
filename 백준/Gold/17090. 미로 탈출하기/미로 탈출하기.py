# Gold 3. 미로 탈출하기

from collections import deque

U = (-1, 0)
R = (0, 1)
D = (1, 0)
L = (0, -1)

# U, D, R, L
dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(x,y):
    dq = deque()
    dq.append((x,y))
    global cnt

    while dq:
        x, y = dq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if maze[nx][ny] == "U" and x == nx - 1 and y == ny + 0:
                    dq.append((nx, ny))
                    cnt += 1
                elif maze[nx][ny] == "D" and x == nx + 1 and y == ny + 0:
                    dq.append((nx, ny))
                    cnt += 1
                elif maze[nx][ny] == "R" and x == nx + 0 and y == ny + 1:
                    dq.append((nx, ny))
                    cnt += 1
                elif maze[nx][ny] == "L" and x == nx + 0 and y == ny - 1:
                    dq.append((nx, ny))
                    cnt += 1


N, M = map(int, input().split())

maze = [list(input()) for _ in range(N)]

visited = [[0 for _ in range(M)] for _ in range(N)]

cnt = 0

for i in range(N):
    for j in range(M):
        if maze[i][j] == "U":
            if i - 1 < 0:
                visited[i][j] = 1
                cnt += 1
        elif maze[i][j] == "R":
            if j + 1 >= M:
                visited[i][j] = 1
                cnt += 1
        elif maze[i][j] == "D":
            if i + 1 >= N:
                visited[i][j] = 1
                cnt += 1
        else:
            if j - 1 < 0:
                visited[i][j] = 1
                cnt += 1

for i in range(N):
    for j in range(M):
        if visited[i][j] == 1:
            bfs(i, j)

print(cnt)
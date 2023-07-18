# Silver 4 10157. 자리배정
from collections import deque

# 우, 하, 좌, 상
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

R, C = map(int, input().split())
K = int(input())
seat = [[0 for _ in range(C)] for _ in range(R)]
dir = 0

dq = deque()
dq.append((0, 0))
seat[0][0] = 1
cnt = R*C-1
i = 0
while i != cnt:
    x, y = dq.popleft()
    nx = x + dx[dir]
    ny = y + dy[dir]

    if 0 <= nx < R and 0 <= ny < C and seat[nx][ny] == 0:
        if seat[nx][ny] == 0:
            seat[nx][ny] += seat[x][y] + 1
            dq.append((nx, ny))
    elif nx == 0 or nx == R - 1 or ny == C - 1 or ny == 0 or seat[nx][ny] != 0:
        dir += 1
        if dir == 4:
            dir = 0
        nx = x + dx[dir]
        ny = y + dy[dir]
        seat[nx][ny] += seat[x][y] + 1
        dq.append((nx, ny))

    i += 1
x,y = 0, 0
if R*C < K:
    print(0)
else:
    for i in range(R):
        for j in range(C):
            if seat[i][j] == K:
                x,y = i+1, j+1
    print(x,y)
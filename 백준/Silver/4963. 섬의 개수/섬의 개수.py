# Silver 2.  섬의 개수
from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, -1, 1]

def bfs(x,y):
    global cnt

    dq = deque()
    dq.append((x, y))


    while dq:
        x,y = dq.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < h and 0 <= ny < w and land[nx][ny] == 1 and visited[nx][ny] == 0:
                dq.append((nx,ny))
                visited[nx][ny] = cnt
    cnt += 1

while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    land = [list(map(int, input().split())) for _ in range(h)]
    visited = [[0 for _ in range(w)] for _ in range(h)]
    cnt = 1

    for i in range(h):
        for j in range(w):
            if land[i][j] == 1 and visited[i][j] == 0:
                bfs(i, j)

    print(cnt-1)
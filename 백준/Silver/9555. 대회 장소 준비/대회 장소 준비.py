# Silver 3 - 9555. 대회 장소 준비
from collections import deque

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

def bfs(x,y):
    dq = deque()
    dq.append((x,y))

    while dq:
        x, y = dq.popleft()
        if maps[x][y] != -1:
            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0 <= nx < N and 0 <= ny < M:
                    if maps[x][y] == maps[nx][ny]:
                        seat[maps[x][y]]= True




T = int(input())

for t in range(T):
    N, M = map(int, input().split())

    seat = [False] * 101

    maps = [list(map(int, input().split())) for _ in range(N)]

    cnt = 1

    lst = []
    for x in range(N):
        for y in range(M):
            bfs(x, y)
    print(seat.count(True))
from collections import deque
def map_check(x, y):
    if maps[x][y] == '.':
        maps[x][y] = 0
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if maps[nx][ny] == '*':
                    maps[x][y] += 1
    return
def bfs(x,y):
    dq = deque()
    dq.append((x,y))
    while dq:
        x, y = dq.popleft()
        if maps[x][y] == 0:
            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < N and 0 <= ny < N:
                    if maps[nx][ny] not in ['*', 'C']:
                        dq.append((nx, ny))
        maps[x][y] = 'C'

# 인접 좌표
dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

T = int(input())
visited = [[0] * 300 for _ in range(300)]
for t in range(1, T+1):
    N = int(input())
    maps = [list(input()) for _ in range(N)]
    cnt = 0

    for x in range(N):
        for y in range(N):
            map_check(x,y)

    for x in range(N):
        for y in range(N):
            if maps[x][y] == 0:
                bfs(x,y)
                cnt += 1


    for i in range(N):
        for j in range(N):
            if str(maps[i][j]).isdigit():
                cnt += 1

    print(f'#{t} {cnt}')








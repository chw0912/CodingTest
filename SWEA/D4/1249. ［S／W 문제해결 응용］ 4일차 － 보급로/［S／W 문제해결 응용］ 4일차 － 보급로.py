from collections import deque

def bfs():
    dq = deque([])
    keys = [[1e9] * N for _ in range(N)]
    keys[0][0] = maps[0][0]
    dq.append((0, 0))

    while dq:
        x,y = dq.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if keys[x][y] + maps[nx][ny] < keys[nx][ny]:
                    keys[nx][ny] = maps[nx][ny] + keys[x][y]
                    dq.append((nx, ny))
    return keys[-1][-1]


# 상, 하, 좌, 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

T = int(input())

for t in range(1, T+1):
    N = int(input())
    maps = [list(map(int, input())) for _ in range(N)]

    print(f'#{t} {bfs()}')
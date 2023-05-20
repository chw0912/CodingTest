# 4301 콩 많이 심기

dx = [-2, 2, 0, 0]
dy = [0, 0, -2, 2]

T = int(input())

for t in range(1, T+1):
    N, M = map(int, input().split())

    maps = [[0] * N for _ in range(M)]
    cnt = 0
    for x in range(M):
        for y in range(N):
            if maps[x][y] == 0:
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0 <= nx < M and 0 <= ny < N:
                        maps[nx][ny] = 1
    for i in range(M):
        cnt += maps[i].count(0)

    print(f'#{t} {cnt}')
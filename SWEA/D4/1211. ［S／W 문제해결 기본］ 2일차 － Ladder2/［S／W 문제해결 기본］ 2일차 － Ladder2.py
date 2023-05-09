import copy
T = 10

for t in range(1, T + 1):
    n = int(input())
    ladders = [list(map(int, input().split())) for _ in range(100)]
    Y = [0] * 100
    # L, R, U
    dx = [0, 0, -1]
    dy = [-1, 1, 0]

    for y in range(100):
        arr = copy.deepcopy(ladders)
        x = 99
        if arr[x][y] == 1:
            while x != 0:
                for i in range(3):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0 <= nx < 100 and 0 <= ny < 100:
                        if arr[nx][ny] == 1:
                            arr[nx][ny] += arr[x][y]
                            x, y = nx, ny
                            break
            Y[y] = arr[0][y]
    ans = set(Y)
    ans.remove(0)
    print(f'#{t} {Y.index(min(ans))}')
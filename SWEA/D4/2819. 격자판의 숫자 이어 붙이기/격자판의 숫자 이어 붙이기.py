def dfs(x, y, s):
    if len(s) == 7:
        result.add(s)
        return

    s = s + arr[x][y]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < 4 and 0 <= ny < 4:
            dfs(nx, ny, s)



# 동, 서, 남, 북
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

T = int(input())

for t in range(1, T+1):
    arr = [list(input().split()) for _ in range(4)]
    result = set()

    for i in range(4):
        for j in range(4):
            dfs(i, j, '')

    print(f'#{t} {len(result)}')

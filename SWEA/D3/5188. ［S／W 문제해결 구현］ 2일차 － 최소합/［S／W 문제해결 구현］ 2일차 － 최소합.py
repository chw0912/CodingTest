# D3. 최소합

T = int(input())

def dfs(x, y, cal):
    global ans

    if x == N-1 and y == N-1:
        ans = min(ans, cal)
        return

    if ans < cal:
        return

    for dx, dy in [(1, 0), (0, 1)]:
        nx = x + dx
        ny = y + dy

        if 0 > nx or nx >= N or 0 > ny or ny >= N:
            continue

        dfs(nx, ny, cal + board[nx][ny])


for t in range(1, T+1):
    N = int(input())
    ans = float('inf')
    board = [list(map(int, input().split())) for _ in range(N)]

    dfs(0,0,board[0][0])

    print(f'#{t} {ans}')
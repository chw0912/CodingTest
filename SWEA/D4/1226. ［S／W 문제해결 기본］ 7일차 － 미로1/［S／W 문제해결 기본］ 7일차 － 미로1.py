# U, D, L, R
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

T = 10

for t in range(1, T+1):
    n = int(input())
    maze = [list(input()) for _ in range(16)]
    ans = 0
    x, y = 0, 0
    for i in range(16):
        for j in range(16):
            if maze[i][j] == '2':
                x, y = i, j

    stack = [(x,y)]
    while stack:
        x,y = stack.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < 16 and 0 <= ny < 16:
                if maze[nx][ny] == '0':
                    stack.append((nx, ny))
                    maze[x][y] = '1'
                elif maze[nx][ny] == '3':
                    ans = 1
                    stack.clear()
                    break

    print(f'#{t} {ans}')
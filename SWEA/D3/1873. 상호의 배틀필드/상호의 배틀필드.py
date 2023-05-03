T = int(input())

for t in range(1, T+1):
    H, W = map(int, input().split())
    field = [list(input()) for _ in range(H)]
    N = int(input())
    commands = list(input())
    #   U, D, L, R
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    x, y = 0, 0

    direction = ['^', 'v', '<', '>']

    move = ['U', 'D', 'L', 'R']

    idx = 0
    for i in range(H):
        for j in range(W):
            if field[i][j] in direction:
                x, y = i, j
                idx = direction.index(field[i][j])


    for c in commands:
        if c == 'S':
            a = 1
            while True:
                nx = x + dx[idx] * a
                ny = y + dy[idx] * a

                if nx < 0 or ny < 0 or nx >= H or ny >= W or field[nx][ny] == '#':
                    break
                elif field[nx][ny] == '*':
                    field[nx][ny] = '.'
                    break
                a += 1

        else:
            idx = move.index(c)
            field[x][y] = direction[idx]
            nx = x + dx[idx]
            ny = y + dy[idx]

            if 0 <= nx < H and 0 <= ny < W:
                if field[nx][ny] == '.':
                    field[nx][ny] = direction[idx]
                    field[x][y] = '.'
                    x, y = nx, ny


    print(f'#{t}',end=' ')
    for f in field:
        print(*f,sep='')


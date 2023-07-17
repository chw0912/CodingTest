# Silver 2 5212. 지구 온난화
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

R, C = map(int, input().split())
board = [list(input()) for _ in range(R)]

for x in range(R):
    for y in range(C):
        cnt = 0
        if board[x][y] == 'X':
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < R and 0 <= ny < C and board[nx][ny] == '.':
                    cnt += 1
                elif 0 > nx or nx >= R or 0 > ny or ny >= C:
                    cnt += 1
            if cnt >= 3:
                board[x][y] = 'O'

x_pos = []
y_pos = []

for x in range(R):
    for y in range(C):
        if board[x][y] == 'O':
            board[x][y] = '.'
        elif board[x][y] == 'X':
            x_pos.append(x)
            y_pos.append(y)

for x in range(min(x_pos),max(x_pos)+1):
    for y in range(min(y_pos),max(y_pos)+1):
        print(board[x][y],end='')
    print()

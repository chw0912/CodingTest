# Gold 4. 지뢰찾기

def dfs(mine):
    global N, result

    while mine:
        x, y = mine.pop()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if (nx == 0 or nx == N-1) or (ny == 0 or ny == N-1):
                if game_Board[nx][ny] == 0:
                    break
        else:
            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]
                if (nx == 0 or nx == N-1) or (ny == 0 or ny == N-1):
                    game_Board[nx][ny] -= 1
            result += 1
    return


# 동, 서, 남, 북, 북서, 북동, 남서, 남동
dx = [0, 0, 1, -1, -1, -1, 1, 1]
dy = [1, -1, 0, 0, -1, 1, -1, 1]

N = int(input())

# 게임판 생성
game_Board = [list(input()) for _ in range(N)]

# 지뢰
mine = []
result = 0

# 테두리와 인접 하지 않은 칸은 모두 지뢰 설정
if N > 4:
    result += (N-4)**2

for x in range(N):
    for y in range(N):
        if x == 1 or x == N-2:
            if game_Board[x][y] == '#':
                mine.append((x, y))
            else:
                game_Board[x][y] = int(game_Board[x][y])
        elif 1 < x < N-2:
            if y == 1 or y == N-2:
                mine.append((x,y))
            else:
                if game_Board[x][y] != '#':
                    game_Board[x][y] = int(game_Board[x][y])
        else:
            if game_Board[x][y] != '#':
                game_Board[x][y] = int(game_Board[x][y])
dfs(mine)
print(result)

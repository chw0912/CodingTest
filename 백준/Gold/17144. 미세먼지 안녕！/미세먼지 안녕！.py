# Gold 4. 미세먼지 안녕!

from collections import deque

# 미세먼지 확산(동시에 일어나야 함)
def spread(x, y, position):
    # 동, 서, 남, 북(4 방향)
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    cnt = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < R and 0 <= ny < C and maps[nx][ny] != -1:
            # 확산된 값을 좌표와 함꼐 저장
            position.append((nx, ny, maps[x][y]//5))
            cnt += 1
    maps[x][y] = maps[x][y] - (maps[x][y] // 5) * cnt

def air_up():
    # 동, 북, 서, 남
    dx = [0, -1, 0, 1]
    dy = [1, 0, -1, 0]

    dir = 0
    before = 0
    x, y = up, 1

    while True:
        nx = x + dx[dir]
        ny = y + dy[dir]
        if x == up and y == 0:
            break
        if nx < 0 or nx >= R or ny < 0 or ny >= C:
            dir += 1
            continue
        maps[x][y], before = before, maps[x][y]
        x = nx
        y = ny


def air_down():
    # 동, 남, 서, 북
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    dir = 0
    before = 0
    x, y = down, 1

    while True:
        nx = x + dx[dir]
        ny = y + dy[dir]
        if x == down and y == 0:
            break
        if nx < 0 or nx >= R or ny < 0 or ny >= C:
            dir += 1
            continue
        maps[x][y], before = before, maps[x][y]
        x = nx
        y = ny


R, C, T = map(int, input().split())

maps = [list(map(int, input().split())) for _ in range(R)]
position = []

up = -1
down = -1

# 공기청정 위치 찾기
for i in range(R):
    if maps[i][0] == -1:
        up = i
        down = i + 1
        break

for t in range(T):
    # 미세먼지 확산
    for i in range(R):
        for j in range(C):
            if maps[i][j] != -1:
                spread(i, j, position)

    # 확산이 동시에 일어난 후 값을 더하기
    while position:
        x, y, value = position.pop()
        maps[x][y] += value

    air_up()
    air_down()

answer = 0
for i in range(R):
    for j in range(C):
        if maps[i][j] != -1:
            answer += maps[i][j]
print(answer)
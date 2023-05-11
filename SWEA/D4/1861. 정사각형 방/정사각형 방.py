from collections import deque

def bfs(x, y, d):
    dq = deque()
    dq.append((x, y))
    cnt = 0
    while dq:
        x, y = dq.popleft()
        cnt += 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if arr[nx][ny] == arr[x][y]+d:
                    dq.append((nx, ny))
    return cnt

# U, D, L, R
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

T = int(input())

for t in range(1, T+1):
    N = int(input())

    arr = [list(map(int, input().split())) for _ in range(N)]

    max_n = 0
    room_num = 0

    for x in range(N):
        for y in range(N):
            for diff in (-1,1):
                tmp = bfs(x, y, diff)
                if tmp > max_n:
                    max_n = tmp
                    room_num = arr[x][y]
                elif tmp == max_n:
                    if arr[x][y] < room_num:
                        room_num = arr[x][y]

    print(f'#{t} {room_num} {max_n}')
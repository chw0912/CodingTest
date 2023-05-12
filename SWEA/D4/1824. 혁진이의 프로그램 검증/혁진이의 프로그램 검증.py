from collections import deque

def bfs(x, y, idx, memory):
    dq = deque()
    dq.append((x, y, idx, memory))
    visited = [[set() for _ in range(C)] for _ in range(R)]

    while dq:
        x, y, idx, memory = dq.popleft()
        point = program[x][y]
        random = False

        if str.isdigit(point):
            memory = int(point)
        elif point in move:
            idx = move.index(point)
        elif point == '.':
            pass
        elif point == '_':
            if memory == 0:
                idx = 0
            elif memory != 0:
                idx = 1
        elif point == '|':
            if memory == 0:
                idx = 3
            elif memory != 0:
                idx = 2
        elif point == '+':
            memory = (memory + 1) % 16
        elif point == '-':
            memory = (memory - 1) % 16
        elif point == '?':
            random = True
        elif point == '@':
            return 'YES'


        # 다음 좌표



        tmp = [0, 1, 2, 3] if random else [idx]
        for idx in tmp:
            if (idx, memory) not in visited[x][y]:
                nx = (x + dx[idx]) % R
                ny = (y + dy[idx]) % C
                dq.append((nx, ny, idx, memory))
                visited[x][y].add((idx,memory))
    return 'NO'

# R, L, U, D
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
move = ['>', '<', '^', 'v']

T = int(input())

for t in range(1, T+1):
    R, C = map(int, input().split())
    program = [list(input()) for _ in range(R)]

    print(f'#{t} {bfs(0, 0, 0, 0)}')
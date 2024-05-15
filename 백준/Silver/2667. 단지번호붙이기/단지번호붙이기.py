# Silver 1. 단지번호붙이기

from collections import deque

# 동, 서, 남, 북
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
def bfs(x,y):
    dq = deque()
    dq.append((x, y))
    cnt = 1

    while dq:
        x, y = dq.popleft()
        visited[x][y] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and maps[nx][ny] == 1:
                cnt += 1
                visited[nx][ny] = True
                dq.append((nx, ny))
    return cnt

N = int(input())

maps = [list(map(int, input())) for _ in range(N)]
visited = [[False for _ in range(N)] for _ in range(N)]

# 아파트 단지
apartment_Complex = []


for i in range(N):
    for j in range(N):
        if not visited[i][j] and maps[i][j] == 1:
            apartment_Complex.append(bfs(i,j))

#오름차순 정렬
apartment_Complex.sort()

print(len(apartment_Complex))
for apart in apartment_Complex:
    print(apart)
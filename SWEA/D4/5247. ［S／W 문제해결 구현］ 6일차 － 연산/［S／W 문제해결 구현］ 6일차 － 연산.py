from collections import deque

# D4. 연산

T = int(input())

for t in range(1, T+1):
    N, M = map(int, input().split())
    ans = 0
    INF = 1_000_000
    visited = [False] * (INF+1)

    dq = deque()
    dq.append((N, 0))

    while dq:
        cur, cnt = dq.popleft()

        if cur == M:
            ans = cnt
            break

        if cur * 2 <= INF and not visited[cur * 2]:
            visited[cur * 2] = True
            dq.append((cur*2, cnt+1))

        if cur + 1 <= INF and not visited[cur + 1]:
            visited[cur + 1] = True
            dq.append((cur+1, cnt+1))

        if cur - 1 >= 0 and not visited[cur - 1]:
            visited[cur - 1] = True
            dq.append((cur-1, cnt+1))

        if cur - 10 >= 0 and not visited[cur - 10]:
            visited[cur - 10] = True
            dq.append((cur-10, cnt+1))


    print(f'#{t} {ans}')
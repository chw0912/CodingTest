def dfs(c, v):
    global ans
    ans = max(ans, len(v))

    for n in graph[c]:
        if n not in v:
            dfs(n, v+[n])

T = int(input())

for t in range(1,T+1):
    N, M = map(int,input().split())
    graph = [[] for _ in range(N+1)]

    for _ in range(M):
        x, y = map(int, input().split())
        graph[x].append(y)
        graph[y].append(x)
    ans = 0

    for i in range(1, N+1):
        dfs(i, [i])

    print(f'#{t} {ans}')
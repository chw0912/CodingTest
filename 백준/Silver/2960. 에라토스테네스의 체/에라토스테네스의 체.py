# Silver 4. 에라토스테네스의 체

N, K = map(int, input().split())

visited = [False] * (N+1)

ans = 0

for i in range(2, N+1):
    for j in range(i, N+1, i):
        if visited[j] != True:
            visited[j] = True
            ans += 1
            if ans == K:
                print(j)
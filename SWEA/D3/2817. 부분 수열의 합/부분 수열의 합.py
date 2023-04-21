def solve(idx, sum):
    global cnt
    if idx >= N:
        return
    temp = sum + A[idx]
    if temp == K:
        cnt += 1

    solve(idx + 1, sum)
    solve(idx + 1, temp)

T = int(input())
for t in range(1,T+1):
    N, K = map(int,input().split())
    A = list(map(int, input().split()))
    cnt = 0
    solve(0, 0)
    print(f'#{t} {cnt}')

T = int(input())

ans = [0]
for t in range(1, T+1):
    A, B, C, D = map(int, input().split())

    time = min(B, D) - max(A, C)

    if time <= 0:
        time = 0
    ans.append(time)
for i in range(1, len(ans)):
    print(f'#{i} {ans[i]}')


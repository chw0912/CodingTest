# Silver 5. 2차원 배열의 합

N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

K = int(input())

ran = [list(map(int, input().split())) for _ in range(K)]



for k in range(K):
    i, j, x, y = ran[k][0]-1, ran[k][1]-1, ran[k][2], ran[k][3]
    ans = 0
    for n in range(i, x):
        for m in range(j, y):
            ans += arr[n][m]
    print(ans)
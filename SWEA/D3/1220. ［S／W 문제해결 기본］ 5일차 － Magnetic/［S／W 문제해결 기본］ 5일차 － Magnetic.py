dx = [1, -1]
dy = [0, 0]

T = 10

for t in range(1, T+1):
    N = int(input())

    arr = [list(map(int,input().split())) for _ in range(N)]
    cnt = 0

    for x in range(N):
        tmp = ''
        for y in range(N):
            if arr[y][x] != 0:
                tmp += str(arr[y][x])
        cnt += tmp.count('12')

    print(f'#{t} {cnt}')
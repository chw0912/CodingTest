T = int(input())

for t in range(1, T+1):
    N = int(input())
    num = [i**2 for i in range(1, N+1)]
    arr = [list(input()) for _ in range(N)]
    x, y = [], []
    cnt = 0
    for i in range(N):
        for j in range(N):
            if arr[i][j] == '#':
                cnt += 1
                x.append(i)
                y.append(j)
    flag = True
    length = 0
    if cnt in num:
        length = int(cnt**0.5)
    else:
        flag = False


    if flag:
        for i in range(length):
            for j in range(length):
                if arr[x[0]+i][y[0]+j] != '#':
                    flag = False
                    break
            if not flag:
                break
    if flag:
        print(f'#{t} yes')
    else:
        print(f'#{t} no')
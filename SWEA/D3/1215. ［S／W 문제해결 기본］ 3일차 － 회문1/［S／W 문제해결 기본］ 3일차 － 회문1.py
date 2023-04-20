for t in range(1, 11):

    N = int(input())

    arr = [list(input()) for _ in range(8)]

    row = arr
    col = list(zip(*arr))

    cnt = 0
    for i in range(8):
        for j in range(0,8-N+1):
            tmp1 = ''.join(row[i][j:j+N])
            tmp2 = ''.join(col[i][j:j+N])
            if tmp1 == tmp1[::-1]:
                cnt += 1
            if tmp2 == tmp2[::-1]:
                cnt += 1
    print(f'#{t} {cnt}')
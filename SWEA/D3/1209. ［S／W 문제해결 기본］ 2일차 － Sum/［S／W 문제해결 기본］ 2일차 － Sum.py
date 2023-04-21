for t in range(1,11):

    num = input()

    arr = [list(map(int, input().split())) for _ in range(100)]

    row = arr
    col = list(zip(*arr))
    dig_l = []
    dig_r = []
    ans = []
    for n in range(100):
        ans.append(sum(row[n]))
        ans.append(sum(col[n]))
        dig_l.append(arr[n][n])
        dig_r.append(arr[n][-(n+1)])
    print(f'#{t} {max(max(ans),sum(dig_l),sum(dig_r))}')


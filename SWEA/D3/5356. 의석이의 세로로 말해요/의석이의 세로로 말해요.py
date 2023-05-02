T = int(input())

for t in range(1, T+1):
    ans = [list(input()) for _ in range(5)]

    col = ''
    max_len = 0
    for i in range(len(ans)):
        max_len = max(max_len, len(ans[i]))

    for i in range(max_len):
        for j in range(5):
            if len(ans[j]) > i:
                col += (ans[j][i])

    print(f'#{t} {col}')
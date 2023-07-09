# Silver 5 1652. 누울 자리를 찾아라

N = int(input())
room = [list(input()) for _ in range(N)]

cols = list(room)
rows = list(map(list,zip(*room)))

impossible_col = 0
impossible_row = 0
for i in range(N):
    col_cnt = 0
    row_cnt = 0
    for j in range(N):
        if cols[i][j] == '.':
            col_cnt += 1
        elif cols[i][j]=='X':
            if col_cnt >= 2:
                impossible_col += 1
            col_cnt = 0
        if rows[i][j] == '.':
            row_cnt += 1
        elif rows[i][j] == 'X':
            if row_cnt >= 2:
                impossible_row += 1
            row_cnt = 0
        if j == N-1:
            if col_cnt >= 2:
                impossible_col += 1
            if row_cnt >= 2:
                impossible_row += 1

print(impossible_col,impossible_row)

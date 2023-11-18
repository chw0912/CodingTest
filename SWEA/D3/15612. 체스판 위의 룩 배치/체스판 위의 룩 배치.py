#15612. 체스판 위의 룩 배치
T = int(input())

def count():
    row = [0, 0, 0, 0, 0, 0, 0, 0]
    col = [0, 0, 0, 0, 0, 0, 0, 0]
    cnt = 0

    for i in range(8):
        for j in range(8):
            if rook[i][j] == 'O':
                row[i] += 1
                col[j] += 1
                cnt += 1
                if row[i] >= 2 or col[j] >= 2:
                    return False
    if cnt == 8:
        return True
    else:
        return False

for t in range(1,T+1):
    rook = [list(input().strip()) for _ in range(8)]

    if count():
        print(f'#{t} yes')
    else:
        print(f'#{t} no')

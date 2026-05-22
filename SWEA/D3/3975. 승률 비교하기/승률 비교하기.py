
# D3. 승률 비교하기

T = int(input())

ans = []

for t in range(1, T+1):
    A, B, C, D = map(int, input().split())

    ALICE = A/B
    BOB = C/D

    if ALICE == BOB:
        ans.append('DRAW')
    elif ALICE < BOB:
        ans.append('BOB')
    else:
        ans.append('ALICE')

for i in range(len(ans)):
    print(f'#{i+1} {ans[i]}')
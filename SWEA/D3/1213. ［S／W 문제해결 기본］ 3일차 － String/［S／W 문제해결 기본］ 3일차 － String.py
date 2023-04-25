T = 10

for t in range(1, T+1):
    N = int(input())
    tc = input()
    ex = input()

    a = ex.find(tc)
    cnt = 1
    while ex[a+1:].find(tc) != -1:
            a = ex[a+1:].find(tc) + a + 1
            cnt += 1
    print(f'#{t} {cnt}')
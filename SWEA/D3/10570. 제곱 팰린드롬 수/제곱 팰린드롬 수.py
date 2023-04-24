T = int(input())

for t in range(1, T+1):
    A, B = map(int, input().split())
    cnt = 0

    for i in range(A, B+1):
        if i**0.5 % 1 == 0 and str(i) == str(i)[::-1] and str(int(i**0.5)) == str(int(i**0.5))[::-1]:
            cnt += 1
            

    print(f'#{t} {cnt}')
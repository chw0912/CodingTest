def danjo(n):
    n = str(n)
    for i in range(len(n)-1):
        if n[i] > n[i+1]:
            return 0
    return 1

T = int(input())

for t in range(1,T+1):
    N = int(input())
    A = list(map(int, input().split()))

    max_num = 0
    for i in range(N-1):
        for j in range(i+1,N):
            num = A[i] * A[j]
            if danjo(num):
                max_num = max(num,max_num)
        if max_num == 0:
            max_num = -1
    print(f'#{t} {max_num}')


T = int(input())
s = []
for t in range(1, T+1):
    n = input()

    while len(n) != 1:
        fn = 0
        for i in n:
            fn += int(i)
        n = str(fn)
    s.append(n)
for t in range(0,T):
    print(f'#{t+1} {s[t]}')

# 최대 상금

def dfs(n):
    global ans

    if n == count:
        ans = max(ans, int(''.join(map(str, lst))))
        return

    for i in range(L-1):
        for j in range(i+1, L):
            lst[i], lst[j] = lst[j], lst[i]
            chk = int(''.join(map(str, lst)))*10 + n
            if chk not in v:
                dfs(n+1)
                v.append(chk)
            lst[i], lst[j] = lst[j], lst[i]


T = int(input())

for t in range(1, T+1):
    numbers, count = map(int, input().split())
    lst = list(str(numbers))
    L = len(lst)
    v = []
    ans = 0
    dfs(0)

    print(f"#{t} {ans}")





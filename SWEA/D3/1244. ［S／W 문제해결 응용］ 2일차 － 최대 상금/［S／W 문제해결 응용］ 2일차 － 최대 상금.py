# D3. 최대 상금

def dfs(n):
    global ans
    
    if n == changes:
        ans = max(ans, int(''.join(map(str,lst))))
        return

    for i in range(L-1):
        for j in range(i+1, L):
            lst[i], lst[j] = lst[j], lst[i]
            chk = int(''.join(lst)) * 10 + n
            
            if chk not in v:
                dfs(n+1)
                v.append(chk)
            
            lst[i], lst[j] = lst[j], lst[i]


T = int(input())

for t in range(1, T + 1):

    numbers, changes = map(int, input().split())

    lst = list(str(numbers))
    ans = 0
    L = len(lst)
    v = []
    dfs(0)
    
    print(f'#{t} {ans}')
T = int(input())

def dfs(index, sum_flavor = 0, sum_kal=0):
    global max_flavor
    if sum_kal > L:
        return
    if max_flavor < sum_flavor:
        max_flavor = sum_flavor
    if index == N:
        return
    flavor, kal = kal_list[index]
    dfs(index+1,sum_flavor + flavor, sum_kal +kal)
    dfs(index+1, sum_flavor, sum_kal)

for t in range(1,T+1):
    N, L = map(int, input().split())
    kal_list = [list(map(int, input().split())) for i in range(N)]
    max_flavor = 0
    dfs(0)
    print(f'#{t} {max_flavor}')
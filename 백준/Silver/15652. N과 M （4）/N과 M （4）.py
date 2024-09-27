# Silver 3. N과 M (4)
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
combi = []


def dfs(start):
    if len(combi) == M:
        print(' '.join(map(str, combi)))
        return
    
    for i in range(start, N+1):
        combi.append(i)
        dfs(i)
        combi.pop()


dfs(1)
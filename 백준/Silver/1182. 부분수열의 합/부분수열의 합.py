# Silver 2. 부분수열의 합
import sys
from itertools import combinations
input = sys.stdin.readline

N, S = map(int, input().split())

num_list = list(map(int, input().split()))
cnt = 0

for i in range(1, N+1):
    combination = combinations(num_list, i)

    for combi in combination:
        if sum(combi) == S:
            cnt += 1

print(cnt)
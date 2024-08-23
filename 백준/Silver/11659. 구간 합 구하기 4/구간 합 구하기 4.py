# Silver 3. 구간 합 구하기 4
import sys

N,M = map(int, sys.stdin.readline().split())

numbers = list(map(int, sys.stdin.readline().split()))
sum = [0]
tmp = 0

for num in numbers:
    tmp = tmp + num
    sum.append(tmp)

for _ in range(M):
    i, j = map(int, sys.stdin.readline().split())
    print(sum[j] - sum[i-1])
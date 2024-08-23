# Silver 4. ATM
import sys

input = sys.stdin.readline

N = int(input())
times = sorted(list(map(int, input().split())))
result = 0

for i in range(N):
    result += times[i] * (N-i)

print(result)
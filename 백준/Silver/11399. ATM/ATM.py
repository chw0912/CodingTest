# Silver 4. ATM
import sys

input = sys.stdin.readline

N = int(input())
times = sorted(list(map(int, input().split())))
sum = 0
tmp = 0

for time in times:
    tmp = tmp + time
    sum += tmp

print(sum)
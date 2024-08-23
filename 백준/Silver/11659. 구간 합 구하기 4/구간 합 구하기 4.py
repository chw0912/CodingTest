# Silver 3. 구간 합 구하기 4
import sys

N, M = map(int, sys.stdin.readline().split())

numbers = [0] + list(map(int, sys.stdin.readline().split()))

for i in range(1, N+1):
    numbers[i] += numbers[i-1]

for _ in range(M):
    i, j = map(int, sys.stdin.readline().split())
    print(numbers[j] - numbers[i-1])
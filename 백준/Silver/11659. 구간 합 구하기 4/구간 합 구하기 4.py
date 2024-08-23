# Silver 3. 구간 합 구하기 4
import sys
input = sys.stdin.readline
N, M = map(int, input().split())

numbers = [0] + list(map(int, input().split()))

for i in range(1, N+1):
    numbers[i] += numbers[i-1]

for _ in range(M):
    i, j = map(int, input().split())
    print(numbers[j] - numbers[i-1])